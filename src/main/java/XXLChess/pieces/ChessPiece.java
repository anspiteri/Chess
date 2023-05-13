package XXLChess.pieces;

import XXLChess.App;
import XXLChess.DisplayObject;
import XXLChess.enums.Colour;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessPiece extends DisplayObject {
    protected PImage image;
    protected String key;

    protected ChessPiece(PApplet parent, int x, int y, Colour colour) {
        super(parent, x, y, colour);
        
        this.image = null;
        this.x = x;
        this.y = y;
        this.key = null;
    }

    public PImage getImage() {
        return image;
    }

    /**
     * Called in tileset class which is called in the draw() method of PApplet.
     */
    public void display() {
        parent.image(image, x, y, App.CELLSIZE, App.CELLSIZE);
    }

    /**
     * Implemented in every child class of Chesspiece for each distinct png.
     */
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

    public String getKey() {
        return this.key;
    }

}
