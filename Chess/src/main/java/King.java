import static java.lang.Math.abs;

/**
 Created by ${Ruslan} on 22.12.16.
 */
public class King extends Figure{
    King(String colour, Cell cell) {
        super(colour, cell);
    }
    //way of figure
    @Override
    public Cell[] way(Cell newPosition) throws ImpossibleToMoveException {
        boolean invalid  = true;
        if ((abs(this.position.getPositionH() - newPosition.getPositionH()) <= 1) && (abs(this.position.getPositionV() - newPosition.getPositionV()) <= 1)){
            invalid = false;
        }
        if (invalid){
            throw new ImpossibleToMoveException("King can't move this way !!!");
        }
        else {
            int pointQuantity = 1;
            Cell []wayPoints = new Cell[pointQuantity];
            wayPoints[0] = new Cell(newPosition.getPositionH(), newPosition.getPositionV());
            return wayPoints;
        }
    }
}
