package XXLChess.pieces;

import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;
import processing.core.PImage;

public class Pawn extends ChessPiece {

    public Pawn(PApplet parent, PImage image, PieceColour colour, int x, int y) {
        super(parent, image, colour, x, x);
    }
    
}
