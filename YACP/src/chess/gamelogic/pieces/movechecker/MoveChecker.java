package chess.gamelogic.pieces.movechecker;

import chess.gamelogic.Board;
import chess.gamelogic.Position;
import chess.gamelogic.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class MoveChecker {
    protected Piece boardPiece;
    protected Board gameBoard;
    protected boolean canCapture = true;

    public MoveChecker(Piece boardPiece) {
        this.boardPiece = boardPiece;
    }

    public abstract List<Position> getPossibleMoves();

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    protected List<Position> getPossibleNorthMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        int positionY = boardPiece.getPiecePosition().getPositionY();
        for (int positionX = boardPiece.getPiecePosition().getPositionX() - 1,  moves = 0; positionX >= 0 && moves < movesLimit; positionX--, moves++) {
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleSouthMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        int positionY = boardPiece.getPiecePosition().getPositionY();
        for (int positionX = boardPiece.getPiecePosition().getPositionX() + 1, moves = 0; positionX < gameBoard.getBoardSize() && moves < movesLimit; positionX++, moves++) {
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleEastMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        int positionX = boardPiece.getPiecePosition().getPositionX();
        for (int positionY = boardPiece.getPiecePosition().getPositionY() + 1, moves = 0; positionY < gameBoard.getBoardSize() && moves < movesLimit; positionY++, moves++) {
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleWestMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        int positionX = boardPiece.getPiecePosition().getPositionX();
        for (int positionY = boardPiece.getPiecePosition().getPositionY() - 1, moves = 0; positionY >= 0 && moves < movesLimit; positionY--, moves++) {
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleNorthWestMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        for (int positionX = boardPiece.getPiecePosition().getPositionX() - 1, positionY = boardPiece.getPiecePosition().getPositionY() - 1, moves = 0;
             positionX >= 0 && positionY >= 0 && moves < movesLimit;
             positionX--, positionY--, moves++){
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleNorthEastMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        for (int positionX = boardPiece.getPiecePosition().getPositionX() - 1, positionY = boardPiece.getPiecePosition().getPositionY() + 1, moves = 0;
             positionX >= 0 && positionY < gameBoard.getBoardSize() && moves < movesLimit;
             positionX--, positionY++, moves++){
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleSouthWestMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        for (int positionX = boardPiece.getPiecePosition().getPositionX() + 1, positionY = boardPiece.getPiecePosition().getPositionY() - 1, moves = 0;
             positionX < gameBoard.getBoardSize() && positionY >= 0 && moves < movesLimit;
             positionX++, positionY--, moves++){
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleSouthEastMoves(int movesLimit) {
        List<Position> legalMoves = new ArrayList<>();
        for (int positionX = boardPiece.getPiecePosition().getPositionX() + 1, positionY = boardPiece.getPiecePosition().getPositionY() + 1, moves = 0;
             positionX < gameBoard.getBoardSize() && positionY < gameBoard.getBoardSize() && moves < movesLimit;
             positionX++, positionY++, moves++){
            if (checkPosition(gameBoard, legalMoves, positionY, positionX)) break;
        }
        return legalMoves;
    }

    protected List<Position> getPossibleStraightMoves(int movesLimit){
        List<Position> legalMoves = new ArrayList<>();
        legalMoves.addAll(getPossibleNorthMoves(movesLimit));
        legalMoves.addAll(getPossibleSouthMoves(movesLimit));
        legalMoves.addAll(getPossibleEastMoves(movesLimit));
        legalMoves.addAll(getPossibleWestMoves(movesLimit));
        return legalMoves;
    }

    protected List<Position> getPossibleDiagonalMoves(int movesLimit){
        List<Position> legalMoves = new ArrayList<>();
        legalMoves.addAll(getPossibleNorthEastMoves(movesLimit));
        legalMoves.addAll(getPossibleNorthWestMoves(movesLimit));
        legalMoves.addAll(getPossibleSouthEastMoves(movesLimit));
        legalMoves.addAll(getPossibleSouthWestMoves(movesLimit));
        return legalMoves;
    }

    protected boolean checkPosition(Board gameBoard, List<Position> legalMoves, int positionY, int positionX) {
        Piece boardPiece = gameBoard.getPieceAtPosition(positionX, positionY);
        if (boardPiece == null) {
            legalMoves.add(new Position(positionX, positionY));
        }
        else {
            if (boardPiece.getPieceColor() != this.boardPiece.getPieceColor() && canCapture) {
                legalMoves.add(new Position(positionX, positionY));
            }
            return true;
        }
        return false;
    }
}
