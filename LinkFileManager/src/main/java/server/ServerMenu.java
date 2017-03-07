package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
@SuppressWarnings("Since15")
public class ServerMenu {

    //private Path path;
    File file = new File("TestDir1");
    public String way = file.getAbsolutePath();
    private DataInputStream in;
    private DataOutputStream out;


    private Map<String, ServerActions> serverActionsHashMap = new HashMap<String, ServerActions>();

    public ServerMenu(DataOutputStream out, DataInputStream in) {
        //this.path = Paths.get(System.getProperty("pathDir.dir"));
        this.in = in;
        this.out = out;
    }

    public void fillServerActions(){
        this.serverActionsHashMap.put("enter", new EnterFolder());
        this.serverActionsHashMap.put("out", new ExitFolder());
        this.serverActionsHashMap.put("show", new ShowList());
        this.serverActionsHashMap.put("exit", new ExitApp());
    }

    public void choose(ToDo toDo) throws IOException {
        if (serverActionsHashMap.containsKey(toDo.getKeyToDo())){
            this.serverActionsHashMap.get(toDo.getKeyToDo()).execute(toDo);
        }
    }

    private class EnterFolder implements ServerActions{

        public String commandName() {
            return "enter";
        }

        public void execute(ToDo value) throws IOException {

        }

    }

    private class ExitFolder implements ServerActions {

        public String commandName() {
            return "out";
        }

        public void execute(ToDo value) {

        }
    }

    private class ExitApp implements ServerActions {

        public String commandName() {
            return "exit";
        }

        public void execute(ToDo value) {

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
