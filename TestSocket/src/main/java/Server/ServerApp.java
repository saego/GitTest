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

            boolean flag = true;
            ServerApp app = new ServerApp();
            String way, folderName = "Dir";
            while (flag) {
                way = folderName;
                folderName = in.readUTF().concat(folderName);
                if (!folderName.equals("exit")) {
                    String[] list = app.getList(folderName);
                    System.out.println(list.length);
                    out.writeInt(list.length);
                    for (String lis :
                       list) {
                     out.writeUTF(lis);
                    out.flush();
                    }
                } else if (folderName.equals("cd")) {
                    String[] list = app.getList(way);
                    System.out.println(list.length);
                    out.writeInt(list.length);
                    for (String lis :
                            list) {
                        out.writeUTF(lis);
                        out.flush();
                    }
                }
                else {
                    flag = false;
                }
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
