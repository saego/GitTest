import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 20.06.2017.
 */
public class IteratorSingleArrayTest {
    private int []arr = new int[]{1, 2, 3, 4};
    @org.junit.Test
    public void hasNext() throws Exception {
        IteratorSingleArray iteratorSingleArray = new IteratorSingleArray(arr);
        iteratorSingleArray.next();
        assertThat(iteratorSingleArray.hasNext(), is(true));
        iteratorSingleArray.next();
        iteratorSingleArray.next();
        iteratorSingleArray.next();
        assertThat(iteratorSingleArray.hasNext(), is(false));
        assertThat(iteratorSingleArray.hasNext(), is(false));
    }

    @org.junit.Test
    public void next() throws Exception {
        IteratorSingleArray it = new IteratorSingleArray(arr);
        it.next();
        it.next();
        int res = (Integer) it.next();
        assertThat(res, is(3));
    }

}