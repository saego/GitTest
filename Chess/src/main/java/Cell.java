/**
 Created by ${Ruslan} on 12.12.16.
 */
public class Cell {
//variables coordinates
    int positionV;
    int positionH;
//constructor
    public Cell(int positionH, int positionV) {
        this.positionH = positionH;
        this.positionV = positionV;
    }
//get vertical position
    public int getPositionV() {
        return positionV;
    }
//get horizontal position
    public int getPositionH() {
        return positionH;
    }
}
