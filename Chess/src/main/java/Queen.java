import static java.lang.Math.abs;

/**
 Created by ${Ruslan} on 22.12.16.
 */
public class Queen extends Figure{
    Queen(String colour, Cell cell) {
        super(colour, cell);
    }

    @Override
    public Cell[] way(Cell newPosition) throws ImpossibleToMoveException {
        boolean invalid = true;
        if ((abs(this.position.getPositionH() - newPosition.getPositionH()) == abs(this.position.getPositionV() - newPosition.getPositionV()))||
                (((newPosition.getPositionH() == this.position.getPositionH()) & (newPosition.getPositionV() != this.position.getPositionV())) ||
                        ((newPosition.getPositionH() != this.position.getPositionH()) & (newPosition.getPositionV() == this.position.getPositionV())))){
            invalid = false;
        }
        if (invalid){
            throw new ImpossibleToMoveException("Queen can't move this way");
        }
        else {
            int b = 0;
            int k = 1;
            int i = 0;
            int pointQuantity = abs(this.position.getPositionH() - newPosition.getPositionH());
            int start = this.position.getPositionH();
            int end = newPosition.getPositionH();
            boolean hZero = false;
            boolean vZero = false;
            if (this.position.getPositionH() == newPosition.getPositionH()){
                pointQuantity = abs(this.position.getPositionV() - newPosition.getPositionV());
                start = this.position.getPositionV();
                end = newPosition.getPositionV();
                hZero = true;
                b = this.position.getPositionH();
            }
            if (this.position.getPositionV() == newPosition.getPositionV()){
                vZero = true;
                b = this.position.getPositionV();
            }
            Cell []wayPoints = new Cell[pointQuantity];
            if (start > end){
                k = -1;
            }
            for (int h = start + k; h != end + k; h = h + k){
                if(!hZero && !vZero) {
                    int v = (h - this.position.getPositionH() * (newPosition.getPositionV() - this.position.getPositionV())) /
                            (newPosition.getPositionH() - this.position.getPositionH()) + this.position.getPositionV();
                    wayPoints[i] = new Cell(h, v);
                    i++;
                }
                else {
                    if (hZero){
                        wayPoints[i] = new Cell(b, h);
                        i++;
                    }
                    else {
                    wayPoints[i] = new Cell(h, b);
                    i++;
                    }
                }
            }
        return wayPoints;
        }
    }
}

