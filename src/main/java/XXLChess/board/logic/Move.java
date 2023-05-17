package XXLChess.board.logic;

import XXLChess.pieces.ChessPiece;

public class Move {
    private int newRow;
    private int newCol;

    private boolean captureMove;
    private ChessPiece capturedPiece;

    public Move(int newRow, int newCol) {

        this.newRow = newRow;
        this.newCol = newCol;

        this.captureMove = false;
        this.capturedPiece = null;
    }

    public Move(int newRow, int newCol, ChessPiece capturedPiece) {
        this.newRow = newRow;
        this.newCol = newCol;

        this.captureMove = true;
        this.capturedPiece = null;
    }

    public int getNewRow() {
        return newRow;
    }

    public int getNewCol() {
        return newCol;
    }

    public boolean isCaptureMove() {
        return captureMove;
    }

    public ChessPiece getCapturedPiece() {
        return capturedPiece;
    }
}
