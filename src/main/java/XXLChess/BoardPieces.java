package XXLChess;

import java.util.HashMap;
import java.util.Map;

import XXLChess.enums.Colour;
import XXLChess.enums.PieceTypeObj;

public class BoardPieces {
    private Map<Integer, Chesspiece> boardChesspieces;

    public BoardPieces(boolean whiteIsTop) {
        boardChesspieces = new HashMap<>(32);
        
        //TODO: Instantiate all pieces.
        instantiateWhitePieces(whiteIsTop);
        instantiateBlackPieces(whiteIsTop);
    }

    private void instantiateWhitePieces(boolean whiteIsTop) {        
        for (PieceTypeObj pieceType : PieceTypeObj.values()) {
            Chesspiece nextChesspiece = new Chesspiece(pieceType.startingPosition, Colour.WHITE, pieceType);
            if (whiteIsTop == false) {
                nextChesspiece.getPositionalIndex();
            }
            
            boardChesspieces.put(nextChesspiece.getPositionalIndex(), nextChesspiece);
        }
    }

    private void instantiateBlackPieces(boolean whiteIsTop) {

    }

    public Chesspiece getChesspiece(int positionalIndex) {
        return boardChesspieces.get(positionalIndex);
    }
}
