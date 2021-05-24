package chess.gamelogic.pieces;
import chess.gamelogic.Board;
import chess.gamelogic.Position;
import chess.gamelogic.pieces.movechecker.MoveChecker;

import java.util.List;

public abstract class Piece {
    protected PieceColor pieceColor;
    protected Position piecePosition;
    protected MoveChecker pieceMoveChecker;

    public Piece(PieceColor color, Position piecePosition){
        pieceColor = color;
        this.piecePosition = piecePosition;
        pieceMoveChecker = getPieceMoveChecker();
    }

    public abstract String getName();

    public abstract MoveChecker getPieceMoveChecker();

    public void movePiece(Position newPosition){
        piecePosition = newPosition;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public Position getPiecePosition(){
        return piecePosition;
    }


    public List<Position> getPossibleMoves(Board gameBoard){
        pieceMoveChecker.setGameBoard(gameBoard);
        return pieceMoveChecker.getPossibleMoves();
    };
}
