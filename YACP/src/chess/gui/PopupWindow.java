package chess.gui;

import chess.gamelogic.pieces.PieceColor;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupWindow extends Stage {
    private Scene dialogScene;
    private VBox dialogVBox;
    private Text dialogMessage;
    private Button closeButton;

    public PopupWindow(Stage primaryStage, boolean timerUp, PieceColor player) {
        super();
        initializeWindow(primaryStage, timerUp, player);
    }

    private void initializeWindow(Stage primaryStage, boolean timerUp, PieceColor player) {
        this.initModality(Modality.APPLICATION_MODAL);
        this.initOwner(primaryStage);
        initializeComponents(timerUp, player);
        dialogVBox = new VBox(20);
        dialogVBox.setAlignment(Pos.CENTER);
        dialogVBox.getChildren().add(dialogMessage);
        dialogVBox.getChildren().add(closeButton);
        dialogScene = new Scene(dialogVBox, 300, 200);
        this.setScene(dialogScene);
    }

    private void initializeComponents(boolean timerUp, PieceColor player) {
        String message = timerUp ? "Timer up. " + player + " lost." : "Congratulations! " + player + " won!";
        dialogMessage = new Text(message);
        closeButton = new Button("Ok");
        closeButton.setOnAction(this::closeButtonHandler);
    }

    private void closeButtonHandler(ActionEvent event) {
        this.close();
    }
}
