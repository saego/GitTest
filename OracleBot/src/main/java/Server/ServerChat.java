package Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by Ruslan on 05.04.2017.
 */
public class ServerChat {
    //String ask;
    //BufferedReader br;
    //PrintWriter pw;

    public ServerChat() {
       // this.ask = ask;
        //this.br = br;
        //this.pw = pw;
    }


    public void chatting(){
        File fileAnswers = new File("src\\main\\resources\\botAnswers.ini");
        Properties properties = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileAnswers);
            properties.load(fis);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        Enumeration keys = properties.keys();

        while (keys.hasMoreElements()){
            String str = (String) keys.nextElement();
            System.out.println(str);
            System.out.println(properties.get(str));
        }

    }
}
