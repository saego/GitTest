import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 Created by ${Ruslan} on 03.01.17.
 */
class WorkWithFile {
    private String path;
    private RandomAccessFile raf;

    WorkWithFile(String path) {
        this.path = path;
    }

    long goTo(int number) throws IOException {
        raf = new RandomAccessFile(path, "r");
        raf.seek(number);
        long pointer = raf.getFilePointer();
        raf.close();
        return pointer;
    }

    void write(String text) throws IOException {
        raf = new RandomAccessFile(path, "rw");
        raf.write(text.getBytes());
        raf.close();
    }

    String read() throws IOException {
        raf = new RandomAccessFile(path, "r");
        String res = "";
        int b = raf.read();
        while (b != -1){
            res = res + (char)b;
            b = raf.read();
        }
        raf.close();
        return res;
    }
    public String readFrom(int symbNumber) throws IOException {
        raf = new RandomAccessFile(path, "r");
        String res = "";
        raf.seek(symbNumber);
        int b = raf.read();
        while (b != -1){
            res = res + (char)b;
            b = raf.read();
        }
        raf.close();
        return res;
    }
}
