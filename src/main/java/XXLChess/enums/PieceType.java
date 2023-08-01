package XXLChess.enums;

public enum PieceType {
    NONE(' ', " "),
    BISHOP_B('B', "b-bishop.png"),
    BISHOP_W('b', "w-bishop.png"),
    KING_B('K', "b-king.png"),
    KING_W('k', "w-king.png"),
    KNIGHT_B('N', "b-knight.png"),
    KNIGHT_W('n', "w-knight.png"),
    PAWN_B('P', "b-pawn.png"),
    PAWN_W('p', "w-pawn.png"),
    QUEEN_B('Q', "b-queen.png"),
    QUEEN_W('q', "w-queen.png"),
    ROOK_B('R', "b-rook.png"),
    ROOK_W('r', "w-rook.png");
    
    public final char key;
    public final String imageFileName;

    PieceType(char key, String imageFileName) {
        this.key = key;
        this.imageFileName = imageFileName;
    }
}