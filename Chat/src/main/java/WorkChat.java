import java.io.*;

/**
 Created by ${Ruslan} on 16.01.17.
 */
public class WorkChat {
    private RandomAccessFile rafr;
    private RandomAccessFile rfrw;
    public void chatting(File fileAnswers, File logs, InputStream input, OutputStream output) throws FileNotFoundException {
        rafr = new RandomAccessFile(fileAnswers, "r");
        rfrw = new RandomAccessFile(logs, "rw");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
    }
}
