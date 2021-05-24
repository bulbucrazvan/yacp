package chess.gamelogic;

import chess.gui.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class TurnTimer {
    private Timeline timer;
    private GameController gameController;
    private int remainingTime;

    public TurnTimer(GameController gameController) {
        this.gameController = gameController;
        timer = new Timeline();
        timer.getKeyFrames().add(new KeyFrame(Duration.seconds(1), this::runTimer));
    }

    public void startTimer(int remainingTime) {
        this.remainingTime = remainingTime;
        timer.setCycleCount(remainingTime);
        timer.play();
    }

    public void stopTimer() {
        timer.stop();
    }

    private void runTimer(ActionEvent event) {
        remainingTime--;
        gameController.updateTimer(remainingTime);
        if (remainingTime == 0) {
            gameController.endGame(true);
        }
    }

    public int getRemainingTime() {
        return remainingTime;
    }

}
