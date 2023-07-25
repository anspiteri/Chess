package XXLChess.LegacyClasses.pieces;

import java.util.List;

import XXLChess.App;
import XXLChess.LegacyClasses.DisplayObject;
import XXLChess.LegacyClasses.Pieceset;
import XXLChess.LegacyClasses.Tileset;
import XXLChess.LegacyClasses.board.logic.Move;
import XXLChess.enums.Colour;
import processing.core.PApplet;
import processing.core.PImage;

public class ChessPiece extends DisplayObject {
    protected PImage image;
    protected String key;
    protected int row, col;


    // moveset 
    protected String direction;
    protected boolean firstMove;

    protected ChessPiece(PApplet parent, int x, int y, Colour colour, int row, int col) {
        super(parent, x, y, colour);
        
        this.image = null;
        this.x = x;
        this.y = y;
        this.key = null;

        if (((App) parent).getHumanPlayer().getColour() == colour) {
            direction = "Up";
        } else {
            direction = "Down";
        }
        firstMove = true;
    }

    public PImage getImage() {
        return image;
    }

    public Colour getColour() {
        return colour;
    }

    /**
     * Called in tileset class which is called in the draw() method of PApplet.
     */
    public void display() {
        parent.image(image, x, y, App.CELLSIZE, App.CELLSIZE);
    }

    public List<Move> getValidMoves(Tileset tiles, Pieceset pieces) {
        return null;
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

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRowCol(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void checkFirstMove() {
        if (firstMove == true) {
            firstMove = false;
        }
    }

}
