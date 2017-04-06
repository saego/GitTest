package Server;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

/**
 Created by Saego on 05.04.2017.
 */
class ServerChat {
    private PrintWriter pw;

        private ArrayList<String> list = new ArrayList<>();
        private String key;
    ServerChat(PrintWriter pw) {
       // this.ask = ask;
        //this.br = br;
        this.pw = pw;
    }


        private File fileAnswers = new File("src\\main\\resources\\botAnswers.ini");
        private Properties properties = new Properties();

    ArrayList <String> chatting(){
        try {
            FileInputStream fis = new FileInputStream(fileAnswers);
            properties.load(fis);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()){
            list.add((String) keys.nextElement());
        }
        return list;
    }

    String getKey(String ask, ArrayList<String> list){
        for (String listKey:
             list) {
            if (ask.contains(listKey)){
                key = listKey;
                break;
            }
        }
        return key;
    }

    void answer(String key){
        String answer = properties.getProperty(key);
        System.out.println(answer);
        pw.println(answer);
    }
}

