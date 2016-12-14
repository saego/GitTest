/**
 Created by ${Ruslan} on 12.12.16.
 */
public class GoPlay {
    public static void main(String []args){
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.addFigure(new Bishop("white", new Cell(4, 4)));
        chessBoard.addFigure(new Bishop("black", new Cell(2, 4)));
        chessBoard.addFigure(new Castle("white", new Cell(5, 4)));
        System.out.println("Figures on the board: ");
        for (Figure figure:
             chessBoard.getFigures()) {
            if (figure != null){
                System.out.println("Figure:" + figure.getClass().getName() + " Сolour:" + figure.getColour());
                System.out.println("Horizontal position:" + figure.position.getPositionH() + " Vertical position:" + figure.position.getPositionV());
                System.out.println("_________________________");
                Cell pointDestination = new Cell(5,8);
                if (!figure.mayIGoDest(pointDestination)){
                    System.out.println("Move is possible");
                    Cell []way = figure.way(pointDestination);
                    for (Cell pointWay:
                         way) {

                    System.out.println("H: " + pointWay.getPositionH() + " V:" + pointWay.getPositionV());
                    }
                }
                else System.out.println("Can't move to this location");
                System.out.println("_________________________");
            }
        }


    }
}
