package XXLChess.pieces;

import XXLChess.enums.Colour;
import processing.core.PApplet;

public class King extends ChessPiece {
    private String keyB = "K";
    private String keyW = "k";

    public King(PApplet parent, int x, int y, Colour colour, int row, int col) {
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
