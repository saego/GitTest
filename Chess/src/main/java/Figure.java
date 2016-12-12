/**
 * Created by ${Ruslan} on 12.12.16.
 */
public abstract class Figure {
//variables
    String colour;
    Cell cell;
//constructor

    public Figure(String colour, Cell cell) {
        this.colour = colour;
        this.cell = cell;
    }
}
