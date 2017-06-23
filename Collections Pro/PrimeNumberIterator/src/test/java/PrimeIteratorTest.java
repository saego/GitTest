import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 23.06.2017.
 */
public class PrimeIteratorTest {
    private PrimeIterator primeIterator = new PrimeIterator(new int[]{5, 1, 7, 12, 13, 14, 17});
    @org.junit.Test
    public void hasNext() throws Exception {
        assertThat(primeIterator.hasNext(), is(true));
        primeIterator.next();
        primeIterator.next();
        primeIterator.next();
        primeIterator.next();
        assertThat(primeIterator.hasNext(), is(false));
        assertThat(primeIterator.hasNext(), is(false));
    }

    @org.junit.Test
    public void next() throws Exception {
        assertThat((Integer)primeIterator.next(), is(5));
        assertThat((Integer)primeIterator.next(), is(7));
        assertThat((Integer)primeIterator.next(), is(13));
        assertThat((Integer)primeIterator.next(), is(17));
        PrimeIterator pi = new PrimeIterator(new int[]{1, 4});
        try {
        System.out.println(pi.next());
        }
        catch (IndexOutOfBoundsException iE){
            System.out.println("End of array!!!!");
        }
    }

    @Test
    public  void whileLoopTest(){
        int[] array = new int[]{5, 7, 13, 17};
        int[] testArray = new int[4];
        int i = 0;
        while (primeIterator.hasNext()){
            testArray[i] = (Integer) primeIterator.next();
            i++;
        }
        assertThat(testArray, is(array));
    }

}