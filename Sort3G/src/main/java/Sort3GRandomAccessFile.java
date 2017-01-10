import java.io.*;

/**
 Created by ${Ruslan} on 04.01.17.
 */
public class Sort3GRandomAccessFile implements SortFile {
    public void sort(File source, File destination) throws IOException {
        RandomAccessFile rafR = new RandomAccessFile(source, "r");
        RandomAccessFile rafWR = new RandomAccessFile(destination, "rw");
        rafR.readLine().
    }
}
