package XXLChess;

enum TileColour {
    WHITE, BLACK
}

/*
 *  Blue – the player clicked on a piece, and it is able to move to this square.
 *  Light red – the currently selected piece can move to this square, capturing the current piece there
 *  Green – the player’s currently selected piece
 *  Yellow – the last piece to move, and the square it came from
 *  Dark red – the king on this square is currently in check, or checkmate has occurred (pieces that
 *  contribute to the checkmate are highlighted in light red)
 */
enum HighlightColour {
    BLUE, LIGHT_RED, GREEN, YELLOW, DARK_RED
}

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