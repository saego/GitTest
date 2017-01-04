import java.io.*;

/**
 Created by ${Ruslan} on 03.01.17.
 */
public class Sort3GOutSort implements SortFile {

    public void sort(File source, File destination) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(source));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destination));
        int rows = 0;
        String line2;
        String line1;
        while ((line1 = br.readLine()) != null){
            System.out.println(line1);
            line2 = br.readLine();
            if (line1.length() > line2.length()) {
                bw.write(line2);
                bw.newLine();
                bw.write(line1);
                bw.newLine();
                rows++;
            }
            else {
                bw.write(line1);
                bw.newLine();
                bw.write(line2);
                bw.newLine();
                rows++;
            }
        }
        System.out.println(rows);
        br.close();
        bw.close();
    }
}
