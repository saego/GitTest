import java.io.*;

/**
 Created by ${Ruslan} on 04.01.17.
 */
public class Sort3GRandomAccessFile implements SortFile {

    private RandomAccessFile rafr;
    private RandomAccessFile rafw;
    private RandomAccessFile rafTmp1;
    private RandomAccessFile rafTmp2;

    public void sort(File source, File destination) throws IOException {
        this.rafr = new RandomAccessFile(source, "r");
        this.rafw = new RandomAccessFile(destination, "rw");
        File tmp1 = File.createTempFile("temp1", ".txt");
        File tmp2 = File.createTempFile("temp2", ".txt");
        this.rafTmp1 = new RandomAccessFile(tmp1, "rw");
        this.rafTmp2 = new RandomAccessFile(tmp2, "rw");
        String line;
        boolean jumper = true;
        int lineLength = 0;
        while ((line = rafr.readLine()) != null){
            rafTmp1.writeBytes(String.format());
        }
    }

}
