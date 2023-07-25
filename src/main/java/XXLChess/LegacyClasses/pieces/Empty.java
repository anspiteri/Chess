package XXLChess.LegacyClasses.pieces;

import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Empty extends ChessPiece {
    private String key = "T";

    public Empty(PApplet parent, int x, int y, Colour colour, int row, int col) {
        super(parent, x, y, colour, row, col);
    }

    @Override
    public String toString() {
        return key;
    }
        
    
    @Override
    public void display() {
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
