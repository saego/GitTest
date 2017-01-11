import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 Created by ${Ruslan} on 11.01.17.
 */
public class Sort3GOutSortTest {
    @org.junit.Test
    public void sort() throws Exception {
        File source = new File("test.txt");
        File destination = new File("testRes.txt");
        File test = new File("test11.txt");
        Sort3GOutSort outSort = new Sort3GOutSort();
        outSort.sort(source, destination);

        assertThat(destination.compareTo(test), is(33));
    }

}