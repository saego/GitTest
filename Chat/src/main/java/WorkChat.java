import java.io.*;

/**
 Created by ${Ruslan} on 16.01.17.
 */
class WorkChat {

    void chatting(File fileAnswers, File logs, InputStream input) throws IOException {
            String lineAsk, lineAnswer;
            BufferedReader bufferedReader;
            //BufferedWriter bufferedWriter;
        try(
            RandomAccessFile rafr = new RandomAccessFile(fileAnswers, "r");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logs))
        ) {
            do
            {
//зчитуємо з консолі питання
                bufferedReader = new BufferedReader(new InputStreamReader(input));
                lineAsk = bufferedReader.readLine();
//записуємо в лог-файл питання
                bufferedWriter.write(lineAsk);
//зчитуємо відповідь з файла відповідей
                if(!lineAsk.equals("stop")) {
                    bufferedWriter.newLine();
                    lineAnswer = rafr.readLine();
//записуємо в лог-файл відповідь
                    bufferedWriter.write(lineAnswer.concat(System.lineSeparator()));
//записуємо відповідь в консоль
                    //bufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
                    //bufferedWriter.write(lineAnswer);
                    System.out.println(lineAnswer);
                    //bufferedWriter.newLine();
                }
            }
            while (!lineAsk.equals("stop"));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
