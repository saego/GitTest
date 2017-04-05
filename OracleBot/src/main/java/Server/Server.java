package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 Created by Saego on 29.03.2017.
 */
public class Server {
    public static void main(String []args) throws IOException {
        int port;
        Properties properties = new Properties();
        File propFile = new File("src\\main\\resources\\app.properties");

        try (FileInputStream fileInputStream = new FileInputStream(propFile)){
            properties.load(fileInputStream);
            port = Integer.parseInt(properties.getProperty("port"));
        }

        Socket socket = new ServerSocket(port).accept();
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask;
        do{
            System.out.println("Waiting ...");
            ask = br.readLine();
            if ("hello".equals(ask)){
                pw.println("Hello, I'm Oracle");
                pw.println();
            }
            else {
                pw.println("Bye");
                pw.println();
            }
        }
        while (!"exit".equals(ask));
    }
}
