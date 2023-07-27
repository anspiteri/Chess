package XXLChess.enums;

public enum PieceTypeObj {
    BISHOP(3),
    KING(5),
    KNIGHT(2),
    PAWN(8),
    QUEEN(4),
    ROOK(0);

    public int startingPosition;

    PieceTypeObj(int startingPosition) {
        this.startingPosition = startingPosition;
    }
}
