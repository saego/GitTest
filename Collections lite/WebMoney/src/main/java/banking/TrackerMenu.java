package banking;

import clientData.Account;
import clientData.Passport;
import clientData.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

    /**
     * Initialisation map of actions by key-words.
     */
    public void initMenu(){
        operations.put("add client", new AddClient());
        operations.put("Show client's list", new Show());
        operations.put("add account to client", new AddAccount());
        operations.put("remove client", new RemoveClient());
        operations.put("remove account", new RemoveAccount());
        operations.put("transfer money", new TransferMoney());
        operations.put("rename client", new RenameClient());
    }

    /**
     * Add new client inner class.
     */
    private class AddClient implements Actions {
        /**
         * Name of Action.
         * @return - name for menu.
         */
        public String actionName() {
            return "Add client name and passport";
        }

        /**
         * Adding new client action.
         * @param data - client name, passport.
         */
        public void execute(String data) {
            String usrName = input.ask("Client name");
            String passportSerial = input.ask("Input passport serial");
            Integer passportNumber = Integer.valueOf(input.ask("Input passport number"));
            tracker.addClient(new User(usrName, new Passport(passportSerial, passportNumber)));
        }
    }

    /**
     * Add new account to client inner class.
     */
    private class AddAccount implements Actions {
        /**
         * Name of action.
         * @return - name for menu.
         */
        public String actionName() {
            return "Add new finance account to client";
        }

        /**
         * Adding new account to client action.
         * @param data -
         */
        public void execute(String data) {
            String passportSerial = input.ask("Input passport serial");
            Integer passportNumber = Integer.valueOf(input.ask("Input passport number"));
            Passport passport = new Passport(passportSerial, passportNumber);
            User user = tracker.getUsrByPassport(passport);
            if (user == null){
                System.out.println("Client not found");
            }
            else {
                Integer money = Integer.valueOf(input.ask("Input money value"));
                long requisites = System.currentTimeMillis()/100;
                tracker.addAccount(user, new Account(money, requisites));
            }
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

    private class RenameClient implements Actions {
        public String actionName() {
            return "Change client's name or passport";
        }

        public void execute(String data) {

        }
    }

    private class Show implements Actions {
        public String actionName() {
            return "List of clients";
        }

        public void execute(String data) {

        }
    }
}
