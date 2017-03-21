package client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
class ClientMenu {
    private String way;
    String userFolder = "User";

    private DataInputStream in;
    //private DataOutputStream out;

    private Map<String, ClientActions> clientActionsHashMap = new HashMap<String, ClientActions>();

    ClientMenu(DataInputStream in) {
        this.in = in;
        //this.out = out;
    }

    void fillClientActions(){
        this.clientActionsHashMap.put("cd", new EnterFolder());
        this.clientActionsHashMap.put("back", new BackFile());
        this.clientActionsHashMap.put("list", new ShowList());
        this.clientActionsHashMap.put("help", new Help());
        this.clientActionsHashMap.put("exit", new ExitApp());
        this.clientActionsHashMap.put("download", new Download());
    }

    void select(ToDo toDo) throws IOException {
        if (clientActionsHashMap.containsKey(toDo.getKeyToDo())){
            this.clientActionsHashMap.get(toDo.getKeyToDo()).execute(toDo);
        }
        else {
            System.out.println("Invalid key!");
            this.clientActionsHashMap.get("help").execute(toDo);
        }
    }


    private class EnterFolder implements ClientActions{

        public String commandName() {
            return "cd <folder name> - Enter folder";
        }

        public void execute(ToDo value) throws IOException {
            way = in.readUTF();
            boolean isExist = in.readBoolean();
            if (isExist) {
                System.out.println(way);
            }
            else {
                System.out.println("File doesn't exist");
                System.out.println(way);
            }
        }
    }

    private class BackFile implements ClientActions {
        public String commandName() {
            return "back - Back to parent folder";
        }

        public void execute(ToDo value) throws IOException {
            boolean isExist = in.readBoolean();
            if (!isExist){
                System.out.println("This is root");
            }
            way = in.readUTF();
            System.out.println(way);
        }
    }

    private class Help implements ClientActions {
        public String commandName() {
            return "help - help for commands";
        }

        public void execute(ToDo value) {
            System.out.println("This is help:");
            for (Map.Entry<String, ClientActions> clientAct:
                 clientActionsHashMap.entrySet()) {
                System.out.println(clientAct.getValue().commandName());
            }
        }
    }

    private class ExitApp implements ClientActions {
        public String commandName() {
            return "exit - Exit from App";
        }

        public void execute(ToDo value) {
            System.out.println("Exit from app");
        }
    }

    private class ShowList implements ClientActions {
        public String commandName() {
            return "list - Show directories inside folder";
        }

        public void execute(ToDo value) throws IOException {
            boolean isDir = in.readBoolean();
            if (!isDir){
                System.out.println("This is file");
            }
            else {
                int quantity = in.readInt();
                if (quantity == 0) {
                    System.out.println("Folder is empty");
                }
                else {
                    boolean []isFolder = new boolean[quantity];
                    String []names = new String[quantity];
                    for (int i = 0; i < isFolder.length; i++){
                        names[i] = in.readUTF();
                        isFolder[i] = in.readBoolean();
                    }
                    for (int n = 0; n < names.length; n++){
                        if (isFolder[n]){
                            System.out.println("[" + names[n] + "]");
                        }
                        else {
                            System.out.println(names[n]);
                        }
                    }
                }
            }
            way = in.readUTF();
            System.out.println(way);
        }
    }

    private class Download implements ClientActions {
        public String commandName() {
            return "download <file name> - Download file from server";
        }

        public void execute(ToDo value) throws IOException {
            File userF = new File(userFolder);
            userF.exists();
            boolean isExits = in.readBoolean();
            way = in.readUTF();
            System.out.println(way);
            if (isExits){
                boolean isFolder = in.readBoolean();
                if (!isFolder){
                    int fileSize = in.readInt();
                    System.out.println("FileSize: " + fileSize + " bytes");
                    int bufferFile = in.readInt();
                    //System.out.println("BufferSize" + bufferFile);
                    String loadFileName = value.getTarget();
                    String separator = System.getProperty("file.separator");
                    String createDownUp = userF.getAbsolutePath().concat(separator).concat(loadFileName);
                    File file = new File(createDownUp);
                    if (fileSize > bufferFile){
                        int sends = in.readInt();
                        int divTale = in.readInt();
                        //System.out.println("Quantity of sends" + sends);
                        //System.out.println("Tale's size" + divTale);
                        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
                            byte []buffer = new byte[bufferFile];
                            for (int i = 0; i < sends; i++){
                                in.read(buffer, 0, buffer.length);
                                bos.write(buffer, 0, buffer.length);
                            }
                            if (divTale != 0){
                                byte []tailBuffer = new byte[divTale];
                                in.read(tailBuffer, 0, tailBuffer.length);
                                bos.write(tailBuffer, 0, tailBuffer.length);
                            }
                            bos.flush();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    else {
                        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
                            byte []buffer = new byte[bufferFile];
                            in.read(buffer, 0, buffer.length);
                            bos.write(buffer, 0, buffer.length);
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    System.out.println("Copy finished!");
                }
            }
        }
    }
}
