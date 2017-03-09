package client;

import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Saego on 09.03.2017.
 */
public class ClientMain {
    public static void main(String []args){
        int port = 1920;
        String inet = "127.0.0.1";
        try {
            //connection
            InetAddress inetAddress = InetAddress.getByName(inet);
            Socket socket = new Socket(inetAddress, port);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
