package XXLChess.players;

import java.util.ArrayList;

import XXLChess.GameObject;
import XXLChess.pieces.ChessPiece;
import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;

public class Player extends GameObject {

    protected PieceColour playerColour;

    protected ArrayList<ChessPiece>[] playerPieces;
    protected ArrayList<ChessPiece>[] capturedPieces;

    protected Player(PApplet parent) {
        super(parent);
        //TODO Auto-generated constructor stub
    }
}
