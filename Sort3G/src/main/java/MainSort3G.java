import java.io.File;
import java.io.IOException;

/**
 Created by ${Ruslan} on 04.01.17.
 */
public class MainSort3G {
    public static void main(String []args) throws IOException {
        SortFile sort = new Sort3GOutSort();
        File source = new File("avl1.txt");
        File destination = new File("avl2.txt");
        sort.sort(source, destination);
    }
}
