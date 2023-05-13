package XXLChess.pieces;

import XXLChess.App;
import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Camel extends ChessPiece {
    private String keyB = "C";
    private String keyW = "c";

    public Camel(PApplet parent, int x, int y, Colour colour) {
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

    public void loadImage() {
        if (this.colour == Colour.BLACK) {
            try {
                image = parent.loadImage(App.PATH + "b-camel.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else if (this.colour == Colour.WHITE) {
            try {
                image = parent.loadImage(App.PATH + "w-camel.png");
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
