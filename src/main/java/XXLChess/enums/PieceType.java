package XXLChess.enums;

public enum PieceType {
    NONE(' ', " ", TeamColour.NULL), 
    BISHOP_B('B', "chess-bishop-black.png", TeamColour.BLACK), 
    BISHOP_W('b', "chess-bishop-white.png", TeamColour.WHITE), 
    KING_B('K', "chess-king-black.png", TeamColour.BLACK),
    KING_W('k', "chess-king-white.png", TeamColour.WHITE), 
    KNIGHT_B('N', "chess-knight-black.png", TeamColour.BLACK), 
    KNIGHT_W('n', "chess-knight-white.png", TeamColour.WHITE), 
    PAWN_B('P', "chess-pawn-black.png", TeamColour.BLACK), 
    PAWN_W('p', "chess-pawn-white.png", TeamColour.WHITE), 
    QUEEN_B('Q', "chess-queen-black.png", TeamColour.BLACK),
    QUEEN_W('q', "chess-queen-white.png", TeamColour.WHITE), 
    ROOK_B('R', "chess-rook-black.png", TeamColour.BLACK), 
    ROOK_W('r', "chess-rook-white.png", TeamColour.WHITE);
    
    public final char key;
    public final String imageFileName;
    public final TeamColour colour;

    PieceType(char key, String imageFileName, TeamColour colour) {
        this.key = key;
        this.imageFileName = imageFileName;
        this.colour = colour;
    }
}