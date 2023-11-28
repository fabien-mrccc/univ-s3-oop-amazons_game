package amazons.board;

import amazons.figures.Amazon;
import amazons.figures.EmptyFigure;
import amazons.figures.Figure;

import java.util.List;
import amazons.figures.MovableFigure;
import static amazons.figures.EmptyFigure.EMPTY_FIGURE;

public class PresetFigureGenerator implements FigureGenerator{
    private List<MovableFigure> movableFigures;
    public PresetFigureGenerator(List<MovableFigure> movableFigures){
        this.movableFigures = movableFigures;
    }
    @Override
    public Figure nextFigure(Position position) {
        for(MovableFigure movableFigure : movableFigures){
            if(movableFigure.getPosition().equals(position)){
                return (Figure) movableFigure;
            }
        }
        return EMPTY_FIGURE;
    }
}
