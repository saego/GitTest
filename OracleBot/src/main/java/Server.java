import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 Created by Saego on 29.03.2017.
 */
public class Server {
    public static void main(String []args) throws IOException {
        int port = 1248;
        Socket socket = new ServerSocket(port).accept();
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
    }
}
