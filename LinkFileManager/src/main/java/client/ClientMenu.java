package client;

import java.io.File;
import java.util.Arrays;

/**
 Created by ${Ruslan} on 23.01.17.
 */
public class ClientMenu {
    public String folderName, way;

    public String enterFolder(String folderName) {
        File file = new File(folderName);
        String []fileList = file.list();
        way = file.getAbsolutePath();
        String list = Arrays.toString(fileList);
        return list;
    }

    public String exitFolder(String folderName){
        File file = new File(folderName);
        String []fileList = file.getParentFile().list();
        way = file.getParentFile().getAbsolutePath();
        String list = Arrays.deepToString(fileList);
        return list;
    }
}
