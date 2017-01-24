package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 Created by ${Ruslan} on 23.01.17.
 */
public class Client {
    public static void main(String []args){
        int port = 1092;
        String internetAddress = "127.0.0.1";
        try {
            InetAddress inetAddress = InetAddress.getByName(internetAddress);
            System.out.println("Connection to server...");
            Socket socket = new Socket(inetAddress, port);

            //DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String word = bufferedReader.readLine();
            dataOutputStream.writeUTF(word);
            dataOutputStream.flush();
        }
        catch (Exception x){
            x.printStackTrace();
        }
    }
}
