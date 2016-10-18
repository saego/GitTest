package start;

import moduls.Comment;
import moduls.Item;

import java.util.Date;

/**
 Created by ${Ruslan} on 04.10.16.

 */
public class StartUI {
    public Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    void start(){
        process();
    }

    public static void main(String []args){
        Input input = new ConsoleInput();
        new StartUI(input).start();
    }

    /*public static void main(String []args){
        ConsoleInput consoleInput = new ConsoleInput();
        consoleInput.title();
        consoleInput.start();
    }*/



    //    public class InnerMenu{
    private Tracker tracker = new Tracker();
    //Scanner scanner = new Scanner(System.in);

    //public String inputData(String question) {
    //    System.out.println(question);
    //    return scanner.next();
    //}

    void process(){
        boolean flag1 = false;
        while (!flag1) {
            menu();
            System.out.println();
            //System.out.println("Input key (1, 2, 3, 4, 5, 6, 7)");
            //String key = scanner.next();
            String key = input.inputData("Input key (1, 2, 3, 4, 5, 6, 7, 8, 9)");
            if (key.equals("1")) {
                add();
            } else if (key.equals("2")) {
                show();
            } else if (key.equals("3")) {
                update();
            } else if (key.equals("4")) {
                search();
            } else if (key.equals("5")) {
                remove();
            } else if (key.equals("6")) {
                addComment();
            } else if(key.equals("7")){
                System.out.println();
                //System.out.println("Input client name, you are looking for");
                //String clientSearchName = scanner.next();
                String clientSearchName = input.inputData("Input client name, you are looking for");
                searchByName(clientSearchName);
            } else if(key.equals("8")){
                System.out.println();
                //System.out.println("Input key for search description");
                //String keyDescription = scanner.next();
                String keyDescription = input.inputData("Input key for search description");
                searchByDescription(keyDescription);
            } else if(key.equals("9")){
                flag1 = true;
            } else{
                System.out.println("Invalid key! Try again");
            }
        }
    }

    // public void inputData(){}

    void menu(){
        System.out.println("***MENU***");
        System.out.println();
        System.out.println("1: Add new application");
        System.out.println("-------------------");
        System.out.println();
        System.out.println("2: Show all applications");
        System.out.println("-------------------");
        System.out.println();
        System.out.println("3: Update application");
        System.out.println("----------------");
        System.out.println();
        System.out.println("4: Search application by Id");
        System.out.println("----------------------");
        System.out.println();
        System.out.println("5: Remove application by Id");
        System.out.println("----------------------");
        System.out.println();
        System.out.println("6: Add comment by client Id");
        System.out.println("---------------------------");
        System.out.println();
        System.out.println("7: Search application by client's name");
        System.out.println("---------------------------");
        System.out.println();
        System.out.println("8: Search application by description");
        System.out.println("---------------------------");
        System.out.println();
        System.out.println("9: Exit");
        System.out.println("-------");
    }

    void add(){
        System.out.println("__You are going to add new application!__");
        //System.out.println("Please input client's name");
        //String name = scanner.next();
        String name = input.inputData("Please input client's name");
        //System.out.println("Please input description");
        //String description = scanner.next();
        String description = input.inputData("Please input description");
        Date date = new Date();
        Item item = new Item(name, date.getTime(), description);
        tracker.addClient(item);
    }

    void show(){
        System.out.println("__All applications__");
        //System.out.println("***Applications list***");
        for (Item getItem:
                tracker.getAll()) {
            if(getItem != null){

                System.out.println();
                System.out.println(getItem.toString());
                System.out.println("_______________");
                for (Comment comment:
                        getItem.getComments()){
                    if(comment != null){
                        System.out.println("-" + comment.getComment());
                    }
                }
            }
        }
    }

    void update(){
        System.out.println("__You are going to update application by client's Id__");
        //System.out.println("Input new name");
        //String  newName = scanner.next();
        String newName = input.inputData("Input new name");
        //System.out.println("Input client's Id");
        //String id = scanner.next();
        String id = input.inputData("Input client's Id");
        //System.out.println("Input new description");
        //String newDescription = scanner.next();
        String newDescription = input.inputData("Input new description");
        Date date = new Date();
        Item item = new Item(newName, date.getTime(), newDescription);
        item.setClientId(id);
        tracker.rename(item);
    }

    void search(){
        System.out.println("__You are looking for application by Id__");
        //System.out.println("Input client's Id");
        //String id = scanner.next();
        String id = input.inputData("Input client's Id");
        System.out.println(tracker.findById(id).toString());
    }

    void remove(){
        System.out.println("__You are giong to remove application by Id__");
        //System.out.println("Inpit client's Id");
        //String id = scanner.next();
        String id = input.inputData("Input client's Id");
        tracker.remove(id);
    }

    void addComment(){
        System.out.println("__You are going to add new comment to application__");
        //System.out.println("Input comment");
        //String commentary = scanner.next();
        String commentary = input.inputData("Input comment");
        Comment comment = new Comment(commentary);
        //System.out.println("Input client'c Id to add comment");
        //String id = scanner.next();
        String id = input.inputData("Input client'c Id to add comment");
        tracker.addComment(comment, id);
    }

    public void searchByName(String  clientSearchName) {
        System.out.println();
        //System.out.println("Input client name, you are looking for");
        //String clientSearchName = scanner.next();
        boolean flag2 = true;
        for (Item getItem :
                tracker.getAll()) {
            if (getItem != null && getItem.getName().equals(clientSearchName)) {
                System.out.println(getItem.toString());
                for (Comment comment :
                        getItem.getComments()) {
                    if (comment != null) {
                        System.out.println("-" + comment.getComment());
                    }
                    flag2 = false;
                }
            }
            if (flag2) {
                System.out.println("No mutches found");
            }
        }
    }

    void searchByDescription(String keyDescription){
        System.out.println();
        //System.out.println("Input key for search description");
        //String keyDescription = scanner.next();
        boolean flag3 = false;
        for (Item item:
                tracker.getAll())
            if (item != null && item.getDescription().contains(keyDescription)) {
                System.out.println(item.toString());
                for (Comment comment:
                        item.getComments()){
                    if(comment != null) {
                        System.out.println("-" + comment.getComment());
                    }
                    flag3 = true;
                }
                if(!flag3){
                    System.out.println("No mutches found");
                }
            }
    }
}
    /*

    private Tracker tracker = new Tracker();
    private Date date = new Date();

    public static void main(String[] args) {
        StartUI start = new StartUI();
        start.addClients();
        start.searchClients();
        start.removeClients();
        start.updateClient();
        start.addComments();
    }
        private void addClients(){

            Item[] items = new Item[6];
        items[0] = new Item("Oxana", date.getTime(), "description 1");
        items[1] = new Item("Owen", date.getTime(), "description 2");
        items[2] = new Item("Mike", date.getTime(), "description 3");
        items[3] = new Item("Nick", date.getTime(), "description 4");
        items[4] = new Item("Mike", date.getTime(), "description 5");
        items[5] = new Item("Johnathan", date.getTime(), "description 6");

            System.out.println("                                       " +
                    " ______/Add clients and show all clients/______");
            for (Item item:
                 items) {
                tracker.addClient(item);
            }
            System.out.println();
            System.out.println("________* Client Base *________");
            System.out.println();
            for (Item trackerItems:
                 tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println(trackerItems.toString());
                    System.out.println("*-*-*");
                }
            }
            System.out.println("                                       " +
                    " ______/End of table/______");
            System.out.println();
        }

        private void searchClients(){

            System.out.println("                                       " +
                    " ______/Search client by Id/______");
            String clientId = tracker.getAll()[3].getClientId();
            System.out.println();
            System.out.println("________* Look what I've found *________");
            System.out.println();
            System.out.println(tracker.findById(clientId).toString());
            System.out.println("*-*-*");
            System.out.println("                                       " +
//                    " ______/End of table/______");
            System.out.println();
        }

        private void removeClients(){

            System.out.println("                                       " +
                    " ______/Remove client by Id/______");
            String clientId = tracker.getAll()[4].getClientId();
            System.out.println();
            System.out.println("________* Look what I've done *________");
            System.out.println();
            tracker.remove(clientId);
            for (Item trackerItems:
                    tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println(trackerItems.toString());
                    System.out.println("*-*-*");
                }
            }
            System.out.println("                                       " +
       //            " ______/End of table/______");
            System.out.println();
        }

        private void addComments(){

            Comment []comments = new Comment[5];
            comments[0] = new Comment("comment 1");
            comments[1] = new Comment("comment 2");
            comments[2] = new Comment("comment 3");
            comments[3] = new Comment("comment 4");
            comments[4] = new Comment("comment 5");

            tracker.addComment(comments[0], tracker.getAll()[3].getClientId());
            tracker.addComment(comments[1], tracker.getAll()[3].getClientId());
            tracker.addComment(comments[2], tracker.getAll()[1].getClientId());
            tracker.addComment(comments[3], tracker.getAll()[0].getClientId());
            tracker.addComment(comments[4], tracker.getAll()[0].getClientId());

            System.out.println("                                       " +
                    " ______/Add comments/______");
            System.out.println();
            System.out.println("________* Look what I've done *________");
            System.out.println();
            for (Item trackerItems:
                    tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println(trackerItems.toString());
                    for (Comment comment :
                            trackerItems.getComments()) {
                        if (comment != null) {
                            System.out.println(" - " + comment.getComment());
                        }
                    }
                    System.out.println("*-*-*");
                }

            }
            System.out.println("                                       " +
     //               " ______/End of table/______");
       //     System.out.println();
        //}

      /*  private void updateClient(){
            System.out.println("                                       " +
                    " ______/Update client by Id/______");
            String clientId = tracker.getAll()[2].getClientId();
            System.out.println();
            System.out.println("________* Look what I've done *________");
            System.out.println();
            String newName = "Mike";
            long newDate = date.getTime();
            String newDescription = "description 12";
            Item newItem = new Item(newName, newDate, newDescription);
            newItem.setClientId(clientId);
            tracker.rename(newItem);
            for (Item trackerItems:
                    tracker.getAll()) {
                if(trackerItems != null){
                    System.out.println(trackerItems.toString());
                    System.out.println("*-*-*");
                }
            }
            System.out.println("                                       " +
                    " ______/End of table/______");
            System.out.println();

        }
}*/