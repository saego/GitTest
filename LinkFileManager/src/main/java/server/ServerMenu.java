package server;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
@SuppressWarnings("Since15")
class ServerMenu {

    //private Path path;
    File file = new File("TestDir1");
    String way = file.getAbsolutePath();
    String newWay, root = way;
    private String separator = System.getProperty("file.separator");
    //String separator = "rr";

    private DataInputStream in;
    private DataOutputStream out;


    private Map<String, ServerActions> serverActionsHashMap = new HashMap<String, ServerActions>();

    ServerMenu(DataInputStream in, DataOutputStream out) {
        //this.path = Paths.get(System.getProperty("pathDir.dir"));
        this.in = in;
        this.out = out;
    }

    void fillServerActions(){
        this.serverActionsHashMap.put("cd", new EnterFolder());
        this.serverActionsHashMap.put("back", new ExitFolder());
        this.serverActionsHashMap.put("list", new ShowList());
        this.serverActionsHashMap.put("exit", new ExitApp());
        this.serverActionsHashMap.put("download", new Download());
    }

    void select(ToDo toDo) throws IOException {
        if (serverActionsHashMap.containsKey(toDo.getKeyToDo())){
            this.serverActionsHashMap.get(toDo.getKeyToDo()).execute(toDo);
        }
    }
    public String getWay(way){
        return this.way;
    }

    private class EnterFolder implements ServerActions{

        public String commandName() {
            return "cd";
        }

        public void execute(ToDo value) throws IOException {
            System.out.println(System.getProperty("os.name"));
            newWay = way.concat(separator).concat(value.getTarget());
            //if (new File(newWay).exists()) {
                File file = new File(newWay);
            //}
            if (file.exists()){
                out.writeUTF(newWay);
                way = newWay;
                out.writeBoolean(true);
            }
            else {
                out.writeUTF(way);
                out.writeBoolean(false);
            }
        }

    }

    private class ExitFolder implements ServerActions {

        public String commandName() {
            return "back";
        }

        public void execute(ToDo value) throws IOException {
            File file1 = new File(way);
            boolean isExist = false;
            String parent = null;
            if (file1.getParentFile().exists() && !way.equals(root)){
                isExist = true;
                parent = file1.getParent();
            }
            out.writeBoolean(isExist);
            if (isExist){
                way = parent;
            }
            out.writeUTF(way);
        }
    }

    private class ExitApp implements ServerActions {

        public String commandName() {
            return "exit";
        }

        public void execute(ToDo value) throws IOException {

        }
    }

    private class ShowList implements ServerActions {
        public String commandName() {
            return "list";
        }

        public void execute(ToDo value) throws IOException {
            File fl = new File(way);
            boolean isDir;
            if (fl.isDirectory()) {
                isDir = true;
            }
            else {
                isDir = false;
            }
            out.writeBoolean(isDir);
            if (isDir) {
                File[] files = fl.listFiles();
                int quantity = 0;
                if (files != null) {
                    quantity = files.length;
                }
                out.writeInt(quantity);
                if (quantity != 0) {
                    for (File file1 :
                            files) {
                        out.writeUTF(file1.getName());
                        if (file1.isDirectory()) {
                            out.writeBoolean(true);
                        } else {
                            out.writeBoolean(false);
                        }
                    }
                }
            }
            out.writeUTF(way);
        }
    }

    private class Download implements ServerActions {
        public String commandName() {
            return "download";
        }

        public void execute(ToDo value) throws IOException {
            File file = new File(way);
            FileInputStream fis = new FileInputStream(file);
            int fileSize = fis.available();
        }
    }
}
