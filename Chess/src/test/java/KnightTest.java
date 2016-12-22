import org.junit.Test;

import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 22.12.16.
 */
public class KnightTest {
    private Knight knight = new Knight("black", new Cell(4, 4));
    private Cell destination = new Cell(6, 3);
    private Cell []testWay = new Cell[]{new Cell(6, 3)};
    @Test
    public void way() throws Exception {
        assertArrayEquals(knight.way(destination), testWay);
    }

}