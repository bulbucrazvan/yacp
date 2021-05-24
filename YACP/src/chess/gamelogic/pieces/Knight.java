package chess.gamelogic.pieces;

import chess.gamelogic.Position;
import chess.gamelogic.pieces.movechecker.KnightChecker;
import chess.gamelogic.pieces.movechecker.MoveChecker;

public class Knight extends Piece {

    public Knight(PieceColor color, Position piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public MoveChecker getPieceMoveChecker() {
        return new KnightChecker(this);
    }

}
