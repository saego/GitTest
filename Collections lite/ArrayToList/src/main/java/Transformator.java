import java.util.ArrayList;
import java.util.List;

/**
 Created by Saego on 07.06.2017.
 */
class Transformator {

    List<Integer> toList(int[][] array){
        List<Integer> list = new ArrayList<Integer>();
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                list.add(anAnArray);
            }
        }
        return list;
    }
}
