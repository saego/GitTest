package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
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
    String newWay;
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
        this.serverActionsHashMap.put("out", new ExitFolder());
        this.serverActionsHashMap.put("show", new ShowList());
        this.serverActionsHashMap.put("exit", new ExitApp());
    }

    void select(ToDo toDo) throws IOException {
        if (serverActionsHashMap.containsKey(toDo.getKeyToDo())){
            this.serverActionsHashMap.get(toDo.getKeyToDo()).execute(toDo);
        }
    }

    private class EnterFolder implements ServerActions{

        public String commandName() {
            return "cd";
        }

        public void execute(ToDo value) throws IOException {
            System.out.println(System.getProperty("os.name"));
            newWay = way.concat(separator).concat(value.getTarget());
            File file = new File(newWay);
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
            return "out";
        }

        public void execute(ToDo value) throws IOException {

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
            return "show";
        }

        public void execute(ToDo value) {

        }
    }
}
