package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 Created by ${Ruslan} on 01.02.17.
 */
public class ServerApp {
    private String dirName, way;
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
            BufferedReader br = new BufferedReader(new FileReader("ini.txt"));
            app.dirName = br.readLine();
            br.close();
//get root folder list--------------------------------------------------------------------------------------------------
            app.getList(app.dirName, out);
            out.flush();
//----------------------------------------------------------------------------------------------------------------------
            int key;
            while ((key = in.readInt()) != 0){
                if (key == 1){
                    app.way = app.dirName.concat("/").concat(in.readUTF());
                    app.getList(app.way, out);
                    System.out.println(app.way);
                    out.flush();
                }
                if (key == 2){
                    app.getParentList(app.way, out);
                    System.out.println(app.way);
                }
            }
/*
//get child folder list
            app.way = app.dirName.concat("/").concat(in.readUTF());
            app.getList(app.way, out);
            System.out.println(app.way);
            out.flush();*/
/*
//back to parent
            app.getParentList(app.way, out);
            System.out.println(app.way);*/
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getList(String folder, DataOutput out) throws IOException {
        File file = new File(folder);
        String []listFiles = file.list();
        if (listFiles != null) {
            way = file.getAbsolutePath();
            out.writeUTF(way);
            String list = listFiles[0];
            if (listFiles.length > 1){
                for (int i = 1; i < listFiles.length; i++) {
                    list = list.concat(" ").concat(listFiles[i]);
                }
            }
            out.writeUTF(list);
        }
        else {
            out.writeInt(0);
        }
    }

    private void getParentList(String folder, DataOutput out) throws IOException {
        File file = new File(folder);
        String []listFiles = file.getParentFile().list();
        if (listFiles != null) {
            way = file.getParentFile().getAbsolutePath();
            out.writeUTF(way);
            String list = listFiles[0];
            if (listFiles.length > 1){
                for (int i = 1; i < listFiles.length; i++) {
                    list = list.concat(" ").concat(listFiles[i]);
                }
            }
            out.writeUTF(list);
        }
        else {
            out.writeInt(0);
        }
    }

    private void downladFile(String folder, DataOutput out) throws IOException {
        File file = new File(folder);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null){
            out.writeUTF(line);
        }
        br.close();
    }

    private void uploadFile(String folder, DataInput in) throws IOException {
        File file = new File(folder);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String line;
        while ((line = in.readUTF()) != null){
            bw.write(line);
        }
    }
}
