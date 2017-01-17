import java.io.*;

/**
 Created by ${Ruslan} on 16.01.17.
 */
class WorkChat {
    private RandomAccessFile rafr;
    private RandomAccessFile rafrw;
    void chatting(File fileAnswers, File logs, InputStream input, OutputStream output) throws IOException {
        rafr = new RandomAccessFile(fileAnswers, "r");
        rafrw = new RandomAccessFile(logs, "rw");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
        String lineAsk = bufferedReader.readLine();
        bufferedReader.close();
        rafrw.writeBytes(lineAsk);
        String lineAnswer = rafr.readLine();
        rafr.close();
        bufferedWriter.write(lineAnswer.concat(String.));
        bufferedWriter.close();
        rafrw.writeBytes(lineAnswer);
        rafrw.close();

    }
}
