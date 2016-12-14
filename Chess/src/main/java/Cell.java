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
}
