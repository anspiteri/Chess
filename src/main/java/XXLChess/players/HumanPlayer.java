package XXLChess.players;

import XXLChess.Pieceset;
import XXLChess.Tileset;
import XXLChess.UI;
import XXLChess.board.Tile;
import XXLChess.board.logic.Move;
import XXLChess.enums.Colour;
import XXLChess.enums.HighlightColour;
import XXLChess.pieces.ChessPiece;
import processing.core.PApplet;

public class HumanPlayer extends Player {

    public HumanPlayer(PApplet parent, Colour playerColour) {
        super(parent, playerColour);
        this.hasSelected = false;
        this.availableMoves = null;
    }

    public Move isValidMove(int row, int col) {
        if (availableMoves != null) {
            for (Move move : availableMoves) {
                if ((move.getNewRow() == row) & (move.getNewCol() == col)) {
                    return move; 
                }
            }
        }
        
        return null;
    }

    public void makeMove(Move move, Tileset tiles, Pieceset pieces) {
        // Store location of moving piece. 
        int originalRow = move.getMovingPiece().getRow();
        int originalCol = move.getMovingPiece().getCol();
        int originalX = move.getMovingPiece().getX();
        int originalY = move.getMovingPiece().getY();
        
        // Get location of new board location. 
        int newRow = move.getNewRow();
        int newCol = move.getNewCol();
        int newX = pieces.getPiece(newRow, newCol).getX();
        int newY = pieces.getPiece(newRow, newCol).getY();

        // Move piece
        move.getMovingPiece().setX(newX);
        move.getMovingPiece().setY(newY);
        move.getMovingPiece().setRowCol(newRow, newCol);

        pieces.movePiece(move.getMovingPiece(), originalRow, originalCol);
        tiles.getTile(newRow, newCol).setOccupied(true);
        tiles.getTile(originalRow, originalCol).setOccupied(false);
        pieces.createPiece('T', originalX, originalY, originalRow, originalCol);

        move.getMovingPiece().checkFirstMove();
    }

    /**
     * select
     * @param tile
     * @param piece
     */
    public void select(Tile tile, ChessPiece piece, Tileset tiles, Pieceset pieces, UI ui) {
        this.deselect(tiles, pieces);
        hasSelected = true;
        availableMoves = piece.getValidMoves(tiles, pieces);
        tiles.selectTile(tile);
        pieces.selectPiece(piece);

        if (availableMoves != null) {
            for (Move move : availableMoves) {
                if (move.isCheck()) {
                    tiles.addHighlight(move.getNewRow(), move.getNewCol(), HighlightColour.DARK_RED);
                    ui.check();
                } else {
                    tiles.addHighlight(move.getNewRow(), move.getNewCol(), move.isCaptureMove());
                }
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
