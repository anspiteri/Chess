package XXLChess.enums;

public enum PieceType {
    NONE(' ', " "),
    BISHOP_B('B', "chess-bishop-black.png"),
    BISHOP_W('b', "chess-bishop-white.png"),
    KING_B('K', "chess-king-black.png"),
    KING_W('k', "chess-king-white.png"),
    KNIGHT_B('N', "chess-knight-black.png"),
    KNIGHT_W('n', "chess-knight-white.png"),
    PAWN_B('P', "chess-pawn-black.png"),
    PAWN_W('p', "chess-pawn-white.png"),
    QUEEN_B('Q', "chess-queen-black.png"),
    QUEEN_W('q', "chess-queen-white.png"),
    ROOK_B('R', "chess-rook-black.png"),
    ROOK_W('r', "chess-rook-white.png");
    
    public final char key;
    public final String imageFileName;

    PieceType(char key, String imageFileName) {
        this.key = key;
        this.imageFileName = imageFileName;
    }
}