import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *Created by Saego on 04.05.2017.
 */
public class CalculatorTest {
    /**
     *Input params.
     */
    private double first = 6;
    private double second = 3;

    /**
     * Check addition.
     * @throws Exception - ex.
     */
    @org.junit.Test
    public void add() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.add(first, second);
        assertThat(calculator.getResult(), is(9d));
    }

    /**
     * Check multiplications.
     * @throws Exception  - ex.
     */
    @org.junit.Test
    public void multiply() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.multiply(first, second);
        assertThat(calculator.getResult(), is(18d));
    }

    /**
     * Check division.
     * @throws Exception  - ex.
     */
    @org.junit.Test
    public void div() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.div(first, second);
        assertThat(calculator.getResult(), is(2d));
    }

    /**
     * Check subscription.
     * @throws Exception - ex.
     */
    @org.junit.Test
    public void sub() throws Exception {
        final Calculator calculator = new Calculator();
        calculator.sub(first, second);
        assertThat(calculator.getResult(), is(3d));
    }

}