package XXLChess.players;

import java.util.List;

import XXLChess.LogicObject;
import XXLChess.Pieceset;
import XXLChess.Tileset;
import XXLChess.board.Tile;
import XXLChess.board.logic.Move;
import XXLChess.enums.Colour;
import XXLChess.pieces.ChessPiece;
import processing.core.PApplet;

public class Player extends LogicObject {

    protected Colour playerColour;
    protected boolean hasSelected;
    protected List<Move> availableMoves;

    protected Player(PApplet parent, Colour playerColour) {
        super(parent);
        this.playerColour = playerColour;
        hasSelected = false; 
    }

    public void select(Tile tile, ChessPiece piece, Tileset tiles, Pieceset pieces) {
    }

    public void deselect(Tileset tiles, Pieceset pieces) {
    }

    public boolean hasSelected() {
        return hasSelected;
    }

    public Colour getColour() {
        return playerColour;
    }

    public void makeMove() {
    }

    public boolean hasWon() {
        return false; 
    }

    public boolean isInCheck() {
        return false;
    }
}
