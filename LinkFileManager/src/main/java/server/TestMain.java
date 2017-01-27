package server;

import java.io.File;

/**
 Created by ${Ruslan} on 27.01.17.
 */
public class TestMain {
    public static void main(String []args){

    }
    public void showDirectoryList(String directoryName){
        File dir = new File(directoryName);
        if (dir.isDirectory()){
            System.out.println("Is directory");
            String []folders = dir.list();
            File[] files  = dir.listFiles();
            int n = 1;
            assert folders != null;
            for (String folder:
                folders) {
                System.out.println("[Folder]:" + n + " " + folder);
                n++;
            }
        }
    }
}
