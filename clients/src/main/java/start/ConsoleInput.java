package start;

import java.util.Scanner;

/**
 Created by ${Ruslan} on 07.10.16.

 */
class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String inputData(String question) {
        System.out.println(question);
        return scanner.next();
    }
}
