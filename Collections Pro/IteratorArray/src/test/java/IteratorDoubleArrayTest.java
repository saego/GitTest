import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 Created by Saego on 20.06.2017.
 */
public class IteratorDoubleArrayTest {
    private int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7}};
    private IteratorDoubleArray iteratorDoubleArray = new IteratorDoubleArray(array);

    @Test
    public void hasNext() throws Exception {
        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        assertThat(iteratorDoubleArray.hasNext(), is(true));
        iteratorDoubleArray.next();
        assertThat(iteratorDoubleArray.hasNext(), is(true));
        iteratorDoubleArray.next();
        iteratorDoubleArray.next();
        assertThat(iteratorDoubleArray.hasNext(), is(true));
        iteratorDoubleArray.next();
        assertThat(iteratorDoubleArray.hasNext(), is(true));
        iteratorDoubleArray.next();
        assertThat(iteratorDoubleArray.hasNext(), is(false));
        assertThat(iteratorDoubleArray.hasNext(), is(false));
    }

    @Test
    public void next() throws Exception {
        int res = (Integer) iteratorDoubleArray.next();
        assertThat(res, is(1));
        res = (Integer)iteratorDoubleArray.next();
        assertThat(res, is(2));
        res = (Integer)iteratorDoubleArray.next();
        assertThat(res, is(3));
        res = (Integer)iteratorDoubleArray.next();
        assertThat(res, is(4));
        res = (Integer)iteratorDoubleArray.next();
        assertThat(res, is(5));
        res = (Integer)iteratorDoubleArray.next();
        assertThat(res, is(6));
        res =(Integer)iteratorDoubleArray.next();
        assertThat(res, is(7));
    }

    @Test
    public void loopTest() {
        int[] arrayActual = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] arrayExpected = new int[7];
        int index = 0;
        while(this.iteratorDoubleArray.hasNext()) {
            arrayExpected[index] = (Integer)this.iteratorDoubleArray.next();
            index++;
        }
        assertThat(arrayActual, is(arrayExpected));
    }

}