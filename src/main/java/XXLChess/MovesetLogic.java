package XXLChess;

import XXLChess.enums.PieceType;
import XXLChess.exceptions.MoveCalculationException;

public class MovesetLogic {

    private static final String ERROR_MSG = 
        "NONE piecetype recieved... Chesspiece may not be initialized properly."
    ;

    /**
     * 
     * @param pieceType Must be a valid pieceType from the PieceType enum, i.e. not 'PieceType.NONE'.
     * @throws MoveCalculationException
     */
    public static void getAvailableMoves(PieceType pieceType) throws MoveCalculationException {
        if (pieceType == PieceType.PAWN_B | pieceType == PieceType.PAWN_W) {
            getPawnMoves();
        } else if (pieceType == PieceType.ROOK_B | pieceType == PieceType.ROOK_W) {
            getRookMoves();
        } else if (pieceType == PieceType.BISHOP_B | pieceType == PieceType.BISHOP_W) {
            getBishopMoves();
        } else if (pieceType == PieceType.KNIGHT_B | pieceType == PieceType.KNIGHT_W) {
            getKnightMoves();
        } else if (pieceType == PieceType.KING_B | pieceType == PieceType.KING_W) {
            getKingMoves();
        } else if (pieceType == PieceType.QUEEN_B | pieceType == PieceType.QUEEN_W) {
            getQueenMoves();
        } else {
            throw new MoveCalculationException(ERROR_MSG);
        }
    }
    private static void getPawnMoves() {
        
    }

    private static void getRookMoves() {

    }

    private static void getBishopMoves() {

    }

    private static void getKnightMoves() {

    }

    private static void getKingMoves() {

    }

    private static void getQueenMoves() {

    }
}
