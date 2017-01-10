import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 Created by ${Ruslan} on 04.01.17.
 */
public class MainSort3G {
    public static void main(String []args) throws IOException {
        SortFile sort = new Sort3GOutSort();
        File source = new File("test.txt");
        sort.sort(source, new File("testRes.txt"));
        SortFile sortRand = new Sort3GRandomAccessFile();
        sortRand.sort(source, new File("testResRand"));
    }
}
