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


    @Test
    public void hasNext() throws Exception {
        List<Integer> list0 = Collections.singletonList(0);
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);
        Iterator<Integer> iterator0 = list0.iterator();
        Iterator <Integer> iterator1 = list1.iterator();
        Iterator <Integer> iterator2 = list2.iterator();
        Iterator<Iterator<Integer>> allIterators =  Arrays.asList(iterator0, iterator1, iterator2).iterator();
        Iterator<Integer> it = converter.convert(allIterators);
        it.next();
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void next() throws Exception {
        List<Integer> list0 = Collections.singletonList(0);
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);
        Iterator<Integer> iterator0 = list0.iterator();
        Iterator <Integer> iterator1 = list1.iterator();
        Iterator <Integer> iterator2 = list2.iterator();
        Iterator<Iterator<Integer>> allIterators =  Arrays.asList(iterator0, iterator1, iterator2).iterator();
        Iterator<Integer> it = converter.convert(allIterators);
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
    }

}