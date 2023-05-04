package XXLChess.board.enums;

/*
 *  Blue – the player clicked on a piece, and it is able to move to this square.
 *  Light red – the currently selected piece can move to this square, capturing the current piece there
 *  Green – the player’s currently selected piece
 *  Yellow – the last piece to move, and the square it came from
 *  Dark red – the king on this square is currently in check, or checkmate has occurred (pieces that
 *  contribute to the checkmate are highlighted in light red)
 */
public enum HighlightColour {
    BLUE, LIGHT_RED, GREEN, YELLOW, DARK_RED
}
