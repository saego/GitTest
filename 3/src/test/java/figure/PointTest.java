package figure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by ${Ruslan} on 20.07.16.
 */
public class PointTest {

    @org.junit.Test
    public void testDistanceTo(){
    final Point point1 = new Point(3, 3);
        final Point point2 = new Point(4, 3);
        final Point point3 = new Point(5, 2);
        double  result1 = point1.distanceTo(point2);
        assertThat(result1, is(1d));
        double  result2 = point2.distanceTo(point3);
        assertThat(result2, is(1.4142135623730951d));
        double  result3 = point1.distanceTo(point3);
        assertThat(result3, is(2.23606797749979d));
    }
}