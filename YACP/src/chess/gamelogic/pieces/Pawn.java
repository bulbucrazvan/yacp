package chess.gamelogic.pieces;

import chess.gamelogic.Position;
import chess.gamelogic.pieces.movechecker.MoveChecker;
import chess.gamelogic.pieces.movechecker.PawnChecker;

public class Pawn extends Piece {
    private boolean hasMoved;

    public Pawn(PieceColor color, Position piecePosition) {
        super(color, piecePosition);
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public MoveChecker getPieceMoveChecker() {
        return new PawnChecker(this);
    }

    @Override
    public void movePiece(Position newPosition) {
        super.movePiece(newPosition);
        hasMoved = true;
    }

}
