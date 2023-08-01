package XXLChess;

import XXLChess.enums.Colour;
import XXLChess.enums.PieceType;

public class Chesspiece {
    private int positionalIndex;
    // private final Colour teamColour; This may be redundant. 
    private final PieceType pieceType; 

    public Chesspiece(int positionalIndex) {
        this.positionalIndex = positionalIndex;
        //this.teamColour = Colour.NULL;
        this.pieceType = PieceType.NONE;
    }

    public Chesspiece(int positionalIndex, PieceType pieceType) {
        this.positionalIndex = positionalIndex;
        this.pieceType = pieceType;
    }

    public Chesspiece(int positionalIndex, Colour teamColour, PieceType pieceType) {
        this.positionalIndex = positionalIndex;
        //this.teamColour = teamColour;
        this.pieceType = pieceType;
    }

    public void setPositionalIndex(int newIndex) {
        positionalIndex = newIndex;
    }

    public int getPositionalIndex(){
        return positionalIndex;
    }

    //public Colour getTeamColour() {
        //return teamColour;
    //}

    public PieceType getPieceType() {
        return pieceType;
    }
}