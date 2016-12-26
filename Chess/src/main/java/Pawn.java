import static java.lang.Math.abs;

/**
    Created by Ruslan on 22.12.2016.
 */
public class Pawn extends Figure{
    Pawn(String colour, Cell cell) {
        super(colour, cell);
    }
    //way of figure
    @Override
    public Cell[] way(Cell newPosition) throws ImpossibleToMoveException {
        boolean invalid  = true;
        if (((this.position.getPositionV() - newPosition.getPositionV() == 1) && (this.getColour().equals("black"))) ||
                ((this.position.getPositionV() - newPosition.getPositionV() == -1) && (this.getColour().equals("white"))) ||
                ((this.position.getPositionV() - newPosition.getPositionV() == 2) && (this.getColour().equals("black")) && (this.position.getPositionV() == 7)) ||
                ((this.position.getPositionV() - newPosition.getPositionV() == -2) && (this.getColour().equals("white")) && (this.position.getPositionV() == 2))){
        invalid = false;
        }
        if (invalid){
            throw new ImpossibleToMoveException("Pawn can't move this way !!!");
        }
        else {
            int pointQuantity = abs(newPosition.getPositionV() - this.position.getPositionV());
            Cell []wayPoints = new Cell[pointQuantity];
            int start = this.position.getPositionV();
            int end = newPosition.getPositionV();
            int k = 1;
            int i = 0;
            if (this.position.getPositionV() > newPosition.getPositionV()){
                k = -1;
            }
            for (int n = start + k; n != end + k; n = n + k) {
                wayPoints[i] = new Cell(this.position.getPositionH(), n);
                i++;
            }
        return wayPoints;
        }
    }


}
