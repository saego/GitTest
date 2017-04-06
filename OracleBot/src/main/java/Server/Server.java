package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 Created by Saego on 29.03.2017.
 */
public class Server {

        private static int port;
        private Properties properties = new Properties();
    private void loadConfig() throws IOException {
        File propFile = new File("src\\main\\resources\\app.properties");

        try (FileInputStream fileInputStream = new FileInputStream(propFile)){
            this.properties.load(fileInputStream);
            port = Integer.parseInt(properties.getProperty("port"));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String []args) throws IOException {
        Server server = new Server();
        server.loadConfig();

        Socket socket = new ServerSocket(port).accept();
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ServerChat serverChat = new ServerChat();
        String ask;
        do{
            System.out.println("Waiting ...");
            ask = br.readLine();
                serverChat.answer(serverChat.getKey(ask, serverChat.chatting()));
                pw.println();
        }
        while (!"exit".equals(ask)||!"bye".equals(ask));
    }
}
