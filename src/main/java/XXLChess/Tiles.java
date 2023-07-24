package XXLChess;

import XXLChess.enums.Colour;

public class Tiles {
    private Colour[] tileList;

    public Tiles(int numberOfTiles) {
        tileList = new Colour[numberOfTiles];
        
        for(int i = 0; i < tileList.length; i++) {
            if (isLight(i)) {
                tileList[i] = Colour.WHITE;
            } else {
                tileList[i] = Colour.BLACK;
            }
        }
    }

    /**
     * Algorithm which returns whether a tile of board index 'i' is a light/white tile.
     * @param i - board index of the tile. Must be an integer within the range {0, 1, 2, ..., 62, 63} for an 8x8 board. 
     * @return true or false for whether is a light/white tile.
     */
    private boolean isLight(int i) {
        return 0 == (((i >> 3) ^ i) & 1);
    }

    public Colour[] getTileList() {
        return tileList;
    }
}