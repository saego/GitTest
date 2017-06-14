package banking;

import java.util.HashMap;
import java.util.Map;

/**
 *Created by Saego on 13.06.2017.
 */
public class TrackerMenu {

    private Input input;
    private Tracker tracker;

    public TrackerMenu(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private Map<String, Actions> operations = new HashMap<String, Actions>();

    public void initMenu(){
        operations.put("add client", new AddClient());
        operations.put("add account to client", new AddAccount());
        operations.put("remove client", new RemoveClient());
        operations.put("remove account", new RemoveAccount());
        operations.put("tranfer money", new TransferMoney());
    }

    private class AddClient implements Actions {
        public String actionName() {
            return "Add client name and passport";
        }

        public void execute(String data) {

        }
    }

    private class AddAccount implements Actions {
        public String actionName() {
            return "Add new finance account to client";
        }

        public void execute(String data) {

        }
    }

    private class RemoveClient implements Actions {
        public String actionName() {
            return "Remove client by name";
        }

        public void execute(String data) {

        }
    }

    private class RemoveAccount implements Actions {
        public String actionName() {
            return "Remove account by #";
        }

        public void execute(String data) {

        }
    }

    private class TransferMoney implements Actions {
        public String actionName() {
            return "Transfer money";
        }

        public void execute(String data) {

        }
    }
}
