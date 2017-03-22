package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 Created by Saego on 09.03.2017.
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

            //streams
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            ServerMenu server = new ServerMenu(out, in);
            String command;
                out.writeUTF(String.valueOf(server.way));
            do {
                server.fillServerActions();
                ToDo toDo = new ToDo();
                command = in.readUTF();
                toDo.whatToDo(command);
                server.select(toDo);
            }
            while (!command.equals("exit"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
