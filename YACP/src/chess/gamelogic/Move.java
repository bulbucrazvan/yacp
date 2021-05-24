package chess.gamelogic;

public class Move {
    private Position startingPosition, endingPosition;

    public Move(Position startingPosition, Position endingPosition) {
        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
    }

    public Position getStartingPosition() {
        return startingPosition;
    }

    public Position getEndingPosition() {
        return endingPosition;
    }
}
