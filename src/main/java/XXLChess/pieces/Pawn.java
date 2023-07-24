package XXLChess.pieces;

import java.util.ArrayList;
import java.util.List;

import XXLChess.App;
import XXLChess.LegacyClasses.Pieceset;
import XXLChess.LegacyClasses.Tileset;
import XXLChess.board.logic.Move;
import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Pawn extends ChessPiece {
    private String keyB = "P";
    private String keyW = "p";

    public Pawn(PApplet parent, int x, int y, Colour colour, int row, int col) {
        super(parent, x, y, colour, row, col);
        this.x = x;
        this.y = y;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        if (colour == Colour.BLACK) {
            return keyB;
        } else {
            return keyW;
        }
    } 

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override 
    public int getCol() {
        return this.col;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public List<Move> getValidMoves(Tileset tiles, Pieceset pieces) {
        List<Move> validMoves = new ArrayList<>();
        int currentRow = this.row, currentCol = this.col, boardDir = 1;

        if (direction == "Up") {
            boardDir = -1;
        }

        // check forward square
        int forwardRow = currentRow + (1 * boardDir);
        if ((forwardRow < App.BOARD_WIDTH) & (forwardRow > 0)) {
            if (tiles.getTile(forwardRow, currentCol).getOccupied() == false) {
                validMoves.add(new Move(forwardRow, currentCol, this));  
                
                // if forward row is unblocked, than can check if next forward row is available.
                if (firstMove) {
                    int doubleforwardRow = currentRow + (2 * boardDir);
                    if ((doubleforwardRow < App.BOARD_WIDTH) 
                        & (tiles.getTile(doubleforwardRow, currentCol).getOccupied() == false)) {
                            validMoves.add(new Move(doubleforwardRow, currentCol, this));
                    }
                }
            }
        }

        // check if capture available
        int[] captureCol = {currentCol - 1, currentCol + 1};
        if (captureCol[0] >= 0) {
            if (tiles.getTile(forwardRow, captureCol[0]).getOccupied()) {
                if (pieces.getPiece(forwardRow, captureCol[0]).getColour() != this.colour) {
                    Move newMove = new Move(forwardRow, captureCol[0], this, true);
                
                    if ((pieces.getPiece(forwardRow, captureCol[0]).getKey() == "K") 
                        | (pieces.getPiece(forwardRow, captureCol[0]).getKey() == "k")) {
                        newMove.setCheck();
                    }
                    validMoves.add(newMove);
                }
                
            }
        }
        
        if (captureCol[1] < App.BOARD_WIDTH) {
            if (tiles.getTile(forwardRow, captureCol[1]).getOccupied()) {
                if (pieces.getPiece(forwardRow, captureCol[1]).getColour() != this.colour) {
                    Move newMove = new Move(forwardRow, captureCol[1], this, true);
                
                    if ((pieces.getPiece(forwardRow, captureCol[1]).getKey() == "K") 
                        | (pieces.getPiece(forwardRow, captureCol[1]).getKey() == "k")) {
                        newMove.setCheck();
                    }
                    validMoves.add(newMove);
                }
            }
        }

        // TODO: Add special moves for pawn, changing to queen at end of board?
        
        return validMoves;
    }
}
