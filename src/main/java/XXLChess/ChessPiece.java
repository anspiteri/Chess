package XXLChess;

import XXLChess.enums.PieceType;
import XXLChess.enums.TeamColour;

public class ChessPiece {
    private final PieceType type; 
    private final TeamColour colour;
    private int position;

    public ChessPiece(PieceType type, TeamColour colour, int position) {
        this.type = type;
        this.colour = colour;
        this.position = position;
    }

    // Setters 

    public void changePosition(int newPosition) {
        position = newPosition;
    }

    // Getters

    public int getPosition(){
        return position;
    }

    public TeamColour getColour() {
        return colour;
    }

    public PieceType getPieceType() {
        return type;
    }
}