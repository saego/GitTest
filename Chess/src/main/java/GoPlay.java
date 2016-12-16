/**
 Created by ${Ruslan} on 12.12.16.
 */
public class GoPlay {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.addFigure(new Bishop("white", new Cell(4, 4)));
        chessBoard.addFigure(new Bishop("black", new Cell(3, 4)));
        chessBoard.addFigure(new Castle("white", new Cell(5, 4)));
        System.out.println("Figures on the board: ");
        for (Figure figure :
                chessBoard.getFigures()) {
            if (figure != null) {
                System.out.println("Figure:" + figure.getClass().getName() + " Сolour:" + figure.getColour());
                System.out.println("Horizontal position:" + figure.position.getPositionH() + " Vertical position:" + figure.position.getPositionV());
                System.out.println("_________________________");
            }
        }
        System.out.println("MOVING!");
        Cell source = new Cell(3, 4);
        Cell pointDestination = new Cell(6, 1);
        chessBoard.move(source, pointDestination);
        for (Figure figure :
                chessBoard.getFigures()) {
            if (figure != null) {
                System.out.println("Figure:" + figure.getClass().getName() + " Сolour:" + figure.getColour());
                System.out.println("Horizontal position:" + figure.position.getPositionH() + " Vertical position:" + figure.position.getPositionV());
                System.out.println("_________________________");

            }
        }
    }
}
