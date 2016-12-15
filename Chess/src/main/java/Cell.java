/**
 Created by ${Ruslan} on 12.12.16.
 */
class Cell {
//variables coordinates
    private int positionV;
    private int positionH;
//constructor
    Cell(int positionH, int positionV) {
        this.positionH = positionH;
        this.positionV = positionV;
    }
//get vertical position
    int getPositionV() {
        return positionV;
    }
//get horizontal position
    int getPositionH() {
        return positionH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (positionV != cell.positionV) return false;
        return positionH == cell.positionH;
    }

    @Override
    public int hashCode() {
        int result = positionV;
        result = 31 * result + positionH;
        return result;
    }
}
