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
        boolean isNewCellEmpty = true;
        boolean isThereFigure = false;
        //lookong for figure on current position
        for (Figure fig:
                figures) {
            if (fig.position.equals(source)){
                Figure currentFigure = fig;
                isThereFigure = true;
                break;
            }
        }
        if (!isThereFigure){
            System.out.println("No figure on this position!");
        }
        //check if Destination cell is empty
        for (Figure fig:
             figures) {
            if (fig.position.equals(destination)){
            isNewCellEmpty = false;
            break;
            }
        }
        return isThereFigure;
    }
}
