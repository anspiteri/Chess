package XXLChess;

import XXLChess.enums.PieceType;

public class MovesetLogic {
    //TODO: Fix the rest of these... 
    public static void getAvailableMoves(PieceType pieceType) {
        if (pieceType == PieceType.PAWN_B | pieceType == PieceType.PAWN_W) {
            getPawnMoves();
        } else if (pieceType == PieceTypeObj.ROOK) {
            getRookMoves();
        } else if (pieceType == PieceTypeObj.BISHOP) {
            getBishopMoves();
        } else if (pieceType == PieceTypeObj.KNIGHT) {
            getKnightMoves();
        } else if (pieceType == PieceTypeObj.KING) {
            getKingMoves();
        } else if (pieceType == PieceTypeObj.QUEEN) {
            getQueenMoves();
        } else {
            // return an error. 
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
