/**
    Created by Ruslan on 22.12.2016.
 */
public class Pawn extends Figure{
    public Pawn(String colour, Cell cell) {
        super(colour, cell);
    }

    @Override
    public Cell[] way(Cell newPosition) throws ImpossibleToMoveException {
        boolean invalid  = true;
        if (((this.position.getPositionV() - newPosition.getPositionV() == 1) && (this.getColour().equals("black"))) ||
                ((this.position.getPositionV() - newPosition.getPositionV() == -1) && (this.getColour().equals("white")))){
        invalid = false;
        }
        if (invalid){
            throw new ImpossibleToMoveException("Pawn can't move this way !!!");
        }
        else {
            int pointQuantity = 1;
            Cell []wayPoints = new Cell[pointQuantity];
            wayPoints[0] = new Cell(newPosition.getPositionH(), newPosition.getPositionV());
        return wayPoints;
        }
    }
}
