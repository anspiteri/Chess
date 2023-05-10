package XXLChess.board;

import XXLChess.App;
import XXLChess.DisplayObject;
import XXLChess.board.enums.HighlightColour;
import XXLChess.board.enums.TileColour;
import processing.core.PApplet;

public class Tile extends DisplayObject {

    private int x;
    private int y;

    private TileColour colour; 
    private HighlightColour highlightColour;

    private boolean highlighted;
    private boolean occupied;

    public Tile (PApplet parent, int x, int y, TileColour colour) {
        super(parent);
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.highlightColour = null;
        this.highlighted = false;
        this.occupied = false; 
    }

    public void display() {
        if (colour == TileColour.WHITE) {
            parent.fill(255, 255, 240);
        } else {
            parent.fill(85, 63, 47);
        }
        if (highlighted) {
            switch (highlightColour) {
                case BLUE:
                    parent.stroke(0, 0, 255, 30);
                    break;
                case LIGHT_RED:
                    parent.stroke(255, 153, 153, 30);
                    break;
                case GREEN:
                    parent.stroke(0, 255, 0, 30);
                    break;
                case YELLOW:
                    parent.stroke(255, 255, 0, 30);
                    break;
                case DARK_RED:
                    parent.stroke(153, 0, 0, 30);
                    break;
                default:
                    parent.stroke(0);
            }
            parent.strokeWeight(4);
        } else {
            parent.stroke(0);
            parent.strokeWeight(1);
        }
        parent.rect(x, y, App.CELLSIZE, App.CELLSIZE);
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void setHighlight(HighlightColour highlightColour) {
        this.highlightColour = highlightColour;
        this.highlighted = true;
    }

    public HighlightColour getHighlightColour() {
        return this.highlightColour;
    }

    public void removeHighlight() {
        this.highlightColour = null;
        this.highlighted = false;
    }

    public boolean gethighlighted() {
        return highlighted;
    }

    public TileColour getTileColour() {
        return colour;
    }

    public void setOccupied(boolean makeOccupied) {
        if (makeOccupied) {
            this.occupied = true;
        } else {
            this.occupied = false;
        }
    }
    public boolean getOccupied() {
        return occupied;
    }
}