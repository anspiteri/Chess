package XXLChess;

import XXLChess.board.Tile;
import XXLChess.board.enums.TileColour;
import processing.core.PApplet;

public class Tileset extends DisplayObject {

    private Tile[][] tiles;
    private TileColour tileColour;

    public Tileset(PApplet parent) {
        super(parent);
        tiles = new Tile[App.BOARD_WIDTH][App.BOARD_WIDTH];
    }

    public void setup() {
        for (int i = 0; i < tiles.length; i++) {
            // determine the starting colour per row
            if (i % 2 == 0) {
                tileColour = TileColour.WHITE;
            } else {
                tileColour = TileColour.BLACK;
            }
            
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = new Tile(parent, j * App.CELLSIZE, i * App.CELLSIZE, tileColour);
                // logic used to create alternating black and white tiles across rows
                if (tileColour == TileColour.WHITE) {
                    tileColour = TileColour.BLACK;
                } else {
                    tileColour = TileColour.WHITE;
                }
            }
        }
    }

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
