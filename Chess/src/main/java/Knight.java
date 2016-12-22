import static java.lang.Math.abs;

/**
 Created by ${Ruslan} on 22.12.16.
 */
public class Knight extends Figure{
    Knight(String colour, Cell cell) {
        super(colour, cell);
    }

    @Override
    public Cell[] way(Cell newPosition) throws ImpossibleToMoveException {
        boolean invalid = true;
        if ((abs(this.position.getPositionH() - newPosition.getPositionH()) != 0) &&
                (abs(this.position.getPositionV() - newPosition.getPositionV()) != 0) &&
                ((abs(this.position.getPositionH() - newPosition.getPositionH()) + abs(this.position.getPositionV() - newPosition.getPositionV())) == 3)){
            invalid = false;
        }
        if (invalid){
         throw new ImpossibleToMoveException("Knight can't move this way");
        }
        else {
            int pointQuantity = 1;
            Cell []wayPoints = new Cell[pointQuantity];
            wayPoints[0] = new Cell(newPosition.getPositionH(), newPosition.getPositionV());
            return wayPoints;
        }
    }
}
