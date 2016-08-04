package figure;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by ${Ruslan} on 21.07.16.
 */
public class TriangleTest {
    final Point point1 = new Point(3, 3);
    final Point point2 = new Point(4, 3);
    final Point point3 = new Point(5, 2);
    final Triangle triangle = new Triangle(point1, point2, point3);
    @Test
    public void testValidation(){
        /*
        final Point point1 = new Point(3, 3);
        final Point point2 = new Point(4, 3);
        final Point point3 = new Point(5, 2);
        final Triangle triangle = new Triangle(point1, point2, point3);
        */
        final boolean res = triangle.validation();
        assertTrue(res);
    }

    @Test
    public void testArea(){
    final double res = triangle.area();
        assertThat(res, is(0.4999999999999996d));
    }
}