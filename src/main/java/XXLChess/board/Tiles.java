package XXLChess.board;

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
     * Algorithm used for determining white or black tiles. You can try and figure out how it works 
     * on your own. 
     * @param i - board index of the tile. Must be an integer within the range {0, 1, 2, ..., 62, 63} 
     * for an 8x8 board. 
     * @return boolean for whether the tile at board index 'i' is a light/white tile. 
     */
    private boolean isLight(int i) {
        return 0 == (((i >> 3) ^ i) & 1);
    }

    public Colour[] getTileList() {
        return tileList;
    }

    public Colour getTile(int i) {
        return tileList[i];
    }
}