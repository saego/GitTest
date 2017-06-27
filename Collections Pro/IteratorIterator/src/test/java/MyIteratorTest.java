import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Created by Saego on 26.06.2017.
 */
public class MyIteratorTest {

    private Converter converter = new Converter();
    private List<Integer> list0 = Collections.singletonList(0);
    private List<Integer> list1 = Arrays.asList(1, 2, 3);
    private List<Integer> list2 = Arrays.asList(4, 5);
    private Iterator<Integer> iterator0 = list0.iterator();
    private Iterator <Integer> iterator1 = list1.iterator();
    private Iterator <Integer> iterator2 = list2.iterator();
    private Iterator<Iterator<Integer>> allIterators =  Arrays.asList(iterator0, iterator1, iterator2).iterator();
    private Iterator<Integer> iterator = converter.convert(allIterators);


    @Test
    public void hasNext() throws Exception {

        assertThat(iterator.hasNext(), is(true));

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();

        assertThat(iterator.hasNext(), is(true));

        iterator.next();
        iterator.next();

        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void next() throws Exception {

        assertThat(iterator.next(), is(0));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(5));
    }

    @Test
    public void whileLoop(){
        Integer[] testArray = new Integer[]{0, 1, 2, 3, 4, 5};
        Integer[] array = new Integer[6];
        int i = 0;
        while (iterator.hasNext()){
            array[i] = iterator.next();
            i++;
        }
        assertThat(array, is(testArray));
    }

}