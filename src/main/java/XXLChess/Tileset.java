package XXLChess;

import XXLChess.board.Tile;

public class Tileset extends App {
    private Tile[][] tiles;

    public Tileset() {
        tiles = new Tile[BOARD_WIDTH][BOARD_WIDTH];
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
                tiles[i][j] = new Tile(j * CELLSIZE, i * CELLSIZE, tileColour);
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
        
    }
}
