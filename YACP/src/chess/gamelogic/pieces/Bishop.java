package chess.gamelogic.pieces;

import chess.gamelogic.Position;
import chess.gamelogic.pieces.movechecker.MoveChecker;
import chess.gamelogic.pieces.movechecker.BishopChecker;

public class Bishop extends Piece {

    public Bishop(PieceColor color, Position piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public MoveChecker getPieceMoveChecker() {
        return new BishopChecker(this);
    }

}
