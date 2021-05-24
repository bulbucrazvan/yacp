package chess.gamelogic.pieces.movechecker;

import chess.gamelogic.Position;
import chess.gamelogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class KingChecker extends MoveChecker {
    public KingChecker(Piece boardPiece) {
        super(boardPiece);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> legalMoves = new ArrayList<>();
        legalMoves.addAll(getPossibleStraightMoves(1));
        legalMoves.addAll(getPossibleDiagonalMoves(1));
        return legalMoves;
    }
}
