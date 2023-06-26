package XXLChess.pieces;

import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Rook extends ChessPiece {
    private String keyB = "R";
    private String keyW = "r";

    public Rook(PApplet parent, int x, int y, Colour colour, int row, int col) {
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
