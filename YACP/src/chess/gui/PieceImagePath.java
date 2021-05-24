package chess.gui;

import chess.gamelogic.pieces.Piece;

import java.util.Locale;

public class PieceImagePath {

    public static String getPath(Piece chessPiece){
        return "/chess/gui/pieceImages/" + chessPiece.getPieceColor().toString().toLowerCase(Locale.ROOT) + chessPiece.getName() + ".png";
    }
}
