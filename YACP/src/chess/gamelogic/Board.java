package chess.gamelogic;
import chess.gamelogic.pieces.*;

public class Board {
    private final static int BOARD_SIZE = 8;
    Piece[][] boardPieces = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board(){
        initializeBoard();
    }

    public static int getBoardSize(){
        return BOARD_SIZE;
    }

    public Piece getPieceAtPosition(Position givenPosition) {
        return getPieceAtPosition(givenPosition.getPositionX(), givenPosition.getPositionY());
    }

    public Piece getPieceAtPosition(int positionX, int positionY){
        if (positionX >= 0 && positionX < BOARD_SIZE && positionY >= 0 && positionY < BOARD_SIZE){
            return boardPieces[positionX][positionY];
        }
        return null;
    }

    public boolean isInBounds(int positionX, int positionY){
        return ((positionX >= 0 && positionX < BOARD_SIZE) && (positionY >= 0 && positionY < BOARD_SIZE));
    }

    public void executeMove(Move givenMove, Game currentGame){
        Position startingPosition = givenMove.getStartingPosition(), endingPosition = givenMove.getEndingPosition();
        if (getPieceAtPosition(endingPosition) instanceof King){
            currentGame.setGameEndedFlag();
        }
        Piece movenPiece = getPieceAtPosition(startingPosition);
        movenPiece.movePiece(endingPosition);
        boardPieces[endingPosition.getPositionX()][endingPosition.getPositionY()] = movenPiece;
        boardPieces[startingPosition.getPositionX()][startingPosition.getPositionY()] = null;
    }

    private Piece initializePieceAtIndex(int pieceRow, int index, PieceColor color){
        Position piecePosition = new Position(pieceRow, index);
        if (index == 0 || index == 7){
            return new Rook(color, piecePosition);
        }
        else if (index == 1 || index == 6){
            return new Knight(color, piecePosition);
        }
        else if (index == 2 || index == 5){
            return new Bishop(color, piecePosition);
        }
        else if (index == 3){
            return new Queen(color, piecePosition);
        }
        else {
            return new King(color, piecePosition);
        }
    }

    private void initializeBoard(){
        for (int i = 0; i < BOARD_SIZE; i++){
            boardPieces[0][i] = initializePieceAtIndex(0, i, PieceColor.BLACK);
            boardPieces[BOARD_SIZE - 1][i] = initializePieceAtIndex(BOARD_SIZE - 1, i, PieceColor.WHITE);
            boardPieces[1][i] = new Pawn(PieceColor.BLACK, new Position(1, i));
            boardPieces[BOARD_SIZE - 2][i] = new Pawn(PieceColor.WHITE, new Position(BOARD_SIZE - 2, i));
        }
    }


}
