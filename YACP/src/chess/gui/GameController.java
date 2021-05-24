package chess.gui;

import chess.gamelogic.Game;
import chess.gamelogic.Player;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameController {
    public final static int BOARD_HEIGHT = 720, BOARD_WIDTH = 1280, CONFIGURATION_PANEL_HEIGHT = 10, STARTING_TIMER = 20;
    private Stage mainStage;
    private Scene gameScene;
    private BorderPane rootNode;
    private InfoPanel infoPanel;
    private ControlPanel controlPanel;
    private BoardPanel boardPanel;
    private Game currentGame;

    public GameController(Stage mainStage) {
        this.mainStage = mainStage;
        currentGame = new Game(this);
        initializePanels();
    }

    public void showWindow() {
        gameScene = new Scene(rootNode, BOARD_WIDTH, BOARD_HEIGHT);
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public void startGame() {
        currentGame.run();
    }

    public void pauseGame() {
        currentGame.pause();
    }

    public void endGame(boolean timerUp) {
        currentGame.setGameEndedFlag();
        PopupWindow endGameDialog = new PopupWindow(mainStage, timerUp, currentGame.getCurrentPlayer().getPlayerColor());
        endGameDialog.show();
    }

    public void finalizeMove() {
        if (currentGame.getGameEndedFlag()) {
            endGame(false);
        }
        else {
            currentGame.changePlayerTurn();
            infoPanel.changePlayerTurn(currentGame.getCurrentPlayer());
        }
    }

    public void updateTimer(int remainingTime) {
        infoPanel.setTimerLabel(remainingTime);
    }

    private void initializePanels() {
        rootNode = new BorderPane();
        infoPanel = new InfoPanel();
        boardPanel = new BoardPanel(this, currentGame);
        controlPanel = new ControlPanel(this);
        rootNode.setTop(infoPanel);
        rootNode.setCenter(boardPanel);
        rootNode.setBottom(controlPanel);
    }

    public static int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    public static int getConfigurationPanelHeight() {
        return CONFIGURATION_PANEL_HEIGHT;
    }
}
