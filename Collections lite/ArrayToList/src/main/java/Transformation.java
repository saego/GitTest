import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

/**
 Created by Saego on 07.06.2017.
 */
class Transformation {
    /**
     * Transformation array[][] to list.
     * @param array - input array[][].
     * @return - list.
     */
    List<Integer> toList(int[][] array){
        List<Integer> list = new ArrayList<Integer>();
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                list.add(anAnArray);
            }
        }
        return list;
    }

    int[][] toArray(List<Integer> list, int rows) {
        int columns = (int) ceil(((float)list.size()/rows));
        int[][] array = new int[rows][columns];
        int i = 0;
        int j = 0;
        for (Integer l :
                list) {
            array[i][j] = l;
            if (i < array.length) {
                if (j < array[i].length - 1) {
                    j++;
                } else {
                    j = 0;
                    i++;
                }
            }
        }
        if (columns * rows > list.size()){
            for (int j1 = j; j1 < array[i].length; j1++){
                array[i][j1] = 0;
            }
        }
        return array;

    }
}
