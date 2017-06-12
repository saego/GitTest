package start;

import moduls.Comment;
import moduls.Item;

import java.util.Date;
import java.util.Scanner;

/**
 Created by ${Ruslan} on 07.10.16.

 */
public class StartUIConsole implements Input {

    //public InnerMenu innerMenu = new InnerMenu();

    private void title(){
        System.out.println("Hello user!");
        System.out.println();
    }

    private void start(){
        process();
    }

    public static void main(String []args){
        StartUIConsole startUIConsole = new StartUIConsole();
        startUIConsole.title();
        startUIConsole.start();
    }

        private Tracker tracker = new Tracker();
        private Scanner scanner = new Scanner(System.in);

        public String inputData(String question) {
            System.out.println(question);
            return scanner.nextLine();
        }

        private void process(){
            boolean flag1 = false;
            while (!flag1) {
                menu();
                System.out.println();
                String key = inputData("Input key (1, 2, 3, 4, 5, 6, 7, 8, 9)");
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
                    String clientSearchName = inputData("Input client name, you are looking for");
                    searchByName(clientSearchName);
                } else if(key.equals("8")){
                    System.out.println();
                    String keyDescription = inputData("Input key for search description");
                    searchByDescription(keyDescription);
                } else if(key.equals("9")){
                    flag1 = true;
                } else{
                    System.out.println("Invalid key! Try again");
                }
            }
        }

        private void menu(){
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

        private void add(){
            System.out.println("__You are going to add new application!__");
            String name = inputData("Please input client's name");
            String description = inputData("Please input description");
            Date date = new Date();
            Item item = new Item(name, date.getTime(), description);
            tracker.addClient(item);
        }

        private void show(){
            System.out.println("__All applications__");
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

        private void update(){
            System.out.println("__You are going to update application by client's Id__");
            String newName = inputData("Input new name");
            String id = inputData("Input client's Id");
            String newDescription = inputData("Input new description");
            Date date = new Date();
            Item item = new Item(newName, date.getTime(), newDescription);
            item.setClientId(id);
            tracker.rename(item);
        }

        private void search(){
            System.out.println("__You are looking for application by Id__");
            String id = inputData("Input client's Id");
            System.out.println(tracker.findById(id).toString());
        }

        private void remove(){
            System.out.println("__You are giong to remove application by Id__");
            String id = inputData("Input client's Id");
            tracker.remove(id);
        }

        private void addComment(){
            System.out.println("__You are going to add new comment to application__");
            String commentary = inputData("Input comment");
            Comment comment = new Comment(commentary);
            String id = inputData("Input client'c Id to add comment");
            tracker.addComment(comment, id);
        }

        private void searchByName(String clientSearchName) {
            System.out.println();
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

        private void searchByDescription(String keyDescription){
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
                System.out.println("No matches found");
            }
        }
    }
}
