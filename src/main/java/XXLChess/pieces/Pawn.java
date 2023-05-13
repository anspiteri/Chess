package XXLChess.pieces;

import XXLChess.App;
import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Pawn extends ChessPiece {
    private String keyB = "P";
    private String keyW = "p";

    public Pawn(PApplet parent, int x, int y, Colour colour) {
        super(parent, x, y, colour);
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
                image = parent.loadImage(App.PATH + "b-pawn.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else if (this.colour == Colour.WHITE) {
            try {
                image = parent.loadImage(App.PATH + "w-pawn.png");
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
