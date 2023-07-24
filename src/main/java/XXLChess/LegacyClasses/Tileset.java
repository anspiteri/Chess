package XXLChess.LegacyClasses;

import XXLChess.App;
import XXLChess.enums.Colour;
import XXLChess.enums.HighlightColour;
import processing.core.PApplet;

public class Tileset extends SetObject {

    private Tile[][] tiles;
    private Tile selectedTile;

    public Tileset(PApplet parent) {
        super(parent);
        tiles = new Tile[App.BOARD_WIDTH][App.BOARD_WIDTH];
        selectedTile = null;
    }

    public void selectTile(Tile tile) {
        selectedTile = tile;
        this.clearHighlights();
        this.addHighlight(selectedTile, HighlightColour.GREEN);
    }

    public void deselectTile() {
        selectedTile = null;
        this.clearHighlights();
    }

    public void addHighlight(Tile tile, HighlightColour highlightColour) {
        tile.setHighlight(highlightColour);
    }

    public void addHighlight(int row, int col, HighlightColour highlightColour) {
        this.getTile(row, col).setHighlight(highlightColour);
    }

    public void addHighlight(int row, int col, boolean isCaptureMove) {
        if (isCaptureMove) {
            getTile(row, col).setHighlight(HighlightColour.LIGHT_RED);
        } else {
            getTile(row, col).setHighlight(HighlightColour.BLUE);
        }
    }

    private void clearHighlights() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j].removeHighlight();
            }
        }
    }

    public Tile checkTile(int mouseX, int mouseY) {
        Tile tile;

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                tile = tiles[row][col];

                // Check if mouse press is within bounds of tile. 
                if ( (mouseX > tile.getX() & mouseX < (tile.getX() + App.CELLSIZE))
                     & (mouseY > tile.getY() & mouseY < (tile.getY() + App.CELLSIZE)) ) {
                    return tile;                   
                }
            }
        }
        return null;
    }

    @Deprecated
    public Tile[][] getTiles() {
        return this.tiles;
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }
}
