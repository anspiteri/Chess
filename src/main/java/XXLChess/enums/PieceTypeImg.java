package XXLChess.enums;

public enum PieceTypeImg {
    BISHOP_B("b-bishop.png"),
    BISHOP_W("w-bishop.png"),
    KING_B("b-king.png"),
    KING_W("w-king.png"),
    KNIGHT_B("b-knight.png"),
    KNIGHT_W("w-knight.png"),
    PAWN_B("b-pawn.png"),
    PAWN_W("w-pawn.png"),
    QUEEN_B("b-queen.png"),
    QUEEN_W("w-queen.png"),
    ROOK_B("b-rook.png"),
    ROOK_W("w-rook.png");
    
    public final String imageFileName;

    PieceTypeImg(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}