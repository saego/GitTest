/**
 Created by ${Ruslan} on 12.12.16.
 */
public class ChessBoard {
    public Figure[] figures = new Figure[16];
//adding new figure
    public Figure addFigure(Figure figure){
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null){
                figures[i] = figure;
                break;
            }
        }
        return figure;
    }

    public Figure[] getFigures(){
        return this.figures;
    }


}
