package XXLChess.LegacyClasses;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import XXLChess.App;
import XXLChess.enums.Colour;
import XXLChess.enums.HighlightColour;
import processing.core.PApplet;

public class Tile {

    private boolean highlighted;

    public Tile (PApplet parent, int x, int y, Colour colour, int row, int col) {
        
        highlighted = false;


    public void setHighlight(HighlightColour highlightColour) {
        this.highlightColour = highlightColour;
        this.highlighted = true;
    }

    public void removeHighlight() {
        this.highlightColour = null;
        this.highlighted = false;
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