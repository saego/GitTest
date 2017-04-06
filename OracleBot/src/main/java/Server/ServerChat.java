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
    //String ask;
    //BufferedReader br;
    PrintWriter pw;

        ArrayList<String> list = new ArrayList<>();
        String key;
    ServerChat() {
       // this.ask = ask;
        //this.br = br;
        this.pw = pw;
    }


        File fileAnswers = new File("src\\main\\resources\\botAnswers.ini");
        Properties properties = new Properties();
        FileInputStream fis;
    public ArrayList <String> chatting(){
        try {
            fis = new FileInputStream(fileAnswers);
            properties.load(fis);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()){
            list.add((String) keys.nextElement());
        }
        //for (String aList : list) {
        //    System.out.println(aList);
        //}
        return list;
    }

    public String getKey(String ask, ArrayList<String> list){
        //StringBuffer sbAsk = new StringBuffer(ask.subSequence(0, ask.length()));
        for (String listKey:
             list) {
            if (ask.contains(listKey)){
                key = listKey;
                break;
            }
        }
        return key;
    }

    public void answer(String key){
        //System.out.println(properties.getProperty(key));
        pw.println(properties.getProperty(key));
    }
}

