import static java.lang.Math.abs;

/**
 Created by ${Ruslan} on 14.12.16.
 */
public class Castle extends Figure {
    Castle(String colour, Cell cell) {
        super(colour, cell);
    }

    @Override
    public boolean mayIGoDest(Cell newPosition) {
        boolean invalid = true;
        if (((newPosition.getPositionH() == this.position.getPositionH()) & (newPosition.getPositionV() != this.position.getPositionV())) ||
                ((newPosition.getPositionH() != this.position.getPositionH()) & (newPosition.getPositionV() == this.position.getPositionV()))){
            invalid = false;
        }
        return invalid;
    }

    @Override
    public Cell[] way(Cell newPosition) {
        // we go by H
        int b = this.position.getPositionV();
        int start = this.position.getPositionH();
        int end  = newPosition.getPositionH();
        int k = -1;
        int pointQuantity;
        int i = 0;
        boolean xWay = true;
        pointQuantity = abs(start - end);
        //if true we go by V
        if (this.position.getPositionH() == newPosition.getPositionH()){
            b = this.position.getPositionH();
            start = this.position.getPositionV();
            end = newPosition.getPositionV();
            xWay = false;
            pointQuantity = abs(start - end);
        }
        if (start < end){
            k = 1;
        }
        Cell []wayPoints = new Cell[pointQuantity];
        for (int t = start + k; t != end + k; t = t + k){
            if (xWay){
                wayPoints[i] = new Cell(t, b);
            }
            else {
                wayPoints[i] = new Cell(b, t);
            }
            i++;
        }
        return wayPoints;
    }
}
