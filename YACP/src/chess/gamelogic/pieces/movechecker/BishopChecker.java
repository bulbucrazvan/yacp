package chess.gamelogic.pieces.movechecker;

import chess.gamelogic.Board;
import chess.gamelogic.Position;
import chess.gamelogic.pieces.Piece;

import java.util.List;

public class BishopChecker extends MoveChecker {

    public BishopChecker(Piece boardPiece) {
        super(boardPiece);
    }

    @Override
    public List<Position> getPossibleMoves() {
        return getPossibleDiagonalMoves(Board.getBoardSize());
    }
}
