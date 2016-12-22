import org.junit.Test;

import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 19.12.16.
 */
public class CastleTest {
    private Castle castle = new Castle("black", new Cell(4, 4));
    private Cell destination = new Cell(6, 4);
    private Cell []testWay = new Cell[]{new Cell(5, 4), new Cell(6, 4)};
    @Test
    public void way() throws ImpossibleToMoveException {
        assertArrayEquals(castle.way(destination), testWay);
    }

}