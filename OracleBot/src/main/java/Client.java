import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 Created by Saego on 29.03.2017.
 */
public class Client {
    public static void main(String []args) throws IOException {
        int port  = 1248;
        String internetAddress = "127.0.0.1";
        Socket socket = new Socket(InetAddress.getByName(internetAddress), port);
    }
}
