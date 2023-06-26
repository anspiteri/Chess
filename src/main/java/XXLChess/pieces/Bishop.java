package XXLChess.pieces;

import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Bishop extends ChessPiece {
    private String keyB = "B";
    private String keyW = "b";

    public Bishop(PApplet parent, int x, int y, Colour colour, int row, int col) {
        super(parent, x, y, colour, row, col);
    }
    
    @Override
    public String toString() {
        if (colour == Colour.BLACK) {
            return keyB;
        } else {
            return keyW;
        }
    }

    @Override
    public String getKey() {
        return this.key;
    }
}
