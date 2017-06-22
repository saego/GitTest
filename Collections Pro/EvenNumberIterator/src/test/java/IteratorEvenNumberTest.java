import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 22.06.2017.
 */
public class IteratorEvenNumberTest {
    private IteratorEvenNumber iteratorEvenNumber = new IteratorEvenNumber(new int[]{1, 2, 4, 5, 7, 9, 10, 6});
    @org.junit.Test
    public void hasNext() throws Exception {
        assertThat(iteratorEvenNumber.hasNext(), is(true));
        iteratorEvenNumber.next();
        iteratorEvenNumber.next();
        iteratorEvenNumber.next();
        iteratorEvenNumber.next();
        assertThat(iteratorEvenNumber.hasNext(), is(false));
        assertThat(iteratorEvenNumber.hasNext(), is(false));
    }

    @org.junit.Test
    public void next() throws Exception {
        assertThat((Integer)iteratorEvenNumber.next(), is (2));
        assertThat((Integer)iteratorEvenNumber.next(), is(4));
        assertThat((Integer)iteratorEvenNumber.next(), is(10));
        assertThat((Integer)iteratorEvenNumber.next(), is(6));
    }

    @Test
    public void whileLoop(){
        int[]arrayTest = new int[]{2, 4, 10, 6};
        int[]lopArray = new  int[4];
        int i = 0;
        while (iteratorEvenNumber.hasNext()){
            lopArray[i] = (Integer) iteratorEvenNumber.next();
            i++;
        }
        assertThat(lopArray, is(arrayTest));
    }
}