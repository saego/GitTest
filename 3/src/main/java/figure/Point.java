/**
 * Created by ${Ruslan} on 19.07.16.
 */

package figure;

public class Point {
public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }



    public double distanceTo(Point point){
        return Math.sqrt(Math.pow((point.x - this.x), 2) + Math.pow((point.y - this.y), 2));
    }
}
