package XXLChess.pieces;

import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;
import processing.core.PImage;

public class Amazon extends ChessPiece {
    private PieceColour colour;

    public Amazon(PApplet parent, PImage image, PieceColour colour) {
        super(parent, image);
        this.colour = colour;
    }
}
