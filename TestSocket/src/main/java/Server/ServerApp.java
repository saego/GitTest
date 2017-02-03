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

            out.writeUTF("Dir");
            String folderName = in.readUTF();
            out.flush();
            while(!folderName.toLowerCase().equals("exit")){
                ServerApp serverApp = new ServerApp();
                File file = new File(folderName);
                assert (serverApp.getList(file) != null);
                out.writeUTF(String.valueOf(serverApp.getList(file).length));
                for (String filename:
                    serverApp.getList(file)) {
                    out.writeUTF(filename);
                }
                out.flush();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    private String []getList(File folder){
        if (folder.isDirectory()) {
            return folder.list();
        }
        else return null;
    }
}
