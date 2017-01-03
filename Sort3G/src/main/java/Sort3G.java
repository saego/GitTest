import java.io.*;

/**
 Created by ${Ruslan} on 03.01.17.
 */
public class Sort3G implements SortFile {

    public void sort(File source, File destination) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(source));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destination));
        int rowsQuantity = 0;
        while (br.readLine() != null) {
            rowsQuantity++;
        }
        int []rows = new int[rowsQuantity];
        int i = 0;
        while (br.readLine() != null){
            rows[i] = br.readLine().length();
            i++;
        }
    }
}
