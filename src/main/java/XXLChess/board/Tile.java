package XXLChess.board;

import XXLChess.GameObject;
import XXLChess.board.enums.HighlightColour;
import XXLChess.board.enums.TileColour;

public class Tile extends GameObject {

    private int x;
    private int y;
    private TileColour colour; 
    private HighlightColour highlightColour;
    private boolean highlight;

    public Tile (int x, int y, TileColour colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.highlightColour = null;
        this.highlight = false;
    }

    public void setHighlight(HighlightColour highlightColour) {
        this.highlightColour = highlightColour;
        this.highlight = true;
    }

    public HighlightColour getHighlightColour() {
        return this.highlightColour;
    }

    public void removeHighlight() {
        this.highlightColour = null;
        this.highlight = false;
    }

    public boolean highlighted() {
        return highlight;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public TileColour getTileColour() {
        return colour;
    }
}