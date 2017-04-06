package Server;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

/**
 Created by Saego on 05.04.2017.
 */
class ServerChat {
    //String ask;
    //BufferedReader br;
    //PrintWriter pw;

    ServerChat() {
       // this.ask = ask;
        //this.br = br;
        //this.pw = pw;
    }


    void chatting(){
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
        ArrayList<String> list = new ArrayList<>();
        while (keys.hasMoreElements()){
            list.add((String) keys.nextElement());
        }
        for (String aList : list) {
            System.out.println(aList);
        }
    }
}

