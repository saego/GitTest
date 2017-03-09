package server;


import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Saego on 09.03.2017.
 */
public class ServerMain {
    public static void main(String []args){
        int port = 1920;
        try {
            //connection parameters
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Connection OK");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
