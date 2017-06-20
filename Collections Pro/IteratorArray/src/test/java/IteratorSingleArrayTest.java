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
    }

    @org.junit.Test
    public void next() throws Exception {
    }

}