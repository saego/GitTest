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


}