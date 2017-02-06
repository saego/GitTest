package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 Created by ${Ruslan} on 01.02.17.
 */
public class ClientApp {
    public static void main(String []args){
            int port = 1300;
            String internetAddress = "127.0.0.1";
        try {
//connection
            InetAddress inetAddress = InetAddress.getByName(internetAddress);
            Socket socket = new Socket(inetAddress, port);
//streams
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String folderName = br.readLine();
            out.writeUTF(folderName);
            out.flush();
            int length = in.readInt();
            System.out.println("Length " + length);
            String []list = new String[length];
            for (String lis:
                 list) {
                lis = in.readUTF();
                System.out.println("..." + lis);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
