/**
 Created by ${Ruslan} on 12.12.16.
 */
public class GoPlay {
    public static void main(String []args){
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.addFigure(new Bishop("red", new Cell(1, 3)));
        chessBoard.addFigure(new Bishop("black", new Cell(6, 2)));
        System.out.println("Figures on the board: ");
        for (Figure figur:
             chessBoard.getFigures()) {
            if (figur != null){
                System.out.println("Figure:" + figur.getClass().getName() + " Сolour:" + figur.getColour() +
                " Horizontal position:" + figur.cell.getPositionH() + " Vertical position:" + figur.cell.getPositionV());
            }
        }
    }
}
