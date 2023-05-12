package XXLChess.pieces;

import XXLChess.App;
import XXLChess.DisplayObject;
import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessPiece extends DisplayObject {
    protected PImage image;
    protected PieceColour colour;
    protected int x;
    protected int y;
    protected String key;

    protected ChessPiece(PApplet parent, PieceColour colour, int x, int y) {
        super(parent);
        
        this.image = null;
        this.colour = colour;
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
