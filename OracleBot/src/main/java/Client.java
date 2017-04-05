import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 Created by Saego on 29.03.2017.
 */
public class Client {
    public static void main(String []args) throws IOException {
        int port  = 1248;
        String internetAddress = "127.0.0.1";
        Socket socket = new Socket(InetAddress.getByName(internetAddress), port);
        Scanner console = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask;
        do {
            ask = console.next();
            pw.println(ask);

        }
        while ()
    }
}
