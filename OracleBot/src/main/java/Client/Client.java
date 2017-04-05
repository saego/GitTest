package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 Created by Saego on 29.03.2017.
 */
public class Client {

    public void loadConfig(){

    }
    public static void main(String []args) throws IOException {

        int port = 0;
        String internetAddress = null;
        final Properties properties = new Properties();

        File propFile = new File("src\\main\\resources\\app.properties");
        try (FileInputStream fileInputStream = new FileInputStream(propFile)){
            properties.load(fileInputStream);
            port = Integer.parseInt(properties.getProperty("port"));
            internetAddress = properties.getProperty("ip");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        Socket socket = new Socket(InetAddress.getByName(internetAddress), port);
        Scanner console = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        String ask;
        do {
            ask = console.next();
            pw.println(ask);
            System.out.println(br.readLine());
            System.out.println(br.readLine());

        }
        while (!"exit".equals(ask));
    }
}
