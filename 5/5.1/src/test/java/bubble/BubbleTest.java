package bubble;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ${Ruslan} on 27.07.16.
 */
public class BubbleTest {

    @Test
    public void testSortArray() throws Exception {
    int []mas = {8, 4, 5, 1, 2, 3, 9, 6, 7, 0};
        Bubble bubble = new Bubble(mas);
        final int testArr [] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int gotArr [] = bubble.sortArray();
        assertArrayEquals(testArr, gotArr);
    }
}