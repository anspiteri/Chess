package XXLChess;

import XXLChess.enums.Colour;
import XXLChess.enums.PieceTypeObj;

public class Chesspiece {
    private int positionalIndex;
    private final Colour teamColour;
    private final PieceTypeObj pieceType; 

    public Chesspiece(int positionalIndex, Colour teamColour, PieceTypeObj pieceType) {
        this.positionalIndex = positionalIndex;
        this.teamColour = teamColour;
        this.pieceType = pieceType;
    }

    public void setPositionalIndex(int newIndex) {
        positionalIndex = newIndex;
    }

    public int getPositionalIndex(){
        return positionalIndex;
    }

    public Colour getTeamColour() {
        return teamColour;
    }

    public PieceTypeObj getPieceType() {
        return pieceType;
    }
}