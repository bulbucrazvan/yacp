package chess.gamelogic;
import chess.gamelogic.pieces.PieceColor;
import chess.gui.GameController;

import java.util.Scanner;

public class Player {
    private PieceColor playerColor;
    private int remainingTime = GameController.STARTING_TIMER;

    public Player(PieceColor playerColor){
        this.playerColor = playerColor;
    }

    public PieceColor getPlayerColor(){
        return playerColor;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
