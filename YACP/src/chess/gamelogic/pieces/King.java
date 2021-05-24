package chess.gamelogic.pieces;

import chess.gamelogic.pieces.movechecker.KingChecker;
import chess.gamelogic.pieces.movechecker.MoveChecker;
import chess.gamelogic.Position;

public class King extends Piece {

    public King(PieceColor color, Position piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public MoveChecker getPieceMoveChecker() {
        return new KingChecker(this);
    }

}
