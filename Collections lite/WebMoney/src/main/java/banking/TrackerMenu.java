package banking;

import clientData.Account;
import clientData.Passport;
import clientData.User;

import java.util.HashMap;
import java.util.Map;

/**
 *Created by Saego on 13.06.2017.
 */
class TrackerMenu {

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
        operations.put("Add client", new AddClient());
        operations.put("Show client list", new Show());
        operations.put("Show accounts", new ShowAccounts());
        operations.put("Add account to client", new AddAccount());
        operations.put("Remove client", new RemoveClient());
        operations.put("Remove account", new RemoveAccount());
        operations.put("Transfer money", new TransferMoney());
        operations.put("Rename client", new RenameClient());
        operations.put("Help", new Help());
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
        this.operations.get("Help").execute();
        String key = input.ask("Input key please");
        while (!key.equals("Exit")){
        chooseKey(key);
        key = input.ask("Input key please");
        }
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
            String passroptSerialS = input.ask("Input passport serial of source client");
            Integer passportNumberS = Integer.valueOf(input.ask("Input passport number of source client"));
            long accountSRequisites = Long.parseLong(input.ask("Input source requisites"));
            String passportSerialD = input.ask("Input passport serial of destination client");
            Integer passportNumberD = Integer.valueOf(input.ask("Input number of destination client"));
            long accountDRequisites = Long.parseLong(input.ask("Input destination requisites"));
            Integer transfer = Integer.valueOf(input.ask("Input money for transfer"));
            if (
            tracker.transferMoney(
                    tracker.getUsrByPassport(new Passport(passroptSerialS, passportNumberS)),
                    tracker.getAccount(tracker.getUsrByPassport(new Passport(passroptSerialS, passportNumberS)),accountSRequisites),
                    tracker.getUsrByPassport(new Passport(passportSerialD, passportNumberD)),
                    tracker.getAccount(tracker.getUsrByPassport(new Passport(passportSerialD, passportNumberD)), accountDRequisites), transfer
            )
                    ){
                System.out.println("Transfer finished with good result");
            }
            else System.out.println("Can't do transfer");
        }
    }

    private class RenameClient implements Actions {
        public String actionName() {
            return "Change client's name or passport";
        }

        public void execute() {
            String name = input.ask("Input client name you want to change");
            String passportSerial = input.ask("Input client passport seial you want to change");
            Integer passportNumber = Integer.valueOf(input.ask("Input client passport number you want to change"));
            User user = new User(name, new Passport(passportSerial, passportNumber));
            name = input.ask("Input new name");
            passportSerial = input.ask("Input new passport serial");
            passportNumber = Integer.valueOf(input.ask("Input new passport number"));
            tracker.updateUser(user, new User(name, new Passport(passportSerial, passportNumber)));
        }
    }

    private class Show implements Actions {
        public String actionName() {
            return "List of clients";
        }

        public void execute() {
            for (User client:
                 tracker.getAllClients()) {
                System.out.printf("%s%n", client);
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
                System.out.printf("%s%n", user);
                System.out.println("_________________________________________________");
                for (Account account:
                     tracker.clientAccounts(user)) {
                    System.out.printf("|%s32%n|", account);
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
