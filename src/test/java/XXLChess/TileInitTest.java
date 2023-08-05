package XXLChess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import XXLChess.board.Tiles;
import XXLChess.enums.Colour;

public class TileInitTest {
    @Test
    void TestWhiteTiles() {
        Tiles testTiles = new Tiles(App.BOARD_WIDTH*App.BOARD_WIDTH);
        // Initial loop runs through each row of the board. 
        // Nested loops run through each tile in the row. 
        for (int i = 0; i < App.BOARD_WIDTH; i++) {
            // even rows have white at start
            if (i % 2 == 0) {
                for (int j = 0; j < App.BOARD_WIDTH; j += 2) {
                    assertEquals(Colour.WHITE, testTiles.getTile(j + (i*App.BOARD_WIDTH)));
                }
                for (int j = 1; j < App.BOARD_WIDTH; j += 2) {
                    assertEquals(Colour.BLACK, testTiles.getTile(j + (i*App.BOARD_WIDTH)));
                }
            // odd rows have black at the start
            } else {
                for (int k = 0; k < App.BOARD_WIDTH; k += 2) {
                    assertEquals(Colour.BLACK, testTiles.getTile(k + (i*App.BOARD_WIDTH)));
                }
                for (int k = 1; k < App.BOARD_WIDTH; k += 2) {
                    assertEquals(Colour.WHITE, testTiles.getTile(k + (i*App.BOARD_WIDTH)));
                }
            }
        }
    }
}
