package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 Created by ${Ruslan} on 01.02.17.
 */
public class ClientApp {
            String dirName, way;
            String []files;
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
            ClientApp app = new ClientApp();
//----------------------------------------------------------------------------------------------------------------
            System.out.println("Root Dir");
            app.way = in.readUTF();
            System.out.println(app.way);
            System.out.println("List: ");
            app.files = in.readUTF().split(" ");
            for (String file:
                 app.files) {
                System.out.println("..." + file);
            }
//----------------------------------------------------------------------------------------------------------------
            /*System.out.println("Input name");
            app.dirName = br.readLine();
            out.writeUTF(app.dirName);
            System.out.println("Current Dir");
            app.way = in.readUTF();
            System.out.println(app.way);
            System.out.println("List: ");
            files = in.readUTF().split(" ");
            for (String file:
                    files) {
                System.out.println("..." + file);
            }*/

            /*System.out.println("Parent Dir");
            app.way = in.readUTF();
            System.out.println(app.way);
            System.out.println("List: ");
            files = in.readUTF().split(" ");
            for (String file:
                    files) {
                System.out.println("..." + file);
            }*/

            app.enterFolder(br, in, out);
            app.exitFolder(in);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void enterFolder(BufferedReader br, DataInput in, DataOutput out) throws IOException {
        System.out.println("Input name");
        dirName = br.readLine();
        out.writeUTF(dirName);
        System.out.println("Current Dir");
        way = in.readUTF();
        System.out.println(way);
        System.out.println("List: ");
        files = in.readUTF().split(" ");
        for (String file:
                files) {
            System.out.println("..." + file);
        }
    }

    public void exitFolder(DataInput in) throws IOException {
        System.out.println("Parent Dir");
        way = in.readUTF();
        System.out.println(way);
        System.out.println("List: ");
        files = in.readUTF().split(" ");
        for (String file:
                files) {
            System.out.println("..." + file);
        }
    }
}
