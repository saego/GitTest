/**
 Created by ${Ruslan} on 12.12.16.
 */
public abstract class Figure {
//variables
private String colour;
    Cell position;
//constructor

    Figure(String colour, Cell cell) {
        this.colour = colour;
        this.position = cell;
    }

    String getColour() {
        return colour;
    }

    public abstract boolean mayIGoDest(Cell newPoint);
    public abstract Cell[] way(Cell NewPosition);
}
