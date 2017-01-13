import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 13.01.17.
 */
public class PalindromCheckTest {
    private PalindromCheck check = new PalindromCheck();
    @org.junit.Test
    public void isPalindrom() throws Exception {
        InputStream is = new ByteArrayInputStream("Rotor".getBytes());
        assertTrue(check.isPalindrom(is));
    }

}