import java.io.*;

/**
 Created by ${Ruslan} on 03.01.17.
 */
public class Sort3GOutSort implements SortFile {

    public void sort(File source, File destination) throws IOException {

//        BufferedWriter bw = new BufferedWriter(new FileWriter(destination));

        //рахуємо кількість рядків
        try(BufferedReader br = new BufferedReader(new FileReader(source))) {
            int rows = 0;
            while (br.readLine() != null) {
                rows++;
            }
        System.out.println(rows);
        }

        //створюємо тимчасовий файл
        File tmp = new File("tmp.txt");
        String line;
        String min, max;
        BufferedReader br1 = new BufferedReader(new FileReader(source));
        //записуємо найдовший рядок в файлі джерела останнім в тимчасовому файлі
        String buffer = br1.readLine();
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(tmp));
        while ((line = br1.readLine()) != null){
            if (line.length() > buffer.length()){
                min = buffer;
                max = line;
            }
            else {
                min = line;
                max = buffer;
            }
            buffer = max;
            bw1.write(min);
            bw1.newLine();
        }
        bw1.write(buffer);
        bw1.close();
        br1.close();

    }
}
