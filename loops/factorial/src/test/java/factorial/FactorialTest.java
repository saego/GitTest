package factorial;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by ${Ruslan} on 28.07.16.
 */
public class FactorialTest {

    Factorial fact = new Factorial(7);
    @Test
    public void testCalculateFactorial() throws Exception {
        final int aspRes = fact.calculateFactorial();
        assertThat(aspRes, is(5040));
    }

    @Test
    public void testValidationFactorial() throws Exception {
    //final boolean valid = true;
        assertTrue(fact.validatoinFactorial());
    }
}