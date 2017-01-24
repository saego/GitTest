package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 Created by ${Ruslan} on 23.01.17.
 */
public class Server {
    public static void main(String []args){
    int port  = 1092;
        try {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Waiting for connection...");
        Socket socket = ss.accept();
        System.out.println("Accept connetion!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        //DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String word = dataInputStream.readUTF();
        System.out.println(word);
        }
        catch (Exception x){
        x.printStackTrace();
        }
    }
}
