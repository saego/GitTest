import org.junit.Test;

import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 22.12.16.
 */
public class KingTest {
    private King king = new King("white", new Cell(6, 7));
    private Cell destination = new Cell(7, 7);
    private Cell []testWay = new Cell[]{new Cell(7, 7)};
    @Test
    public void way() throws Exception {
        assertArrayEquals(king.way(destination), testWay);
    }

}