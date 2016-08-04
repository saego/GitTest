package dublicate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ruslan on 30.07.2016.
 */
public class DublicateTest {
    String []test = {"one", "two", "three", "four", "one", "four", "five"};
    @Test
    public void testCheckDoublicates() throws Exception {
    Dublicate dublicate = new Dublicate(test);
        final String []testArr = {"one", "two", "three", "four", "five"};
        final String []getArr = dublicate.checkDoublicates();
        assertArrayEquals(testArr, getArr);
    }

}