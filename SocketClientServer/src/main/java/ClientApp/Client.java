package ClientApp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 Created by ${Ruslan} on 23.01.17.
 */
public class Client {
    public static void main(String []args) {
        int serverPort = 5000;
        String internetAdress = "192.168.1.13";
        try {
            InetAddress inetAddress = InetAddress.getByName(internetAdress);
            System.out.println("Connecting to server...");
            Socket socket = new Socket(inetAddress, serverPort);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String string = null;
            System.out.println("Input message to server: ");
            while (true){
                string = bufferedReader.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Server sent back: " + string);
                System.out.println("Input next message to server: ");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
