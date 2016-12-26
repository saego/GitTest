import static java.lang.Math.abs;

/**
 Created by ${Ruslan} on 12.12.16.
 */
public class Bishop extends Figure {
    //constructor
    Bishop(String colour, Cell cell) {
        super(colour, cell);
    }
//way of figure
    @Override
    public Cell[] way(Cell newPosition) throws ImpossibleToMoveException {

        boolean invalid = true;
        if (abs(this.position.getPositionH() - newPosition.getPositionH()) == abs(this.position.getPositionV() - newPosition.getPositionV())) {
            invalid = false;
        }
        if (invalid) {
            throw new ImpossibleToMoveException("Bishop can't move this way !!!");
        } else {
            int pointQuantity, b, v;
            int i = 0;
            int k = -1;
            int t = -1;
            if (((newPosition.getPositionH() > this.position.getPositionH()) & (newPosition.getPositionV() > this.position.getPositionV())) |
                    ((newPosition.getPositionH() < this.position.getPositionH()) & (newPosition.getPositionV() < this.position.getPositionV()))) {
                k = 1;
            }
            pointQuantity = abs(this.position.getPositionH() - newPosition.getPositionH());
            Cell[] wayPoints = new Cell[pointQuantity];
            b = this.position.getPositionV() - k * this.position.getPositionH();
            if (this.position.getPositionH() < newPosition.getPositionH()) {
                t = 1;
            }
            for (int h = this.position.getPositionH() + t; h != newPosition.getPositionH() + t; h = h + t) {
                v = k * h + b;
                wayPoints[i] = new Cell(h, v);
                i++;
            }
            return wayPoints;
        }
    }
}
