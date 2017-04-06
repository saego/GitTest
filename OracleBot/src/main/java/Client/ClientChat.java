package Client;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ruslan on 05.04.2017.
 */
public class ClientChat {
    String ask;
    String answer;
    BufferedReader br;
    PrintWriter pw;

    public ClientChat(String ask, BufferedReader br, PrintWriter pw) {
        this.ask = ask;
        this.br = br;
        this.pw = pw;
    }

    public void chatting() throws IOException {
        while ((answer = br.readLine()) != null) {
            System.out.println(answer);
        }

    }
}
