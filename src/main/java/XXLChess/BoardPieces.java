package XXLChess;

import java.util.HashMap;
import java.util.Map;

import XXLChess.enums.Colour;
import XXLChess.enums.PieceType;

public class BoardPieces {
    private Map<Integer, Chesspiece> boardChesspieces;

    public BoardPieces(boolean whiteIsTop) {
        boardChesspieces = new HashMap<>(32);
        
        //TODO: Instantiate all pieces.
        instantiateTeamPieces(Colour.BLACK, whiteIsTop);
        instantiateTeamPieces(Colour.WHITE, whiteIsTop);
    }

    private void instantiateTeamPieces(Colour team, boolean whiteIsTop) {        
        for (PieceType pieceType : PieceType.values()) {
            // 1: Create an instance of a new chess piece. 
            Chesspiece nextChesspiece = new Chesspiece(pieceType.startingPosition, team, pieceType);
            
            // 2: Determine the starting position of the piece. 
            if (whiteIsTop == false) {
                nextChesspiece.getPositionalIndex();
            }
            
            // 3: Add the piece's index and the object itself to the map. 
            boardChesspieces.put(nextChesspiece.getPositionalIndex(), nextChesspiece);
        }
    }

    public Chesspiece getChesspiece(int positionalIndex) {
        return boardChesspieces.get(positionalIndex);
    }
}
