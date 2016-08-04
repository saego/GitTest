package calc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest{
	
	@org.junit.Test
	public void testAdd(){
	final Calculator calc = new Calculator();
	calc.add(3, 6);
	final double result = calc.out();
		assertThat(result, is(9d));
	}
	
	@org.junit.Test
	public void testSubstruct(){
        final Calculator calc = new Calculator();
	    calc.substruct(7, 6);
        final double result = calc.out();
        assertThat(result, is(1d));
    }
	
	@org.junit.Test
	public void testDiv(){
        final Calculator calc = new Calculator();
	calc.div(8, 4);
        final double result = calc.out();
        assertThat(result, is(2d));
    }
	
	@org.junit.Test
	public void testMultiple(){
        final Calculator calc = new Calculator();
	calc.multiple(3, 6);
        final double result = calc.out();
        assertThat(result, is(18d));
	}
}