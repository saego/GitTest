import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 Created by ${Ruslan} on 04.01.17.
 */
public class Sort3GRandomAccessFile implements SortFile {

    public void sort(File source, File destination) throws IOException {
        RandomAccessFile rafw = new RandomAccessFile(destination, "rw");
        int quantityRows = 0;
        try (RandomAccessFile rafr = new RandomAccessFile(source, "r")){
            while (rafr.readLine() != null){
                quantityRows++;
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Rows : " + quantityRows);

        RandomAccessFile rafr = new RandomAccessFile(source, "r");
        int count = 1;
        String name = "temp1.txt";
        String line, fileNames;
        fileNames = name;
        int []rowsLength = new int[quantityRows];
        int i = 0;
        while ((line = rafr.readLine()) != null){
            RandomAccessFile rafTmp1 = new RandomAccessFile(name, "rw");
            rafTmp1.writeBytes(String.format("%s", line));
                rowsLength[i] = line.length();
                i++;
            if (count > 1) {
                fileNames = fileNames.concat(" ").concat(name);
            }
            count++;
            name = "temp".concat(String.valueOf(count).concat(".txt"));
        }
        rafr.close();
        String []files = fileNames.split(" ");
/*
        //пробуємо вивести імена файлів з відповідною довжиною рядків кожного з них

        for (int n = 0; n < quantityRows; n++){
            System.out.println("_____________________");
            System.out.println("File name: " + files[n] + "Length: " + rowsLength[n]);
            System.out.println("_____________________");
        }
*/
        //сортування массивів методом бульбашки

        int mov = 0;
        int temp;
        String tempS;
        boolean flagRemoved = true;
        while (flagRemoved){
            flagRemoved = false;
            for (int k = 0; k < rowsLength.length - 1 - mov; k++){
                if (rowsLength[k] > rowsLength[k + 1]){
                    temp = rowsLength[k + 1];
                    tempS = files[k + 1];
                    rowsLength[k + 1] = rowsLength[k];
                    files[k + 1] = files[k];
                    rowsLength[k] = temp;
                    files[k] = tempS;
                    flagRemoved = true;
                }
            }
            mov++;
        }
/*
        //пробуємо вивести відсортовані назви файлів

        System.out.println("Sorted files: ");
        for (int n = 0; n < quantityRows; n++){
            System.out.println("_____________________");
            System.out.println("File name: " + files[n] + "Length: " + rowsLength[n]);
            System.out.println("_____________________");
        }
*/
        //пробуємо записати в вихідний файл

        for (int i1 = 0; i1 < files.length; i1++) {
            String file = files[i1];
            RandomAccessFile rafMulti = new RandomAccessFile(file, "r");
            if (i1 !=  0) {
                rafw.writeBytes(System.lineSeparator());
            }
            rafw.writeBytes(rafMulti.readLine());

            //видаляємо тимчасові файли

            File f = new File(file);
            if (f.delete())
                System.out.println(" - " + file + " was deleted!");
        }
            rafw.close();
    }
}
