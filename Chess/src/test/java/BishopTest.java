import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 Created by ${Ruslan} on 19.12.16.
 */
public class BishopTest {
        private Bishop bishop = new Bishop("black", new Cell(4, 4));
        private Cell destination = new Cell(6, 6);
        private Cell []testWay = new Cell[]{new Cell(5, 5), new Cell(6, 6)};
    @Test
    public void way() throws ImpossibleToMoveException {
        assertArrayEquals(bishop.way(destination), testWay);
    }

}