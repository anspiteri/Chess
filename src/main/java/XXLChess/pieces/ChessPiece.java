package XXLChess.pieces;

import XXLChess.GameObject;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class ChessPiece extends GameObject {
    protected PImage image;

    protected ChessPiece(PApplet parent, PImage image) {
        super(parent);
        this.image = image;
    }

    protected PImage getImage() {
        return image;
    }
}
