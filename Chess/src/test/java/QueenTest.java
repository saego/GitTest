import org.junit.Test;

import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 22.12.16.
 */
public class QueenTest {
    private Queen queen = new Queen("black", new Cell(4, 4));
    private Cell destination = new Cell(6, 4);
    private Cell []testWay = new Cell[]{new Cell(5, 4), new Cell(6, 4)};
    @Test
    public void way() throws ImpossibleToMoveException {
        assertArrayEquals(queen.way(destination), testWay);
    }

}