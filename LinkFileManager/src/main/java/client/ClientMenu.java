package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
class ClientMenu {
    private String way;

    private DataInputStream in;
    private DataOutputStream out;

    private Map<String, ClientActions> clientActionsHashMap = new HashMap<String, ClientActions>();

    ClientMenu(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    void fillClientActions(){
        this.clientActionsHashMap.put("enter", new EnterFolder());
        this.clientActionsHashMap.put("back", new BackFile());
        this.clientActionsHashMap.put("show", new ShowList());
        this.clientActionsHashMap.put("help", new Help());
        this.clientActionsHashMap.put("exit", new ExitApp());
    }

    void select(ToDo toDo) throws IOException {
        if (clientActionsHashMap.containsKey(toDo.getKeyToDo())){
            this.clientActionsHashMap.get(toDo.getKeyToDo()).execute(toDo);
        }
    }


    private class EnterFolder implements ClientActions{

        public String commandName() {
            return "enter";
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
            return "back";
        }

        public void execute(ToDo value) throws IOException {
            out.writeUTF(value.getKeyToDo());
            way = in.readUTF();

        }
    }

    private class Help implements ClientActions {
        public String commandName() {
            return "help";
        }

        public void execute(ToDo value) {
            System.out.println("This is help");
            System.out.println(way);
        }
    }

    private class ExitApp implements ClientActions {
        public String commandName() {
            return "exit";
        }

        public void execute(ToDo value) {
            System.out.println("Exit from app");
        }
    }

    private class ShowList implements ClientActions {
        public String commandName() {
            return "show";
        }

        public void execute(ToDo value) throws IOException {
            out.writeUTF(value.getKeyToDo());
        }
    }
    /*
    public String enterFolder(String folderName) {
        File file = new File(folderName);
        String []fileList = file.list();
        way = file.getAbsolutePath();
        String list = Arrays.toString(fileList);
        return list;
    }

    public String exitFolder(String folderName){
        File file = new File(folderName);
        String []fileList = file.getParentFile().list();
        way = file.getParentFile().getAbsolutePath();
        String list = Arrays.deepToString(fileList);
        return list;
    }
    */
}
