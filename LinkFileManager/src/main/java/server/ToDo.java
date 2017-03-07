package server;

import java.util.Scanner;

/**
 * Created by Saego on 07.03.2017.
 */
public class ToDo {
    String keyToDo;
    String target;

    public void whatToDo(String command){
        Scanner read = new Scanner(command);
        while (read.hasNext()){
            if (read.hasNext()) {
                this.keyToDo = read.next();
            }

            if (read.hasNext()) {
                this.target = read.next();
            } else {
                this.target = null;
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
