import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 Created by ${Ruslan} on 19.12.16.
 */
public class ChessBoardTest {
    private ChessBoard  board = new ChessBoard();
    private Cell destination = new Cell(4, 4);
    private Figure []figures = new Figure[]{new Bishop("white", new Cell(2, 2)), new Castle("black", new Cell(3, 6)),
        null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    @Test
    public void addFigure() throws Exception {
        board.addFigure(figures[0]);
        board.addFigure(figures[1]);
        assertArrayEquals(board.getFigures(), figures);
    }

    @Test
    public void getFigures() throws Exception {
        board.addFigure(figures[0]);
        board.addFigure(figures[1]);
        assertArrayEquals(board.getFigures(), figures);
    }

    @Test
    public void move() throws ImpossibleToMoveException, FigureWasNotFoundException, OccupiedWayException {
        board.addFigure(figures[0]);
        board.move(new Cell(2, 2), destination);
        assertThat(board.getFigures()[0].position, is(destination));
    }

}