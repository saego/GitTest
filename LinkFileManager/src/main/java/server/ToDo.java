package server;

import java.util.Scanner;

/**
 Created by Saego on 07.03.2017.
 */
class ToDo {
    private String keyToDo;
    private String target;

    void whatToDo(String command){
        Scanner read = new Scanner(command);
        while (read.hasNext()){
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

    String getKeyToDo() {
        return this.keyToDo;
    }

    String getTarget() {
        return this.target;
    }
}
