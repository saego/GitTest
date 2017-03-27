package client;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
class ClientMenu {
    private String way;
    private File userF = new File("User");
    private String separator = System.getProperty("file.separator");
    private int sends, divTail;

    private DataInputStream in;
    private DataOutputStream out;


    private Map<String, ClientActions> clientActionsHashMap = new HashMap<>();

    ClientMenu(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
        //userF = userFolder;
    }

    //private File userF = new File(userFolder != null ? userFolder : "User");

    void fillClientActions(){
        this.clientActionsHashMap.put("cd", new EnterFolder());
        this.clientActionsHashMap.put("back", new BackFile());
        this.clientActionsHashMap.put("list", new ShowList());
        this.clientActionsHashMap.put("help", new Help());
        this.clientActionsHashMap.put("exit", new ExitApp());
        this.clientActionsHashMap.put("download", new Download());
        this.clientActionsHashMap.put("upload", new Upload());
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
            boolean isExits = in.readBoolean();
            way = in.readUTF();
            System.out.println(way);
            if (isExits){
                boolean isFolder = in.readBoolean();
                if (!isFolder){
                    int fileSize = in.readInt();
                    System.out.println("FileSize: " + fileSize + " bytes");
                    int bufferFile = in.readInt();
                    String loadFileName = value.getTarget();
                    String createDownloadF = userF.getAbsolutePath().concat(separator).concat(loadFileName);
                    File file = new File(createDownloadF);
                    if (fileSize > bufferFile){
                        sends = in.readInt();
                        divTail = in.readInt();
                        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))){
                            byte []buffer = new byte[bufferFile];
                            for (int i = 0; i < sends; i++){
                                in.read(buffer, 0, buffer.length);
                                bos.write(buffer, 0, buffer.length);
                            }
                            if (divTail != 0){
                                byte []tailBuffer = new byte[divTail];
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
            else {
                System.out.println("File doesn't exist");
            }
        }
    }

    private class Upload implements ClientActions {
        @Override
        public String commandName() {
            return "upload <file name> - Upload file to server";
        }

        @Override
        public void execute(ToDo value) throws IOException {
            String uploadFileName = value.getTarget();
            String createUploadF = userF.getAbsolutePath().concat(separator).concat(uploadFileName);
            System.out.println(createUploadF);
            if (new File(createUploadF).exists()){
                //System.out.println("Exist");
                out.writeBoolean(true);
                boolean isDirectory = false;
                if (new File(createUploadF).isDirectory()){
                    System.out.println("This is directory");
                    isDirectory = true;
                }
                out.writeBoolean(isDirectory);
                if (!isDirectory){
                    File file = new File(createUploadF);
                    int fileSize = (int) file.length();
                    System.out.println("FileSize: " + fileSize + " bytes");
                    int bufferFile = in.readInt();
                    out.writeInt(fileSize);
                    if (fileSize > bufferFile){
                        out.writeBoolean(false);
                        divTail = fileSize % bufferFile;
                        sends = (fileSize - divTail) / bufferFile;
                        out.writeInt(sends);
                        out.writeInt(divTail);
                        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                            byte[] buffer = new byte[bufferFile];
                            for (int i = 0; i < sends; i++) {
                                bis.read(buffer, 0, buffer.length);
                                out.write(buffer, 0, buffer.length);
                            }
                            if (divTail != 0){
                                byte []tailBuffer = new byte[divTail];
                                bis.read(tailBuffer, 0, tailBuffer.length);
                                out.write(tailBuffer, 0, tailBuffer.length);
                            }
                            bis.close();
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    else {
                        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
                            out.writeBoolean(true);
                            byte []buffer = new byte[fileSize];
                            bis.read(buffer, 0, buffer.length);
                            out.write(buffer, 0, buffer.length);
                        }
                        catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                }
                System.out.println("File was uploaded");
            }
            else {
                out.writeBoolean(false);
                System.out.println("Doesn't exist");
            }
        }
    }
}
