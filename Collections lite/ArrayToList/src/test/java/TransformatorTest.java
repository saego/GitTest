import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Created by Saego on 07.06.2017.
 */
public class TransformatorTest {
    private int [][]array = {{2, 4, 6},{4, 7, 12}};
    private List<Integer> integerList = new ArrayList<Integer>();
    @org.junit.Test
    public void toList() throws Exception {
    Transformator transformator = new Transformator();
    integerList.add(array[0][0]);
    integerList.add(array[0][1]);
    integerList.add(array[0][2]);
        integerList.add(array[1][0]);
        integerList.add(array[1][1]);
        integerList.add(array[1][2]);

        assertThat(integerList, is(transformator.toList(array)));
    }


}