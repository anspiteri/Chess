package XXLChess.pieces;

import XXLChess.DisplayObject;
import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class ChessPiece extends DisplayObject {
    protected PImage image;

    protected PieceColour colour;
    protected int x;
    protected int y;
    // protected Player player;


    protected ChessPiece(PApplet parent, PImage image, PieceColour colour, int x, int y) {
        super(parent);
        this.image = image;
        this.colour = colour;
        this.x = x;
        this.y = y;
        // this.player = player;
    }

    protected PImage getImage() {
        return image;
    }
}
