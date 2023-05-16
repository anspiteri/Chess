package XXLChess.board;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import XXLChess.App;
import XXLChess.DisplayObject;
import XXLChess.enums.Colour;
import XXLChess.enums.HighlightColour;
import processing.core.PApplet;

public class Tile extends DisplayObject {

    private final int WHITE = parent.color(255, 255, 240);
    private final int BLACK = parent.color(85, 63, 47);
    private final int BLUE = parent.color(0, 0, 255);
    private final int LIGHT_RED = parent.color(255, 153, 153);
    private final int GREEN = parent.color(0, 255, 0);
    private final int YELLOW = parent.color(255, 255, 0);
    private final int DARK_RED = parent.color(153, 0, 0);
    private final float HIGHLIGHT_AMT = 0.5f;

    private final Map<Colour, Integer> colorDict;

    private HighlightColour highlightColour;
    private boolean highlighted, occupied;

    public Tile (PApplet parent, int x, int y, Colour colour) {
        super(parent, x, y, colour);
        
        highlightColour = null;
        highlighted = false;
        occupied = false; 

        colorDict = Collections.unmodifiableMap(new HashMap<Colour, Integer>() {{
            put(Colour.WHITE, WHITE);
            put(Colour.BLACK, BLACK);
        }});
    }  

    public void setHighlight(HighlightColour highlightColour) {
        this.highlightColour = highlightColour;
        this.highlighted = true;
    }

    public HighlightColour getHighlightColour() {
        return this.highlightColour;
    }

    public boolean gethighlighted() {
        return highlighted;
    } 

    public void removeHighlight() {
        this.highlightColour = null;
        this.highlighted = false;
    }

    public Colour getTileColour() {
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

    public void display() {

        if (colour == Colour.WHITE) {
            parent.fill(this.WHITE);
        } else {
            parent.fill(this.BLACK);
        }
        if (highlighted) {
            switch (highlightColour) {
                case BLUE:
                    parent.fill(parent.lerpColor(colorDict.get(this.colour), BLUE, HIGHLIGHT_AMT));
                    break;
                case LIGHT_RED:
                    parent.fill(parent.lerpColor(colorDict.get(this.colour), LIGHT_RED, HIGHLIGHT_AMT));
                    break;
                case GREEN:
                    parent.fill(parent.lerpColor(colorDict.get(this.colour), GREEN, HIGHLIGHT_AMT));
                    break;
                case YELLOW:
                    parent.fill(parent.lerpColor(colorDict.get(this.colour), YELLOW, HIGHLIGHT_AMT));
                    break;
                case DARK_RED:
                    parent.fill(parent.lerpColor(colorDict.get(this.colour), DARK_RED, HIGHLIGHT_AMT));
                    break;
                default:
                    parent.stroke(0);
            }
        } else {
            parent.stroke(0);
            parent.strokeWeight(1);
        }
        parent.rect(x, y, App.CELLSIZE, App.CELLSIZE);
    }
}