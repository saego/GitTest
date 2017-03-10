package client;

import java.util.Scanner;

/**
 * Created by Saego on 03.03.2017.
 */
public class ToDo {

    private String keyToDo;
    private String target;



    public void whatToDo(String command){
        Scanner read = new Scanner(command);
        while (read.hasNext()) {
            if (read.hasNext()) {
                this.keyToDo = read.next();
            }

            if (read.hasNext()) {
                this.target = read.next();
            } else {
                this.target = "123";
            }
        }
    }

    public String getKeyToDo() {
        return this.keyToDo;
    }

    public String getTarget() {
        return this.target;
    }
}

