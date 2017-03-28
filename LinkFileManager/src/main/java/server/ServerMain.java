package server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 Created by Saego on 09.03.2017.
 */
public class ServerMain {
    public static void main(String []args){
        Properties properties = new Properties();
        FileInputStream fis;
        try{
            fis = new FileInputStream("property.ini");
            properties.load(fis);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        int port = Integer.parseInt(properties.getProperty("stream.port"));
        //String servFolder = properties.getProperty("stream.servFolder");
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
            StringBuffer wayChange;
            wayChange = new StringBuffer(server.way);
            wayChange.delete(0, server.way.length() - server.file.getName().length());
                out.writeUTF(String.valueOf(wayChange.toString()));
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
