package server;

import java.io.File;

/**
 Created by ${Ruslan} on 27.01.17.
 */
public class TestMain {
    public static void main(String []args){
        TestMain test = new TestMain();
        test.showDirectoryList("TestDir1");
        test.showFileList("TestDir1/TestDir2");

    }

    private void showDirectoryList(String directoryName){
        File dir = new File(directoryName);
        if (dir.isDirectory()){
            System.out.println(directoryName + " " + "Is directory");
            String []folders = dir.list();
            int n = 1;
            assert folders != null;
            for (String folder:
                folders) {
                System.out.println("[Folder]:" + n + " " + folder);
                n++;
            }
        }
    }

    private void showFileList(String directoryName){
        File dir = new File(directoryName);
        if (dir.isDirectory()){
            System.out.println(directoryName + " " + "Is directory");
            File[] files  = dir.listFiles();
            int n = 1;
            assert files != null;
            for (File file:
                 files) {
                System.out.println("[File]:" + n + " " + file.getName());
                n++;
            }
        }
    }
}
