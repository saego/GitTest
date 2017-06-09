import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Created by Saego on 07.06.2017.
 */
public class TransformationTest {

    private List<Integer> integerList = new ArrayList<Integer>();
    private int [][]array = {{2, 4, 6},{4, 7, 12}};
    private int [][]array1 = {{2, 4, 6},{4, 7, 12}, {22, 0, 0}};
    private int []a = {2, 4, 6, 12, 66};
    private int []b = {23455, 13, 222, 567};
    private Transformation transformation = new Transformation();


    @org.junit.Test
    public void toList() throws Exception {
        integerList.add(array[0][0]);
        integerList.add(array[0][1]);
        integerList.add(array[0][2]);
        integerList.add(array[1][0]);
        integerList.add(array[1][1]);
        integerList.add(array[1][2]);

        assertThat(transformation.toList(array), is(integerList));
    }

    @org.junit.Test
    public void toArray() throws Exception {
        integerList.add(array[0][0]);
        integerList.add(array[0][1]);
        integerList.add(array[0][2]);
        integerList.add(array[1][0]);
        integerList.add(array[1][1]);
        integerList.add(array[1][2]);
        integerList.add(22);
        int rows = 3;
        assertThat(transformation.toArray(integerList, rows), is(array1));
    }

    @Test
    public void converter() throws Exception {
        List<int[]> arrList = new ArrayList<int[]>();
        arrList.add(a);
        arrList.add(b);
        List<Integer> test = new ArrayList<Integer>();
        for (int i:
             a) {
            test.add(i);
        }
        for (int j:
             b) {
            test.add(j);
        }
        assertThat(transformation.converter(arrList), is(test));
    }
}