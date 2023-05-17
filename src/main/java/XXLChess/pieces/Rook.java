package XXLChess.pieces;

import XXLChess.App;
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
    public void loadImage() {
        if (this.colour == Colour.BLACK) {
            try {
                image = parent.loadImage(App.PATH + "b-rook.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else if (this.colour == Colour.WHITE) {
            try {
                image = parent.loadImage(App.PATH + "w-rook.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public String getKey() {
        return this.key;
    }
}
