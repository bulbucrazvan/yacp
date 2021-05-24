package chess.gui;

import chess.gamelogic.*;
import chess.gamelogic.pieces.Piece;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.List;

public class BoardPanel extends GridPane {
    private GameController gameController;
    private Game gameModel;
    private Board boardModel;
    private boolean isMoveStarted;
    private Tile[][] boardTiles;
    private List<Position> possiblePieceMoves;
    private Piece startingMovePiece;

    public BoardPanel(GameController gameController, Game gameModel){
        this.gameController = gameController;
        this.gameModel = gameModel;
        boardModel = gameModel.getGameBoard();
        isMoveStarted = false;
        initializeBoard();
        initializeTiles();
    }

    private Player getCurrentPlayer(){
        return gameModel.getCurrentPlayer();
    }

    public void checkTileClick(Position tilePosition) {
        if (gameModel.getGameRunningFlag() && !gameModel.getGameEndedFlag()) {
            if (isMoveStarted) {
                finalizeMove(tilePosition);
            }
            else {
                Piece currentPiece = boardModel.getPieceAtPosition(tilePosition);
                if (currentPiece != null && getCurrentPlayer().getPlayerColor() == currentPiece.getPieceColor()) {
                    startMove(currentPiece);
                }
            }
        }
    }

    private void startMove(Piece givenPiece){
        possiblePieceMoves = givenPiece.getPossibleMoves(boardModel);
        if (possiblePieceMoves.isEmpty()){

        }
        else {
            updateTilesBackground(possiblePieceMoves, true);
            startingMovePiece = givenPiece;
            isMoveStarted = true;
        }
    }

    private void finalizeMove(Position finalPosition){
        if (possiblePieceMoves.contains(finalPosition)){
            Move playerMove = new Move(startingMovePiece.getPiecePosition(), finalPosition);
            boardModel.executeMove(playerMove, gameModel);
            updateTilesBackground(possiblePieceMoves, false);
            updateTiles(playerMove);
            isMoveStarted = false;
            gameController.finalizeMove();
        }
        else {
            updateTilesBackground(possiblePieceMoves, false);
            isMoveStarted = false;
        }
    }

    private void initializeBoard(){
        setAlignment(Pos.CENTER);
        setMaxHeight(GameController.getBoardHeight() - 2 * GameController.getConfigurationPanelHeight());
    }

    private void initializeTiles(){
        int boardSize = Board.getBoardSize();
        boardTiles = new Tile[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                boardTiles[i][j] = new Tile((i + j) % 2 == 0,boardModel.getPieceAtPosition(i, j), new Position(i, j), this);
                this.add(boardTiles[i][j], j, i);
            }
        }
    }

    private void updateTilesBackground(List<Position> possibleMoves, boolean lightUp){
        for (Position tilePosition : possibleMoves){
            boardTiles[tilePosition.getPositionX()][tilePosition.getPositionY()].updateBackground(lightUp);
        }
    }

    private void updateTiles(Move performedMove){
        Position startingPosition = performedMove.getStartingPosition();
        Position endingPosition = performedMove.getEndingPosition();
        boardTiles[startingPosition.getPositionX()][startingPosition.getPositionY()].updatePiece(boardModel.getPieceAtPosition(startingPosition));
        boardTiles[endingPosition.getPositionX()][endingPosition.getPositionY()].updatePiece(boardModel.getPieceAtPosition(endingPosition));
    }
}
