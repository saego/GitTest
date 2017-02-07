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

            //String way;
            //way = br.readLine();
            //out.writeUTF(way);

            String []getFiles = new String[in.readInt()];
            for (String file:
                 getFiles) {
                file = in.readUTF();
                System.out.println("... " + file);
            }
            System.out.println("------------------------");
            System.out.println("input name");
            out.writeUTF(br.readLine());

            getFiles = new String[in.readInt()];
            for (String file:
                    getFiles) {
                file = in.readUTF();
                System.out.println("... " + file);
            }
            System.out.println("------------------------");
            System.out.println("Parent list");
            getFiles = new String[in.readInt()];
            for (String file:
                    getFiles) {
                file = in.readUTF();
                System.out.println("... " + file);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
