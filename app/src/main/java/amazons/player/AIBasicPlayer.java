package amazons.player;

import amazons.board.Position;
import amazons.figures.Amazon;

import java.util.List;
import java.util.Random;
import static amazons.util.RandomUtil.*;

public class AIBasicPlayer extends AbstractAIPlayer{

    @Override
    protected Position startPositionOfAmazonToMove() {
        return getRandomElement(new Random(), getMovableAmazons()).getPosition();
    }

    @Override
    protected Position destPositionOfAmazonToMove(Position startPosition) {
        Amazon amazon = (Amazon) boardRepresentation.getFigure(startPosition);
        List<Position> accessibleDestinationsPositions = amazon.getAccessiblePositions(boardRepresentation, getAdjacentPositions(startPosition));
        if(accessibleDestinationsPositions.size() == 0){
            return null;
        }
        return getRandomElement(new Random(), accessibleDestinationsPositions);
    }

    @Override
    protected Position destPositionOfArrowToShoot(Position arrowStartPosition) {
        if(arrowStartPosition == null){
            return null;
        }
        return destPositionOfAmazonToMove(arrowStartPosition);
    }
}
