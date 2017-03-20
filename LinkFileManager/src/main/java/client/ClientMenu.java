package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
class ClientMenu {
    private String way;

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
            return "cd - Enter folder";
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
            return "list";
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
}
