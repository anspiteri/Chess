package XXLChess;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

import XXLChess.enums.PieceType;

public class BoardInitializationTest {

    @Test
    void BoardPositionsWhiteAtTop() {
        // Generate a map of the correct board positions when white is at the top of the board.
        Map<Integer, PieceType> whiteTopMap = new HashMap<>();
        Map<Integer, PieceType> correctBoardPositions = Collections.unmodifiableMap(generatePositionsWhite(whiteTopMap));

        // Initialize the board pieces to be tested. 
        BoardPieces testBoardPieces = new BoardPieces(true);

        // Test positions 0 -> 15:
        testEachPosition(0, 15, testBoardPieces, correctBoardPositions);

        // Test positions 48 -> 63:
        testEachPosition(48, 63, testBoardPieces, correctBoardPositions);
    }

    private Map<Integer, PieceType> generatePositionsWhite(Map<Integer, PieceType> map) {
        map.put(0, PieceType.ROOK_W);
        map.put(1, PieceType.KNIGHT_W);
        map.put(2, PieceType.BISHOP_W);
        map.put(3, PieceType.QUEEN_W);
        map.put(4, PieceType.KING_W);
        map.put(5, PieceType.BISHOP_W);
        map.put(6, PieceType.KNIGHT_W);
        map.put(7, PieceType.ROOK_W);

        map.put(8, PieceType.PAWN_W);
        map.put(9, PieceType.PAWN_W);
        map.put(10, PieceType.PAWN_W);
        map.put(11, PieceType.PAWN_W);
        map.put(12, PieceType.PAWN_W);
        map.put(13, PieceType.PAWN_W);
        map.put(14, PieceType.PAWN_W);
        map.put(15, PieceType.PAWN_W);

        map.put(48, PieceType.PAWN_B);
        map.put(49, PieceType.PAWN_B);
        map.put(50, PieceType.PAWN_B);
        map.put(51, PieceType.PAWN_B);
        map.put(52, PieceType.PAWN_B);
        map.put(53, PieceType.PAWN_B);
        map.put(54, PieceType.PAWN_B);
        map.put(55, PieceType.PAWN_B);

        map.put(56, PieceType.ROOK_B);
        map.put(57, PieceType.KNIGHT_B);
        map.put(58, PieceType.BISHOP_B);
        map.put(59, PieceType.QUEEN_B);
        map.put(60, PieceType.KING_B);
        map.put(61, PieceType.BISHOP_B);
        map.put(62, PieceType.KNIGHT_B);
        map.put(63, PieceType.ROOK_B);

        return map;
    }

    @Test
    void BoardPositionsBlackAtTop() {
        // Generate a map of the correct board positions when black is at the top of the board.
        Map<Integer, PieceType> blackMap = new HashMap<>();
        Map<Integer, PieceType> correctBoardPositions = Collections.unmodifiableMap(generatePositionsBlack(blackMap));

        // Initialize the board pieces to be tested. 
        BoardPieces testBoardPieces = new BoardPieces(false);

        // Test positions 0 -> 15:
        testEachPosition(0, 15, testBoardPieces, correctBoardPositions);

        // Test positions 48 -> 63:
        testEachPosition(48, 63, testBoardPieces, correctBoardPositions);
    }

    private Map<Integer, PieceType> generatePositionsBlack(Map<Integer, PieceType> map) {
        map.put(0, PieceType.ROOK_B);
        map.put(1, PieceType.KNIGHT_B);
        map.put(2, PieceType.BISHOP_B);
        map.put(3, PieceType.QUEEN_B);
        map.put(4, PieceType.KING_B);
        map.put(5, PieceType.BISHOP_B);
        map.put(6, PieceType.KNIGHT_B);
        map.put(7, PieceType.ROOK_B);

        map.put(8, PieceType.PAWN_B);
        map.put(9, PieceType.PAWN_B);
        map.put(10, PieceType.PAWN_B);
        map.put(11, PieceType.PAWN_B);
        map.put(12, PieceType.PAWN_B);
        map.put(13, PieceType.PAWN_B);
        map.put(14, PieceType.PAWN_B);
        map.put(15, PieceType.PAWN_B);

        map.put(48, PieceType.PAWN_W);
        map.put(49, PieceType.PAWN_W);
        map.put(50, PieceType.PAWN_W);
        map.put(51, PieceType.PAWN_W);
        map.put(52, PieceType.PAWN_W);
        map.put(53, PieceType.PAWN_W);
        map.put(54, PieceType.PAWN_W);
        map.put(55, PieceType.PAWN_W);

        map.put(56, PieceType.ROOK_W);
        map.put(57, PieceType.KNIGHT_W);
        map.put(58, PieceType.BISHOP_W);
        map.put(59, PieceType.QUEEN_W);
        map.put(60, PieceType.KING_W);
        map.put(61, PieceType.BISHOP_W);
        map.put(62, PieceType.KNIGHT_W);
        map.put(63, PieceType.ROOK_W);

        return map;
    }

    private void testEachPosition(int start, int end, BoardPieces testBoard, Map<Integer, PieceType> correctPositions) {
        for (int i = start; i <= end; i++) {
            Chesspiece testPiece = testBoard.getChesspiece(i);
            assertEquals(correctPositions.get(i), testPiece.getPieceType());
        }
    }
}
