package chess.gui;

import chess.gamelogic.Board;
import chess.gamelogic.Position;
import chess.gamelogic.pieces.*;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Collections;

public class Tile extends StackPane {
    Color tileColor;
    Piece tilePiece;
    Position tilePosition;
    int tileSize;
    BoardPanel boardController;
    Border defaultTileBorder, selectedTileBorder;
    BackgroundFill tileFill, possibleMoveFill;
    BackgroundImage tileImage;
    Background tileBackground;

    public Tile(boolean colour, Piece chessPiece, Position tilePosition, BoardPanel boardController) {
        tileSize = (GameController.getBoardHeight() - 2 * GameController.getConfigurationPanelHeight() - 25) / Board.getBoardSize();
        tileColor = colour ? Color.valueOf("#feb") : Color.valueOf("#582");
        tilePiece = chessPiece;
        this.boardController = boardController;
        this.tilePosition = tilePosition;
        initializeTile();
        setOnMouseClicked(this::onTileClick);
    }

    public void updateBackground(boolean isPossibleMove){
        if (tilePiece == null){
            setTileBackground(isPossibleMove);
        }
        else {
            setTileBorder(isPossibleMove);
        }
    }

    public void updatePiece(Piece newPiece){
        tilePiece = newPiece;
        updateTileImage();
        setTileBackground(false);
    }

    private void initializeTile(){
        this.setMinWidth(tileSize);
        this.setMinHeight(tileSize);
        tileFill = new BackgroundFill(tileColor, null, null);
        possibleMoveFill = new BackgroundFill(Color.BLACK, new CornerRadii(50), new Insets(tileSize / 3));
        defaultTileBorder = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, BorderStroke.THIN));
        selectedTileBorder = new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, BorderStroke.THIN));
        updateTileImage();
        setTileBackground(false);
        setTileBorder(false);
    }

    private void updateTileImage(){
        if (tilePiece == null){
            tileImage = null;
        }
        else {
            tileImage = new BackgroundImage(new Image(PieceImagePath.getPath(tilePiece), tileSize * 0.8, tileSize * 0.8, true, true),
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
        }
    }

    private void setTileBackground(boolean isPossibleMove){
        if (isPossibleMove){
            tileBackground = new Background(Arrays.asList(tileFill, possibleMoveFill), Collections.singletonList(tileImage));
        }
        else {
            tileBackground = new Background(Collections.singletonList(tileFill), Collections.singletonList(tileImage));
        }
        setBackground(tileBackground);
    }

    private void setTileBorder(boolean isPossibleMove){
        if (isPossibleMove){
            setBorder(selectedTileBorder);
        }
        else {
            setBorder(defaultTileBorder);
        }
    }

    private void onTileClick(MouseEvent event){
        boardController.checkTileClick(tilePosition);
    }
}
