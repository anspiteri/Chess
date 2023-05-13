package XXLChess;

import XXLChess.board.Tile;
import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Tileset extends SetObject {

    private Tile[][] tiles;
    private Colour tileColour;

    public Tileset(PApplet parent) {
        super(parent);
        tiles = new Tile[App.BOARD_WIDTH][App.BOARD_WIDTH];
    }

    @Override
    public void setup() {
        for (int i = 0; i < tiles.length; i++) {
            // determine the starting colour per row
            if (i % 2 == 0) {
                tileColour = Colour.WHITE;
            } else {
                tileColour = Colour.BLACK;
            }
            
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = new Tile(parent, j * App.CELLSIZE, i * App.CELLSIZE, tileColour);
                // logic used to create alternating black and white tiles across rows
                if (tileColour == Colour.WHITE) {
                    tileColour = Colour.BLACK;
                } else {
                    tileColour = Colour.WHITE;
                }
            }
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j].display();
            }
        }
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }

    public void clearHighlights() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j].removeHighlight();
            }
        }
    }
}
