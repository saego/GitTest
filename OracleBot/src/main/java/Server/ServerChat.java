package Server;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Created by Ruslan on 05.04.2017.
 */
public class ServerChat {
    String ask;
    BufferedReader br;
    PrintWriter pw;

    public ServerChat(String ask, BufferedReader br, PrintWriter pw) {
        this.ask = ask;
        this.br = br;
        this.pw = pw;
    }

    public void chatting(String ask){

    }
}
