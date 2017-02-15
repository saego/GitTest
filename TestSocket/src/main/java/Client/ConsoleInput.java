package Client;

import java.util.Scanner;

/**
 Created by Saego on 15.02.2017.
 */
public class ConsoleInput implements Input{
    private Scanner sc = new Scanner(System.in);

    public String command(String command) {
        return sc.next();
    }

    public String dirName(String dirName){
        return sc.next();
    }

}
