package banking;

import java.util.Scanner;

/**
 *Created by Saego on 14.06.2017.
 */
public class ConsoleInput implements Input{

    private Scanner scanner = new Scanner(System.in);

    public String ask(String whatToDo) {
        System.out.printf("Choose action, %s", whatToDo);
        return scanner.next();
    }
}
