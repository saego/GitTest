import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 27.12.16.
 */
public class StreamTest {
    @org.junit.Test
    public void isNumber() throws Exception {
    ByteArrayInputStream testStream = new ByteArrayInputStream("12".getBytes());
        Stream stream = new Stream();
        assertThat(stream.isNumber(testStream), is(true));
    }

}