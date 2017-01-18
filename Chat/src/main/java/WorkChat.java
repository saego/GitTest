import java.io.*;

/**
 Created by ${Ruslan} on 16.01.17.
 */
class WorkChat {

    void chatting(File fileAnswers, File logs, InputStream input, OutputStream output) throws IOException {
            String lineAsk, lineAnswer;
            BufferedReader bufferedReader;
            BufferedWriter bufferedWriter;
        try(
            RandomAccessFile rafr = new RandomAccessFile(fileAnswers, "r");
            RandomAccessFile rafrw = new RandomAccessFile(logs, "rw")
        ) {
            do
            {
//зчитуємо з консолі питання
                bufferedReader = new BufferedReader(new InputStreamReader(input));
                lineAsk = bufferedReader.readLine();
//записуємо в лог-файл питання
                rafrw.writeBytes(lineAsk.concat(System.lineSeparator()));
//зчитуємо відповідь з файла відповідей
                if(!lineAsk.equals("stop")) {
                    lineAnswer = rafr.readLine();
//записуємо в лог-файл відповідь
                    rafrw.writeBytes(lineAnswer.concat(System.lineSeparator()));
//записуємо відповідь в консоль
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
                    bufferedWriter.write(lineAnswer);
                    System.out.println(lineAnswer);
                    bufferedWriter.newLine();
                }
            }
            while (!lineAsk.equals("stop"));
            rafrw.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
