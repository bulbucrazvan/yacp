package chess.gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class MenuController {

    public void startGame(ActionEvent event){
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        GameController newGameController = new GameController(mainStage);
        newGameController.showWindow();
    }

    public void quit(ActionEvent event) {
        Stage mainStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainStage.close();
    }
}
