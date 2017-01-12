import java.io.*;
import java.util.Arrays;

/**
 Created by ${Ruslan} on 04.01.17.
 */
public class Sort3GRandomAccessFile implements SortFile {

    private RandomAccessFile rafr;
    private RandomAccessFile rafw;
    private RandomAccessFile rafTmp1;

    public void sort(File source, File destination) throws IOException {
        this.rafr = new RandomAccessFile(source, "r");
        this.rafw = new RandomAccessFile(destination, "rw");
        int quantityRows = 0;
        while (rafr.readLine() != null){
            quantityRows++;
        }
        rafr.close();
        System.out.println("Rows : " + quantityRows);

        this.rafr = new RandomAccessFile(source, "r");
        int count = 1;
        String name = "temp1.txt";
        String line, fileNames;
        fileNames = name;
        int []rowsLength = new int[quantityRows];
        int i = 0;
        while ((line = rafr.readLine()) != null){
            this.rafTmp1 = new RandomAccessFile(name, "rw");
            rafTmp1.writeBytes(String.format("%s", line));
                rowsLength[i] = line.length();
                i++;
            if (count > 1) {
                fileNames = fileNames.concat(" ").concat(name);
            }
            count++;
            name = "temp".concat(String.valueOf(count).concat(".txt"));
        }
        String []files = fileNames.split(" ");
        for (int n = 0; n < quantityRows; n++){
            System.out.println("_____________________");
            System.out.println("File name: " + files[n] + "Length: " + rowsLength[n]);
            System.out.println("_____________________");
        }
        for (int n = 0; n < quantityRows; n++){
            System.out.println("_____________________");
            System.out.println("Length: " + sort(rowsLength)[n]);
            System.out.println("_____________________");
        }
    }
    //рекурсивная функция сортировки частей массива
    private static String[] sort(int[] arr, String[] arrS){
        if(arr.length < 2) return arrS;
        int m = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, m);
        int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        String []arr1S = Arrays.copyOfRange(arrS, 0, m);
        String []arr2S = Arrays.copyOfRange(arrS, m, arr.length);
        return merge(sort(arr1S), sort(arr2S));
    }
    //слияние двух массивов в один отсортированный
    private static String[] merge(int []arr1, int []arr2, String []arr1S, int []arr2S){
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1=0;
        int i2=0;
        for(int i=0;i<n;i++){
            if(i1 == arr1.length){
                arr[i] = arr2[i2++];
            }else if(i2 == arr2.length){
                arr[i] = arr1[i1++];
            }else{
                if(arr1[i1] < arr2[i2]){
                    arr[i] = arr1[i1++];
                }else{
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;
    }

}
