package figure;

public class Triangle {
    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean validation(){
        double side1 = a.distanceTo(this.b);
        double side2 = b.distanceTo(this.c);
        double side3 = a.distanceTo(this.c);
        boolean realTriangle = false;
        if((side1 < (side2 + side3))&(side2 < (side1 + side3))&(side3 < (side1 + side2))){
            realTriangle = true;
        }
        return realTriangle;
    }

    public double area(){
        double side1 = a.distanceTo(this.b);
        double side2 = b.distanceTo(this.c);
        double side3 = a.distanceTo(this.c);
        double halfOfSumm = (side1 + side2 + side3)/2;
        //System.out.println("square" + square);
        return Math.sqrt(halfOfSumm * (halfOfSumm - side1) * (halfOfSumm - side2) * (halfOfSumm - side3));
    }

    /*public double biggestSide(double side1, double side2, double side3){
        double maxSide = side1 < side2 ? side2: side1;
        maxSide = maxSide < side3 ? side3: maxSide;
        return maxSide;
    }*/
}
