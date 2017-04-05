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

    private static int port;
    private static String internetAddress;
    private final Properties properties = new Properties();

    private void loadConfig(){
        File propFile = new File("src\\main\\resources\\app.properties");
        try (FileInputStream fileInputStream = new FileInputStream(propFile)){
            this.properties.load(fileInputStream);
            port = Integer.parseInt(properties.getProperty("port"));
            internetAddress = properties.getProperty("ip");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String []args) throws IOException {
        Client client = new Client();
        client.loadConfig();

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
