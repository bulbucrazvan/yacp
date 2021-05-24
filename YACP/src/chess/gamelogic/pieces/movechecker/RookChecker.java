package chess.gamelogic.pieces.movechecker;

import chess.gamelogic.Board;
import chess.gamelogic.Position;
import chess.gamelogic.pieces.Piece;

import java.util.List;

public class RookChecker extends MoveChecker {

    public RookChecker(Piece boardPiece) {
        super(boardPiece);
    }

    @Override
    public List<Position> getPossibleMoves() {
        return getPossibleStraightMoves(Board.getBoardSize());
    }
}
