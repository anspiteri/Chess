package XXLChess.board;

import java.util.HashMap;
import java.util.Map;

import XXLChess.config.StartingPositions;
import XXLChess.enums.PieceType;

public class Pieces {
    private Map<Integer, ChessPiece> boardChesspieces;

    public Pieces(boolean whiteIsTop) {
        Map<Character, int[]> startingPositions;

        // Instantiate pieces. 
        boardChesspieces = new HashMap<>(32);
        
        if (whiteIsTop) {
            startingPositions = StartingPositions.startingPositionsWhite;
        } else {
            startingPositions = StartingPositions.startingPositionsBlack;
        }

        // For each piece get the starting positions on the board. 
        for (PieceType pieceType : PieceType.values()) {
            if (pieceType != PieceType.NONE) {
                int[] piecePositions = startingPositions.get(pieceType.key);

                // For each individual position create a new chess piece and add it 
                // to the map of chess pieces. 
                for (int positionalIndex : piecePositions) {
                    boardChesspieces.put(positionalIndex, new ChessPiece(positionalIndex, pieceType));
                }
            }
        }
    }

    public ChessPiece getChesspiece(int positionalIndex) {
        return boardChesspieces.get(positionalIndex);
    }
}
