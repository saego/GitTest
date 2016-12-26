import org.junit.Test;

import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 26.12.16.
 */
public class PawnTest {
    private Pawn pawn = new Pawn("white", new Cell(1, 2));
    private Cell destination = new Cell(1, 4);
    private Cell []testWay = new Cell[]{new Cell(1, 3), new Cell(1, 4)};
    @Test
    public void way() throws Exception {
    assertArrayEquals(pawn.way(destination), testWay);
    }
}