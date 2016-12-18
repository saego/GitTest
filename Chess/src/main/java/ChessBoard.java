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

    boolean move(Cell source, Cell destination) throws ImpossibleToMoveException, FigureWasNotFoundException, OccupiedWayException {
        boolean isNewCellEmpty = true;
        boolean isThereFigure = false;
        Figure currentFigure = null;
        //looking for figure on current position
        for (Figure fig:
                this.figures) {
            if (fig != null && fig.position.equals(source)){
                currentFigure = fig;
                isThereFigure = true;
                break;
            }
        }
        if (!isThereFigure){
            //System.out.println("There's no figure on this cell!");
            throw new FigureWasNotFoundException("There's no figure on this cell!");
        }
        else {
            //check if Destination cell is empty
            for (Figure fig :
                    getFigures()) {
                if (fig != null && fig.position.equals(destination)) {
                    isNewCellEmpty = false;
                    break;
                }
            }
            if (!isNewCellEmpty){
                throw new OccupiedWayException("There is figure on destination cell");
            }
            else {
                    for (Cell way :
                            currentFigure.way(destination)) {
                        for (Figure fig :
                                getFigures()) {
                            if (fig != null && fig.position.equals(way)) {
                                throw new OccupiedWayException("There is figure on way");
                            }
                        }
                    }
                    currentFigure.clone(destination);
            }
        }
        return true;
    }
}

