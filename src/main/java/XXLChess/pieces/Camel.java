package XXLChess.pieces;

import XXLChess.App;
import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;

public class Camel extends ChessPiece {
    private String keyB = "C";
    private String keyW = "c";

    public Camel(PApplet parent, PieceColour colour, int x, int y) {
        super(parent, colour, x, y);
    }

    @Override
    public String toString() {
        if (colour == PieceColour.BLACK) {
            return keyB;
        } else {
            return keyW;
        }
    }

    public void loadImage() {
        if (this.colour == PieceColour.BLACK) {
            try {
                image = parent.loadImage(App.PATH + "b-camel.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else if (this.colour == PieceColour.WHITE) {
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
