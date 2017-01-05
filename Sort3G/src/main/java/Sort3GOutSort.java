import java.io.*;

/**
 Created by ${Ruslan} on 03.01.17.
 */
public class Sort3GOutSort implements SortFile {

    public void sort(File source, File destination) throws IOException {

//        BufferedWriter bw = new BufferedWriter(new FileWriter(destination));

        //рахуємо кількість рядків
        int rows = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(source))) {
            while (br.readLine() != null) {
                rows++;
            }
        }

        //створюємо тимчасовий файл
        File tmp1 = new File("tmp1.txt");
        //записуємо найдовший рядок в файлі джерела останнім в тимчасовому файлі
        String line;
        String min, max;
        BufferedReader br1 = new BufferedReader(new FileReader(source));
        String buffer = br1.readLine();
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(tmp1));
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
        //продовжуємо канітєлі
        File src, dst;
        for (int k = 1; k <= rows; k++) {
            if (k % 2 == 0){
                src = destination;
                dst = tmp1;
            }
            else {
                src = tmp1;
                dst = destination;
            }
            BufferedReader br2 = new BufferedReader(new FileReader(src));
            buffer = br2.readLine();
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(dst));
            while ((line = br2.readLine()) != null) {
                if (line.length() > buffer.length()) {
                    min = buffer;
                    max = line;
                } else {
                    min = line;
                    max = buffer;
                }
                buffer = max;
                bw2.write(min);
                bw2.newLine();
            }
            bw2.write(buffer);
            bw2.close();
            br2.close();
            System.out.println(k);
        }
        //виводимо кількість рядків
        System.out.println(rows + "rows");
        //видаляємо тимчасовий файл
        if (tmp1.delete()) {
            System.out.println("File was deleted");
        }
    }
}
