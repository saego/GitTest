/**
 Created by ${Ruslan} on 12.12.16.
 */
class ChessBoard {
    private Figure[] figures = new Figure[16];
//adding new figure
Figure addFigure(Figure figure){
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null){
                figures[i] = figure;
                break;
            }
        }
        return figure;
    }

    Figure[] getFigures(){
        return this.figures;
    }

    public boolean move (Cell source, Cell destination){

        return true;
    }
}
