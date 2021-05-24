package chess.gamelogic.pieces;

import chess.gamelogic.Position;
import chess.gamelogic.pieces.movechecker.MoveChecker;
import chess.gamelogic.pieces.movechecker.QueenChecker;

public class Queen extends Piece {

    public Queen(PieceColor color, Position piecePosition) {
        super(color, piecePosition);
    }

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public MoveChecker getPieceMoveChecker() {
        return new QueenChecker(this);
    }

}