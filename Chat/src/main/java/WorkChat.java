import java.io.*;

/**
 Created by ${Ruslan} on 16.01.17.
 */
class WorkChat {

    void chatting(File fileAnswers, File logs, InputStream input) throws IOException {
            BufferedReader bufferedReader;
            long []positions;
            int n = 0, rowsQuantity =0;
            try(RandomAccessFile rafr00 = new RandomAccessFile(fileAnswers, "r")){
                while (rafr00.readLine() != null){
                    rowsQuantity++;
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
            positions = new long[rowsQuantity];
//формуємо массив позицій початків рядків
        try (RandomAccessFile rafr0 = new RandomAccessFile(fileAnswers, "r")){
            do {
                long m = rafr0.getFilePointer();
                if (n != rowsQuantity - 1){
                positions[n] = m;
                n++;
                }
            }
            while (rafr0.readLine() != null);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        try(
            RandomAccessFile rafr = new RandomAccessFile(fileAnswers, "r");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(logs))
        ) {
            String lineAsk;
            do
            {
//зчитуємо з консолі питання
                bufferedReader = new BufferedReader(new InputStreamReader(input));
                lineAsk = bufferedReader.readLine();
//записуємо в лог-файл питання
                String user = "User     : ";
                bufferedWriter.write(user.concat(lineAsk));
//зчитуємо відповідь з файла відповідей
                if (!lineAsk.toLowerCase().equals("stop"))
                    bufferedWriter.newLine();
                if(!lineAsk.toLowerCase().equals("stop") && !lineAsk.toLowerCase().equals("pause")) {
                    rafr.seek(positions[(int) (Math.random() * (positions.length - 1))]);
                    String lineAnswer = rafr.readLine();
//записуємо в лог-файл відповідь
                    String computer = "Computer : ";
                    bufferedWriter.write(computer.concat(lineAnswer).concat(System.lineSeparator()));
//записуємо відповідь в консоль
                    System.out.println(computer.concat(lineAnswer));
                }
            }
            while (!lineAsk.toLowerCase().equals("stop"));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
