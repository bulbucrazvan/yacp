package chess.gamelogic.pieces.movechecker;

import chess.gamelogic.Board;
import chess.gamelogic.Position;
import chess.gamelogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class QueenChecker extends MoveChecker {

    public QueenChecker(Piece boardPiece) {
        super(boardPiece);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> legalMoves = new ArrayList<>();
        legalMoves.addAll(getPossibleStraightMoves(Board.getBoardSize()));
        legalMoves.addAll(getPossibleDiagonalMoves(Board.getBoardSize()));
        return legalMoves;
    }
}
