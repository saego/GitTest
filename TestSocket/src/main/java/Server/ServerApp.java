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
//variables
            ServerApp app = new ServerApp();
            String way;
            way = "Dir";
//get root folder list
            app.getList(way, out);
            out.flush();
//get child folder list
            way = way.concat("/").concat(in.readUTF());
            app.getList(way, out);
            out.flush();
//back to parent
            app.getParentList(way, out);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getList(String folder, DataOutput out) throws IOException {
        File file = new File(folder);
        String []listFiles = file.list();
        if (listFiles != null) {
            out.writeInt(listFiles.length);
            for (String listFile:
                    listFiles) {
                out.writeUTF(listFile);
            }
        }
        else {
            out.writeInt(0);
        }
    }

    private void getParentList(String folder, DataOutput out) throws IOException {
        File file = new File(folder);
        String []listFiles = file.getParentFile().list();
        if (listFiles != null) {
            out.writeInt(listFiles.length);
            for (String listFile :
                    listFiles) {
                out.writeUTF(listFile);
            }
        }
        else {
            out.writeInt(0);
        }
    }
}
