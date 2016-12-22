/**
 Created by ${Ruslan} on 12.12.16.
 */
public class GoPlay {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.addFigure(new Bishop("white", new Cell(4, 4)));
        chessBoard.addFigure(new Bishop("black", new Cell(3, 6)));
        chessBoard.addFigure(new Castle("white", new Cell(5, 4)));
        chessBoard.addFigure(new Queen("black", new Cell(4, 6)));
        chessBoard.addFigure(new Knight("white", new Cell(7, 3)));
        chessBoard.addFigure(new King("black", new Cell(7, 7)));
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
        Cell source = new Cell(7, 3);
        Cell pointDestination = new Cell(8, 5);
        try {
            chessBoard.move(source, pointDestination);
        for (Figure figure :
                chessBoard.getFigures()) {
            if (figure != null) {
                System.out.println("Figure :" + figure.getClass().getName() + " Сolour :" + figure.getColour());
                System.out.println("Horizontal position :" + figure.position.getPositionH() + " Vertical position :" + figure.position.getPositionV());
                System.out.println("_________________________");

            }
        }
        }
        catch (ImpossibleToMoveException my){
            System.out.println("Error :" + my);
        }
        catch (FigureWasNotFoundException my){
            System.out.println("Error :" + my);
        }
        catch (OccupiedWayException my){
            System.out.println("Error :" + my);
        }
    }
}
