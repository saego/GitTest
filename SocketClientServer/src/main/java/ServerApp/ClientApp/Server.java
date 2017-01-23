package ServerApp.ClientApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 Created by ${Ruslan} on 23.01.17.
 */
public class Server {
    public static void main(String []args){
        int port = 3000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);//
            System.out.println("Waiting for server connection...");
            Socket socket = serverSocket.accept();
            System.out.println("We've got connection");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            String string = null;
            while (true){
                string = in.readUTF();
                System.out.println("Message: " + string);
                System.out.println("Send back...");
                out.writeUTF(string);
                out.flush();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
