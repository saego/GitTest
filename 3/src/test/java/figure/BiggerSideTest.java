package figure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by ${Ruslan} on 21.07.16.
 */
public class BiggerSideTest {

    @Test
    public void testMaxSide() {
        final Point point1 = new Point(3, 3);
        final Point point2 = new Point(4, 3);
        final Point point3 = new Point(5, 2);
        final BiggerSide bigs = new BiggerSide(point1.distanceTo(point1), point1.distanceTo(point3), point1.distanceTo(point2));
        final double res = bigs.maxSide();
        assertThat(res, is(2.23606797749979d));
    }
}