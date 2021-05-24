package chess.gamelogic.pieces.movechecker;

import chess.gamelogic.Board;
import chess.gamelogic.Position;
import chess.gamelogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class KnightChecker extends MoveChecker {

    public KnightChecker(Piece boardPiece) {
        super(boardPiece);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> legalMoves = new ArrayList<>();
        int positionX = boardPiece.getPiecePosition().getPositionX(), positionY = boardPiece.getPiecePosition().getPositionY();
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                if (i != 0 && j != 0){
                    if (checkPosition(positionX + (2 * i), positionY + j, gameBoard)){
                        legalMoves.add(new Position(positionX + (2 * i), positionY + j));
                    }
                    if (checkPosition(positionX + j, positionY + (2 * i), gameBoard)){
                        legalMoves.add(new Position(positionX + j, positionY + (2 * i)));
                    }
                }
            }
        }
        return legalMoves;
    }

    private boolean checkPosition(int positionX, int positionY, Board gameBoard){
        if (gameBoard.isInBounds(positionX, positionY)){
            Piece boardPiece = gameBoard.getPieceAtPosition(positionX, positionY);
            if (boardPiece == null || boardPiece.getPieceColor() != this.boardPiece.getPieceColor()){
                return true;
            }
        }
        return false;
    }
}
