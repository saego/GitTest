package Client;

import java.io.BufferedReader;
import java.io.IOException;

/**
 Created by Saego on 05.04.2017.
 */
class ClientChat {
    private BufferedReader br;

    ClientChat(BufferedReader br) {
        this.br = br;
    }

    void chatting() throws IOException {
        String answer;
        answer = br.readLine();
        while (!answer.equals("null")){
            System.out.println(answer);
            answer = br.readLine();
        }
        System.out.println(br.readLine());
    }
}
