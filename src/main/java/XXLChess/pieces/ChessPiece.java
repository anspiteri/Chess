package XXLChess.pieces;

import java.util.Map;

import XXLChess.App;
import XXLChess.DisplayObject;
import XXLChess.pieces.enums.Moveset;
import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessPiece extends DisplayObject {
    protected PImage image;
    protected Map<Moveset, Integer> moveset;
    protected PieceColour colour;
    protected int x;
    protected int y;

    protected ChessPiece(PApplet parent, PieceColour colour, int x, int y) {
        super(parent);
        
        this.image = null;
        this.moveset = null;
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public PImage getImage() {
        return image;
    }

    public void display() {
        parent.image(image, x, y, App.CELLSIZE, App.CELLSIZE);
    }

    public void loadImage() {
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
