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

    public int inputData(String question, int[] range) throws MenuOutException{
        int key = Integer.valueOf(this.inputData(question));
        boolean exist = false;
        for (int value:
             range) {
            if(value == key){
                exist = true;
                break;
            }
        }
        //return exist ? key: -1;
        if (exist){
            return key;
        }
        else {
            throw new MenuOutException("Out of range");
        }
    }
}
