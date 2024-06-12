package XXLChess.board;

import XXLChess.enums.PieceType;
import XXLChess.enums.TeamColour;
import processing.core.PImage;

public class ChessPiece {
    private final PieceType type; 
    private final TeamColour colour;
    private int position;
    private int x, y;
    private final PImage pImage;

    public ChessPiece(PieceType type, TeamColour colour, int position, int x, int y, PImage pImage) {
        this.type = type;
        this.colour = colour;
        this.position = position;
        this.x = x;
        this.y = y;
        this.pImage = pImage;
    }

    // Setters 

    public void changePosition(int newPosition, int newX, int newY) {
        position = newPosition;
        x = newX;
        y = newY;
    }

    public void changeCoordinates(int newX, int newY) {
        x = newX;
        y = newY;
    }

    // Getters

    public int getPosition(){
        return position;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getXY() {
        int[] xy = {x, y};
        return xy;
    }

    public TeamColour getColour() {
        return colour;
    }

    public PieceType getPieceType() {
        return type;
    }

    public PImage getPImage() {
        return pImage;
    }
}