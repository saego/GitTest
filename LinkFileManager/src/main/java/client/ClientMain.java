package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 Created by Saego on 09.03.2017.
 */
public class ClientMain {
    public static void main(String []args){
        int port = 1920;
        String inet = "127.0.0.1";
        try {
            //connection
            InetAddress inetAddress = InetAddress.getByName(inet);
            Socket socket = new Socket(inetAddress, port);
            System.out.println("connection good");

            //streams
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            ClientMenu client = new ClientMenu(in, out);
            System.out.println(in.readUTF());
            ToDo toDo = new ToDo();
            client.fillClientActions();
            String command = br.readLine();
            out.writeUTF(command);
            toDo.whatToDo(command);
            client.select(toDo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
