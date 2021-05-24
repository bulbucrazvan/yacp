package chess.gamelogic.pieces.movechecker;

import chess.gamelogic.Position;
import chess.gamelogic.pieces.Pawn;
import chess.gamelogic.pieces.Piece;
import chess.gamelogic.pieces.PieceColor;

import java.util.ArrayList;
import java.util.List;

public class PawnChecker extends MoveChecker {
    public PawnChecker(Piece boardPiece) {
        super(boardPiece);
        canCapture = false;
    }

    @Override
    public List<Position> getPossibleMoves() {
        Pawn currentPawn = (Pawn)boardPiece;
        int movesLimit = currentPawn.hasMoved() ? 1 : 2;
        if (boardPiece.getPieceColor() == PieceColor.BLACK){
            return getPossibleMovesBlack(movesLimit);
        }
        return getPossibleMovesWhite(movesLimit);
    }

    private List<Position> getPossibleMovesBlack(int movesLimit){
        List<Position> possibleMoves = new ArrayList<>();
        canCapture = false;
        possibleMoves.addAll(getPossibleSouthMoves(movesLimit));
        canCapture = true;
        possibleMoves.addAll(filterDiagonalMoves(getPossibleSouthEastMoves(1)));
        possibleMoves.addAll(filterDiagonalMoves(getPossibleSouthWestMoves(1)));
        return possibleMoves;
    }

    private List<Position> getPossibleMovesWhite(int movesLimit) {
        List<Position> possibleMoves = new ArrayList<>();
        canCapture = false;
        possibleMoves.addAll(getPossibleNorthMoves(movesLimit));
        canCapture = true;
        possibleMoves.addAll(filterDiagonalMoves(getPossibleNorthEastMoves(1)));
        possibleMoves.addAll(filterDiagonalMoves(getPossibleNorthWestMoves(1)));
        return possibleMoves;
    }

    private List<Position> filterDiagonalMoves(List<Position> possibleMoves) {
        if (!possibleMoves.isEmpty()) {
            if (gameBoard.getPieceAtPosition(possibleMoves.get(0)) == null) {
                possibleMoves.clear();
            }
        }
        return possibleMoves;
    }

}
