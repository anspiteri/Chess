package XXLChess.pieces;

import XXLChess.App;
import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;

public class General extends ChessPiece {
    private String keyB = "G";
    private String keyW = "g";

    public General(PApplet parent, PieceColour colour, int x, int y) {
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

    @Override
    public void loadImage() {
        if (this.colour == PieceColour.BLACK) {
            try {
                image = parent.loadImage(App.PATH + "b-knight-king.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else if (this.colour == PieceColour.WHITE) {
            try {
                image = parent.loadImage(App.PATH + "w-knight-king.png");
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
