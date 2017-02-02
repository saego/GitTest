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
            String task = in.readUTF();
            //System.out.println(task);
            out.writeUTF(task);
            //out.flush();
            int numbersFile = Integer.parseInt(in.readUTF());
            System.out.println("Files on server:  " + numbersFile);
            String[] filesServer = new String[numbersFile];
            for (String fileServer :
                    filesServer) {
                fileServer = in.readUTF();
                System.out.println("..." + fileServer);
            }
            while (!task.toLowerCase().equals("exit")){
                System.out.println("send task");
                task = br.readLine();
                out.writeUTF(task);
                out.flush();

                numbersFile = Integer.parseInt(in.readUTF());
                System.out.println("Files on server:  " + numbersFile);
                filesServer = new String[numbersFile];
                for (String fileServer :
                        filesServer) {
                    fileServer = in.readUTF();
                    System.out.println("..." + fileServer);
                }
            }
            //while (!(task = br.readLine()).toLowerCase().equals("exit"));
            br.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
