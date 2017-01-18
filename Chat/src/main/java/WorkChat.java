import java.io.*;

/**
 Created by ${Ruslan} on 16.01.17.
 */
class WorkChat {

    void chatting(File fileAnswers, File logs, InputStream input, OutputStream output) throws IOException {
        RandomAccessFile rafr = new RandomAccessFile(fileAnswers, "r");
        RandomAccessFile rafrw = new RandomAccessFile(logs, "rw");
        String lineAsk, lineAnswer;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
        //do {
        lineAsk = bufferedReader.readLine();
        bufferedReader.close();
        rafrw.writeBytes(lineAsk.concat(System.lineSeparator()));
        lineAnswer = rafr.readLine();
        rafr.close();
        bufferedWriter.write(lineAnswer);
        bufferedWriter.newLine();
        bufferedWriter.close();
        rafrw.writeBytes(lineAnswer);
        rafrw.close();
        //}
        //while (!lineAsk.equals("Stop"));
    }
}
