package XXLChess.players;

import java.util.List;

import XXLChess.LegacyClasses.LogicObject;
import XXLChess.LegacyClasses.Pieceset;
import XXLChess.LegacyClasses.Tileset;
import XXLChess.board.logic.Move;
import XXLChess.enums.Colour;
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

    public void deselect(Tileset tiles, Pieceset pieces) {
    }

    public boolean hasSelected() {
        return hasSelected;
    }

    public Colour getColour() {
        return playerColour;
    }

    public boolean hasWon() {
        return false; 
    }

    public boolean isInCheck() {
        return false;
    }
}
