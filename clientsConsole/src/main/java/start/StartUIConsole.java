package start;

import com.sun.demo.jvmti.hprof.Tracker;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by ${Ruslan} on 07.10.16.
 */
public class StartUIConsole {

    private InnerMenu innerMenu = new InnerMenu();

    private void title(){
        System.out.println("Hello user!");
    }

    private void start(){
        innerMenu.menu();
    }

    public static void main(String []args){
        StartUIConsole startUIConsole = new StartUIConsole();
        startUIConsole.title();
        startUIConsole.start();
    }
    public class InnerMenu{
        private Tracker tracker = new Tracker();
        private Date date = new Date();
        public Scanner scanner = new Scanner(System.in);

        public void menu(){

        }

        public void add(){

        }
    }
}
