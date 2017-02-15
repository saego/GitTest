package Client;

import java.util.HashMap;
import java.util.Map;

/**
 Created by Saego on 13.02.2017.
 */
public class MenuClient {
    private Input input;
    private ClientApp app;
    private ClientAction []clientAction = new ClientAction[3];

    public MenuClient(Input input, ClientApp app) {
        this.input = input;
        this.app = app;
    }

    Map<String, ClientAction> actionMap = new HashMap<String, ClientAction>();
    void fillAction(){
        actionMap.put("enter", new EnterFolder());
        actionMap.put("out", new ExitFolder());
        actionMap.put("exit", new ExitApp());
    }

    private class EnterFolder implements ClientAction {

        public String command() {

            return "enter";
        }

        public void execute(Input input, ClientApp clientApp) {
            String task = input.command("Input command");
            String dirName = input.dirName("Input Directory name");
        }

        public String info() {
            return null;
        }
    }

    private class ExitFolder implements ClientAction {

        public String command() {
            return "out";
        }

        public void execute(Input input, ClientApp clientApp) {
            String task = input.command("Input command");
        }

        public String info() {
            return null;
        }
    }


    private class ExitApp implements ClientAction {

        public String command() {
            return "exit";
        }

        public void execute(Input input, ClientApp clientApp) {

        }

        public String info() {
            return null;
        }
    }
}
