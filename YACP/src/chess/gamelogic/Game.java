package chess.gamelogic;

import chess.gamelogic.pieces.PieceColor;
import chess.gui.GameController;

public class Game {
    private Board gameBoard;
    private Player[] gamePlayers = new Player[2];
    private boolean gameEndedFlag = false, gameRunningFlag = false;
    private int currentPlayer;
    private TurnTimer turnTimer;
    private GameController gameController;

    public Game(GameController gameController) {
        this.gameController = gameController;
        turnTimer = new TurnTimer(gameController);
        gamePlayers[0] = new Player(PieceColor.WHITE);
        gamePlayers[1] = new Player(PieceColor.BLACK);
        gameBoard = new Board();
    }

    public Player getCurrentPlayer(){
        return gamePlayers[currentPlayer];
    }

    public Board getGameBoard(){
        return gameBoard;
    }

    public void setGameEndedFlag(){
        gameEndedFlag = true;
    }

    public boolean getGameEndedFlag() {
        return gameEndedFlag;
    }

    public void setGameRunningFlag(boolean flag) {
        gameRunningFlag = flag;
    }

    public boolean getGameRunningFlag() {
        return gameRunningFlag;
    }

    public void changePlayerTurn() {
        turnTimer.stopTimer();
        updatePlayerTimer(currentPlayer, turnTimer.getRemainingTime());
        currentPlayer = (currentPlayer + 1) % 2;
        turnTimer.startTimer(gamePlayers[currentPlayer].getRemainingTime());
    }

    public void run() {
        setGameRunningFlag(true);
        turnTimer.startTimer(gamePlayers[currentPlayer].getRemainingTime());
    }

    public void pause() {
        setGameRunningFlag(false);
        turnTimer.stopTimer();
        updatePlayerTimer(currentPlayer, turnTimer.getRemainingTime());
    }

    private void updatePlayerTimer(int player, int remainingTime) {
        gamePlayers[player].setRemainingTime(remainingTime);
    }

}
