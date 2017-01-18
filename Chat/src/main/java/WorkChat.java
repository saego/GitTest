import java.io.*;

/**
 Created by ${Ruslan} on 16.01.17.
 */
class WorkChat {

    void chatting(File fileAnswers, File logs, InputStream input, OutputStream output) throws IOException {
        try(
            RandomAccessFile rafr = new RandomAccessFile(fileAnswers, "r");
            RandomAccessFile rafrw = new RandomAccessFile(logs, "rw")
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output))
        ) {
            String lineAsk, lineAnswer;
            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
            do {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
                lineAsk = bufferedReader.readLine();
                bufferedReader.close();
                rafrw.writeBytes(lineAsk.concat(System.lineSeparator()));
                lineAnswer = rafr.readLine();
                bufferedWriter.write(lineAnswer);
                bufferedWriter.newLine();
                bufferedWriter.close();
                rafrw.writeBytes(lineAnswer.concat(System.lineSeparator()));
            }
            while (!lineAsk.equals("stop"));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
