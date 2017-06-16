package banking;

import clientData.Account;
import clientData.Passport;
import clientData.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *Created by Saego on 13.06.2017.
 */
public class TrackerMenu {

    private Input input;
    private Tracker tracker;

    TrackerMenu(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private Map<String, Actions> operations = new HashMap<String, Actions>();

    /**
     * Initialisation map of actions by key-words.
     */
    void initMenu(){
        operations.put("add client", new AddClient());
        operations.put("Show client's list", new Show());
        operations.put("Show client accounts", new ShowAccounts());
        operations.put("add account to client", new AddAccount());
        operations.put("remove client", new RemoveClient());
        operations.put("remove account", new RemoveAccount());
        operations.put("transfer money", new TransferMoney());
        operations.put("rename client", new RenameClient());
        operations.put("help", new Help());
    }

    private void chooseKey(String key){
        if (this.operations.containsKey(key)){
            this.operations.get(key).execute();
        }
        else {
            System.out.println("Error input!");
        }
    }

    void start(){
        this.operations.get("help").execute();
        chooseKey(input.ask("Input key please"));
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
         */
        public void execute() {
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
         */
        public void execute() {
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

        public void execute() {
            String serial = input.ask("Input passport serial");
            Integer number = Integer.valueOf(input.ask("Input passport number"));
            User user = tracker.getUsrByPassport(new Passport(serial, number));
            tracker.removeClient(user);
        }
    }

    private class RemoveAccount implements Actions {
        public String actionName() {
            return "Remove account by #";
        }

        public void execute() {
            long requisites = Long.parseLong(input.ask("Input requisites"));
            String serial = input.ask("Input passport serial");
            Integer number = Integer.valueOf(input.ask("Input passport number"));
            User user = tracker.getUsrByPassport(new Passport(serial, number));
            tracker.removeAccount(user, tracker.getAccount(user, requisites));
        }
    }

    private class TransferMoney implements Actions {
        public String actionName() {
            return "Transfer money";
        }

        public void execute() {

        }
    }

    private class RenameClient implements Actions {
        public String actionName() {
            return "Change client's name or passport";
        }

        public void execute() {

        }
    }

    private class Show implements Actions {
        public String actionName() {
            return "List of clients";
        }

        public void execute() {
            for (User client:
                 tracker.getAllClients()) {
                System.out.printf("%s client", client);
            }
        }
    }

    private class ShowAccounts implements Actions {
        public String actionName() {
            return "Account list";
        }

        public void execute() {
            String serial = input.ask("Input passport serial");
            Integer number = Integer.valueOf(input.ask("Input passport number"));
            User user = tracker.getUsrByPassport(new Passport(serial, number));
            if (user != null){
                for (Account account:
                     tracker.clientAccounts(user)) {
                    System.out.printf("%s account - %s", user, account);
                }
            }
        }
    }

    private class Help implements Actions {
        public String actionName() {
            return "Hot keys";
        }

        public void execute() {
                System.out.println("_____________________________________________________________________");
            for (Map.Entry<String, Actions> act:
                 operations.entrySet()) {
                System.out.printf("|%22s| - %42s|%n", act.getKey(), act.getValue().actionName());
                System.out.println("---------------------------------------------------------------------");
            }
        }
    }
}
