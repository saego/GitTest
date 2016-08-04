package rotate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ${Ruslan} on 29.07.16.
 */
public class RotateTest {
    int [][]test = {{2, 3, 7},{1, 8, 9},{8, 4, 50}};

    @Test
    public void testSortByClockArrow() throws Exception {
        Rotate rotate = new Rotate(test);
        final int testArrByClock[][] = {{8, 1, 2}, {4, 8, 3},{50, 9, 7}};
        final int getArrByClock[][] = rotate.sortByClockArrow();
        assertArrayEquals(testArrByClock, getArrByClock);
    }

    @Test
    public void testSortAgainstClockArrow(){
        Rotate rotate = new Rotate(test);
        final int testArrAgainstClock[][] = {{7, 9, 50},{3, 8 ,4},{2, 1 , 8}};
        final int getArrAgainstClock[][] = rotate.sortAgainstClockArrow();
        assertArrayEquals(testArrAgainstClock, getArrAgainstClock);
    }
}