package start;

import com.sun.demo.jvmti.hprof.Tracker;

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
    public class InnerMenu{
        private Tracker tracker = new Tracker();
       // private Date date = new Date();
        public Scanner scanner = new Scanner(System.in);

        public void process(){
            System.out.println("Input key (1, 2, 3, 4, 5, 6, 7)");
            String key = scanner.next();
            if(key.equals("1")){
                add();
            }
            else if(key.equals("2")){
                show();
            }
            else if(key.equals("3")){
                update();
            }
            else if(key.equals("4")){
                search();
            }
            else if(key.equals("5")){
                remove();
            }
            else if(key.equals("6")){
                addComment();
            }
            else{
                menu();
            }
        }

        public void menu(){
            System.out.println("***MENU***");
            System.out.println();
            System.out.println("1: Add new client");
            System.out.println();
            System.out.println("2: Show all clients");
            System.out.println();
            System.out.println("3: Update client");
            System.out.println();
            System.out.println("4: Search client by Id");
            System.out.println();
            System.out.println("5: Remove client by Id");
            System.out.println();
            System.out.println("6: Add comment by client Id");
            System.out.println();
            System.out.println("7: Exit");
        }

        public void add(){

        }

        public void show(){

        }

        public void update(){

        }

        public void search(){

        }

        public void remove(){

        }

        public void addComment(){

        }
    }
}
