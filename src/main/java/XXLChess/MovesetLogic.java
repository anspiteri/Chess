package XXLChess;

import XXLChess.enums.PieceTypeObj;

public class MovesetLogic {

    public static void getAvailableMoves(PieceTypeObj pieceType) {
        if (pieceType == PieceTypeObj.PAWN) {
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
