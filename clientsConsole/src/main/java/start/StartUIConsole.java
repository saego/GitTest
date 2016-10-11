package start;

import moduls.Comment;
import moduls.Item;

import java.util.Date;
import java.util.Scanner;

/**
 Created by ${Ruslan} on 07.10.16.

 */
public class StartUIConsole {

    private InnerMenu innerMenu = new InnerMenu();

    private void title(){
        System.out.println("Hello user!");
        System.out.println();
    }

    private void start(){
        innerMenu.process();
    }

    public static void main(String []args){
        StartUIConsole startUIConsole = new StartUIConsole();
        startUIConsole.title();
        startUIConsole.start();
    }
    private class InnerMenu{
        private Tracker tracker = new Tracker();
        Scanner scanner = new Scanner(System.in);

        void process(){
            boolean flag1 = false;
            while (!flag1) {
                menu();
                System.out.println();
                System.out.println("Input key (1, 2, 3, 4, 5, 6, 7)");
                String key = scanner.next();
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
                    searchByName();
                } else if(key.equals("8")){
                    searchByDescription();
                } else if(key.equals("9")){
                    flag1 = true;
                } else{
                    System.out.println("Invalid key! Try again");
                }
            }
        }

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
            System.out.println("Please input client's name");
            String name = scanner.next();
            System.out.println("Please input description");
            String description = scanner.next();
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
            System.out.println("Input new name");
            String  newName = scanner.next();
            System.out.println("Input client's Id");
            String id = scanner.next();
            System.out.println("Input new description");
            String newDescription = scanner.next();
            Date date = new Date();
            Item item = new Item(newName, date.getTime(), newDescription);
            item.setClientId(id);
            tracker.rename(item);
        }

        void search(){
            System.out.println("__You are looking for application by Id__");
            System.out.println("Input client's Id");
            String id = scanner.next();
            System.out.println(tracker.findById(id).toString());
        }

        void remove(){
            System.out.println("__You are giong to remove application by Id__");
            System.out.println("Inpit client's Id");
            String id = scanner.next();
            tracker.remove(id);
        }

        void addComment(){
            System.out.println("__You are going to add new comment to application__");
            System.out.println("Input comment");
            String commentary = scanner.next();
            Comment comment = new Comment(commentary);
            System.out.println("Input client'c Id to add comment");
            String id = scanner.next();
            tracker.addComment(comment, id);
        }

        void searchByName(){
            System.out.println();
            System.out.println("Input client name, you are looking for");
            String clientSearchName = scanner.next();
            boolean flag2 = true;
            for (Item getItem:
                 tracker.getAll()) {
                if(getItem != null && getItem.getName().equals(clientSearchName)){
                    System.out.println(getItem.toString());
                    flag2 = false;
                }
            }
            if (flag2){
                System.out.println("No mutches found");
            }
        }

        void searchByDescription(){
            System.out.println();
            System.out.println("Input key for search description");
            String keyDescription = scanner.next();
            boolean flag3 = false;
            for (Item item:
                 tracker.getAll()) {
                if(item != null && item.getDescription().contains(keyDescription)){
                    System.out.println(item.toString());
                    flag3 = true;
                }
            }
            if(!flag3){
                System.out.println("No mutches found");
            }
        }
    }
}
