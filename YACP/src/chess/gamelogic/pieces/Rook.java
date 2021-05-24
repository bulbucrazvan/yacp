package chess.gamelogic.pieces;

import chess.gamelogic.Position;
import chess.gamelogic.pieces.movechecker.MoveChecker;
import chess.gamelogic.pieces.movechecker.RookChecker;

public class Rook extends Piece {

    public Rook(PieceColor color, Position piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public MoveChecker getPieceMoveChecker() {
        return new RookChecker(this);
    }

}
