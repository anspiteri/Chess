package XXLChess.players;

import XXLChess.Pieceset;
import XXLChess.Tileset;
import XXLChess.board.Tile;
import XXLChess.board.logic.Move;
import XXLChess.enums.Colour;
import XXLChess.pieces.ChessPiece;
import processing.core.PApplet;

public class HumanPlayer extends Player {

    public HumanPlayer(PApplet parent, Colour playerColour) {
        super(parent, playerColour);
        this.hasSelected = false;
        this.availableMoves = null;
    }

    public boolean isValidMove(int row, int col) {
        if (availableMoves != null) {
            for (Move move : availableMoves) {
                if ((move.getNewRow() == row) & (move.getNewCol() == col)) {
                    return true; 
                }
            }
        }
        
        return false;
    }

    public void makeMove(Tile tile, Tileset tiles, Pieceset pieces) {
        int newRow = tile.getRow();
        int newCol = tile.getCol();
        
        for (Move move : availableMoves) {
            if ((move.getNewRow() == newRow) & (move.getNewCol() == newCol)) {
                if (move.isCaptureMove()) {
                    pieces.capturePiece(pieces.getPiece(newRow, newCol), newRow, newCol);
                } else {
                    pieces.movePiece(pieces.getPiece(newRow, newCol), newRow, newCol);
                }
            }
        }
    }

    /**
     * select
     * @param tile
     * @param piece
     */
    @Override
    public void select(Tile tile, ChessPiece piece, Tileset tiles, Pieceset pieces) {
        this.deselect(tiles, pieces);
        hasSelected = true;
        availableMoves = piece.getValidMoves(tiles, pieces);
        tiles.selectTile(tile);
        pieces.selectPiece(piece);

        if (availableMoves != null) {
            for (Move move : availableMoves) {
                tiles.addHighlight(move.getNewRow(), move.getNewCol(), move.isCaptureMove());
            }
        }

    }

    /**
     * deselect
     */
    @Override
    public void deselect(Tileset tiles, Pieceset pieces) {
        hasSelected = false;
        availableMoves = null;
        tiles.deselectTile();
        pieces.deselectPiece();
    }
}
