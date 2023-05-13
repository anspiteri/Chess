package XXLChess.players;

import java.util.ArrayList;

import XXLChess.LogicObject;
import XXLChess.enums.Colour;
import XXLChess.pieces.ChessPiece;
import processing.core.PApplet;

public class Player extends LogicObject {

    protected Colour playerColour;
    protected ArrayList<ChessPiece>[] capturedPieces;

    protected Player(PApplet parent, Colour playeColour) {
        super(parent);
        this.playerColour = playeColour;
    }

    public Colour getColour() {
        return playerColour;
    }

    public void makeMove() {
    }

    protected boolean isValidMove() {
        return false;
    }

    public boolean hasWon() {
        return false; 
    }

    public boolean isInCheck() {
        return false;
    }
}
