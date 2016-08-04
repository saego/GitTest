/**
 * Created by ${Ruslan} on 19.07.16.
 */
package figure;

public class MainRun {
    public static void main(String[] args) {
    Point point1 = new Point(3, 3);
        Point point2 = new Point(4, 3);
        Point point3 = new Point(5, 2);
    Triangle figure = new Triangle(point1, point2, point3);


        double side1 = point1.distanceTo(point2);
        double side2 = point2.distanceTo(point3);
        double side3 = point1.distanceTo(point3);
        System.out.println(side1 + "|" + side2 + "|" + side3);
        if (!figure.validation()) {
            System.out.println("no such figure");
        } else {
            double square = figure.area();
            System.out.println("Square of figure:" + square);
            BiggerSide findMaxside = new BiggerSide(side1, side2, side3);

           System.out.println("Biggest side:" + findMaxside.maxSide());
        }

    }
}

