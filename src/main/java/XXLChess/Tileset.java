package XXLChess;

import XXLChess.board.Tile;
import XXLChess.board.enums.TileColour;
import processing.core.PApplet;

public class Tileset extends DisplayObject {
    
    private int CELLSIZE;

    private Tile[][] tiles;
    private TileColour tileColour;

    public Tileset(PApplet parent, int BOARD_WIDTH, int CELLSIZE) {
        super(parent);
        this.CELLSIZE = CELLSIZE;
        tiles = new Tile[BOARD_WIDTH][BOARD_WIDTH];
    }

    @Override
    public void setup() {
        for (int i = 0; i < tiles.length; i++) {
            // determine the starting colour per row
            if (i % 2 == 0) {
                tileColour = TileColour.WHITE;
            } else {
                tileColour = TileColour.BLACK;
            }
            
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = new Tile(parent, j * CELLSIZE, i * CELLSIZE, tileColour, CELLSIZE);
                // logic used to create alternating black and white tiles across rows
                if (tileColour == TileColour.WHITE) {
                    tileColour = TileColour.BLACK;
                } else {
                    tileColour = TileColour.WHITE;
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
}
