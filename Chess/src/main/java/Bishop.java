import static java.lang.Math.abs;

/**
 Created by ${Ruslan} on 12.12.16.
 */
public class Bishop extends Figure{
    Bishop(String colour, Cell cell) {
        super(colour, cell);
    }

    public boolean mayIGoDest(Cell newPosition){
        boolean invalid = true;
        if (abs(this.position.getPositionH() - newPosition.getPositionH()) == abs(this.position.getPositionV() - newPosition.getPositionV())){
            invalid = false;
        }
        return invalid;
    }

    public Cell[] way(Cell newPosition){
            int pointQuantity = 0;
            //int v = this.position.getPositionV();
            if (newPosition.getPositionH() > this.position.getPositionH()){
                for (int h = this.position.getPositionH() + 1; h <= newPosition.getPositionH(); h++){
                    pointQuantity++;
                }
            }
            else {
                for (int h = this.position.getPositionH() - 1; h >= newPosition.getPositionH(); h--){
                    pointQuantity++;
                }
                //Cell []wayPoints = new Cell[pointQuantity];
            }

            Cell []wayPoints = new Cell[pointQuantity];
            int i =0;

        if (newPosition.getPositionH() > this.position.getPositionH()){
            for (int h = this.position.getPositionH() + 1; h <= newPosition.getPositionH(); h++){
                int v = h - this.position.getPositionH() + this.position.getPositionV();
                wayPoints[i] = new Cell(h, v);
                i++;
            }
        }
        else {
            for (int h = this.position.getPositionH() - 1; h >= newPosition.getPositionH(); h--){
                int v = h - this.position.getPositionH() + this.position.getPositionV();
                wayPoints[i] = new Cell(h, v);
                i++;
            }
            //Cell []wayPoints = new Cell[pointQuantity];
        }

        return wayPoints;
    }
}
