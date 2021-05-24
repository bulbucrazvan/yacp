package chess.gui;

import chess.gamelogic.Player;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class InfoPanel extends HBox {
    private Label currentPlayerLabel;
    private Label timerLabel;

    public InfoPanel(){
        initializeLabels();
        initializePanel();
    }

    public void changePlayerTurn(Player currentPlayer) {
        currentPlayerLabel.setText("Current player: " + currentPlayer.getPlayerColor());
    }

    public void setTimerLabel(int remainingTime) {
        timerLabel.setText("Remaining time: " + remainingTime);
    }

    private void initializeLabels() {
        currentPlayerLabel = new Label("Current player: WHITE");
        currentPlayerLabel.setTextFill(Color.WHITE);
        timerLabel = new Label("Remaining time: " + GameController.STARTING_TIMER);
        timerLabel.setTextFill(Color.WHITE);
    }

    private void initializePanel() {
        this.setMinHeight(GameController.getConfigurationPanelHeight());
        this.setSpacing(200);
        this.setStyle("-fx-background-color: black");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(currentPlayerLabel);
        this.getChildren().add(timerLabel);
    }
}
