package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 Created by ${Ruslan} on 23.01.17.
 */
public class ServerMenu {

    private Path path;

    private DataInputStream in;
    private DataOutputStream out;


    private Map<String, ServerActions> actionsMap = new HashMap<String, ServerActions>();

    public ServerMenu(DataOutputStream out, DataInputStream in) {
        this.path = Paths.get(System.getProperty("pathDir.dir"));
        this.in = in;
        this.out = out;
    }

    public void fillActions(){
        this.actionsMap.put("enter", new EnterFolder);
        this.actionsMap.put("out", new ExitFolder);
        this.actionsMap.put("exit", new ExitApp);
    }

    public void choose(String command, String param){
        if (actionsMap.containsKey(command)){
            this.actionsMap.get(command).execute(param);
        }
    }
}
