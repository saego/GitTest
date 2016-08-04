package figure;

/**
 * Created by ${Ruslan} on 20.07.16.
 */
public class BiggerSide {
    double side1, side2, side3;

    public BiggerSide(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double maxSide(){
        double bigSide = side1 < side2 ? side2: side1;
        bigSide = bigSide < side3 ? side3: bigSide;
        return bigSide;
    }
}
