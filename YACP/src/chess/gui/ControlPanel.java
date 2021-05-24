package chess.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlPanel extends HBox {
    private Button gameControlButton;
    private Button quitButton;
    private enum GameControlOptions {
        Start, Stop
    }
    private GameControlOptions currentState;
    private GameController gameController;

    public ControlPanel(GameController gameController){
        this.gameController = gameController;
        currentState = GameControlOptions.Start;
        initializeButtons();
        initializePanel();
    }

    private void initializeButtons() {
        gameControlButton = new Button(currentState.name());
        quitButton = new Button("Quit");
        gameControlButton.setOnAction(this::gameControlButtonHandler);
        quitButton.setOnAction(this::quitButtonHandler);
    }

    private void initializePanel() {
        this.setMinHeight(GameController.getConfigurationPanelHeight());
        this.setSpacing(200);
        this.setStyle("-fx-background-color: black");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(gameControlButton);
        this.getChildren().add(quitButton);
    }

    private void changeControlButtonState() {
        currentState = currentState == GameControlOptions.Start ? GameControlOptions.Stop : GameControlOptions.Start;
        gameControlButton.setText(currentState.name());
    }

    private void gameControlButtonHandler(ActionEvent e) {
        if (currentState == GameControlOptions.Start) {
            gameController.startGame();
        }
        else {
            gameController.pauseGame();
        }
        changeControlButtonState();
    }

    private void quitButtonHandler(ActionEvent e) {
        Stage stage = (Stage)quitButton.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException exception) {
            stage.close();
        }
    }
}
