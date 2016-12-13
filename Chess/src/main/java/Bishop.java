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
            int v = this.position.getPositionV();
            for(int h = this.position.getPositionH(); h <= newPosition.getPositionH(); h++){
                if (abs(h - newPosition.getPositionH()) == abs(v - newPosition.getPositionV())){
                    pointQuantity++;
                }
                v++;
            }
            Cell []wayPoints = new Cell[pointQuantity];

            int vv = this.position.getPositionV();
            int i = 0;
            for(int h = this.position.getPositionH(); h <= newPosition.getPositionH(); h++){
            if (abs(h - newPosition.getPositionH()) == abs(vv - newPosition.getPositionV())){
                wayPoints[i] = new Cell(h, vv);
            i++;
            }
            vv++;
        }

        return wayPoints;
    }
}
