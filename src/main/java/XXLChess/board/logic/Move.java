package XXLChess.board.logic;

import XXLChess.pieces.ChessPiece;

public class Move {
    private int newRow;
    private int newCol;

    private boolean captureMove;
    private ChessPiece movingPiece;
    private boolean check;

    public Move(int newRow, int newCol, ChessPiece movingPiece) {

        this.newRow = newRow;
        this.newCol = newCol;

        this.captureMove = false;
        this.movingPiece = movingPiece;
        this.check = false;
    }

    public Move(int newRow, int newCol, ChessPiece movingPiece, boolean isCaptureMove) {
        this.newRow = newRow;
        this.newCol = newCol;

        this.captureMove = true;
        this.movingPiece = movingPiece;
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

    public ChessPiece getMovingPiece() {
        return movingPiece;
    }

    public void setCheck() {
        this.check = true;
    }

    public boolean isCheck() {
        return this.check;
    }
}
