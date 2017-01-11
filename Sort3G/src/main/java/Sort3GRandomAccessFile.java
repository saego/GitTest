import java.io.*;

/**
 Created by ${Ruslan} on 04.01.17.
 */
public class Sort3GRandomAccessFile implements SortFile {
    private RandomAccessFile rafr;
    private RandomAccessFile rafw;
    public void sort(File source, File destination) throws IOException {
        rafr = new RandomAccessFile(source, "r");
        rafw = new RandomAccessFile(destination, "rw");
    }
}
