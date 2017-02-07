package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 Created by ${Ruslan} on 01.02.17.
 */
public class ServerApp {
    public static void main(String []args){
        int port = 1300;
        try{
//connection
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for connection...");
            Socket socket = serverSocket.accept();
            System.out.println("We've got connection");
//streams
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            ServerApp app = new ServerApp();
            String way;
            way = in.readUTF();

            out.writeInt(app.getList(way).length);
            for (String file:
                 app.getList(way)) {
                out.writeUTF(file);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private String []getList(String folder){
        File file = new File(folder);
        //if (file.isDirectory()) {
            return file.list();
        //}
        //else return null;
    }
}
