package start;

import java.util.Scanner;

/**
 Created by ${Ruslan} on 07.10.16.

 */
class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);
//question for choose key from keyboard
    public String inputData(String question) {
        System.out.println(question);
        return scanner.next();
    }
//overriding question in range of actions
    public int inputData(String select, int[] range) throws MenuOutException{
        int key = Integer.valueOf(this.inputData(select));
        boolean exist = false;
        for (int value:
             range) {
            if(value == key){
                exist = true;
                break;
            }
        }
        if (exist){
            return key;
        }
        else {
            throw new MenuOutException("Out of range");
        }
    }
}
