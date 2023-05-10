package XXLChess.pieces;

import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;

public class Empty extends ChessPiece {
    private String key = "T";

    public Empty(PApplet parent, PieceColour colour, int x, int y) {
        super(parent, colour, x, y);
    }

    @Override
    public String toString() {
        return key;
    }
        
    
    @Override
    public void display() {
    }
}
