import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 22.06.2017.
 */
public class IteratorEvenNumberTest {
    private IteratorEvenNumber iteratorEvenNumber = new IteratorEvenNumber(new int[]{1, 2, 4, 5, 7, 9, 10, 6});
    @org.junit.Test
    public void hasNext() throws Exception {
    }

    @org.junit.Test
    public void next() throws Exception {
        assertThat((Integer)iteratorEvenNumber.next(), is (2));
        assertThat((Integer)iteratorEvenNumber.next(), is(4));
        assertThat((Integer)iteratorEvenNumber.next(), is(10));
        assertThat((Integer)iteratorEvenNumber.next(), is(6));
    }

}