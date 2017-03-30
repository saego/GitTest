package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

/**
 Created by Saego on 09.03.2017.
 */
public class ClientMain {
    public static void main(String []args){
        Properties properties = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream("property.ini");
            properties.load(fis);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
            int port = Integer.parseInt(properties.getProperty("stream.port"));
            String iNet = properties.getProperty("stream.internetAddress");
            String userFolder = properties.getProperty("stream.clientFolder");
        //int port = 1920;
        //String inet = "127.0.0.1";
        try {
            //connection
            InetAddress inetAddress = InetAddress.getByName(iNet);
            Socket socket = new Socket(inetAddress, port);
            System.out.println("connection good");

            //streams
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            ClientMenu client = new ClientMenu(in, out);
            //Console console = System.console();
            String command;
            client.userF = new File(userFolder);
            //String way = in.readUTF();
            //console.printf("ROOT: %s \n", way);
            System.out.println(in.readUTF());
            do {
                ToDo toDo = new ToDo();
                client.fillClientActions();
                //command = console.readLine("Input command");
                command = br.readLine();
                out.writeUTF(command);
                toDo.whatToDo(command);
                client.select(toDo);
            }
            while (!command.equals("exit"));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
