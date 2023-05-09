package XXLChess;

import java.util.ArrayList;

import XXLChess.exceptions.PieceCreationException;
import XXLChess.pieces.*;
import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;

public class Pieceset extends DisplayObject {

    private ArrayList<ArrayList<Character>> chessLayout;
    private ChessPiece[][] pieces;

    public Pieceset(PApplet parent, ArrayList<ArrayList<Character>> chessLayout) {
        super(parent);
        this.chessLayout = chessLayout;
        pieces = new ChessPiece[App.BOARD_WIDTH][App.BOARD_WIDTH];
    }

    public void setup() {

        for (int row = 0; row < pieces.length; row++) {
            for (int column = 0; column < pieces.length; column++) {
                char key = chessLayout.get(row).get(column);
                
                try {
                    ChessPiece piece = createPiece(key, column * App.CELLSIZE, row * App.CELLSIZE);
                    if (piece != null) {
                        pieces[row][column] = piece;
                    } else {
                        throw new PieceCreationException("Layout key invalid.");
                    }
                } catch (PieceCreationException e) {
                    System.out.println("Setup error: " + e.getMessage());
                }
            }
        }
    }

    public ChessPiece createPiece(char key, int x, int y) {
        ChessPiece piece;

        switch (key) {
            case 'P':
                piece = new Pawn(parent, PieceColour.BLACK, x, y);
            case 'p':
                piece = new Pawn(parent, PieceColour.WHITE, x, y);
            case 'R':
                piece = new Rook(parent, PieceColour.BLACK, x, y);
            case 'r':
                piece = new Rook(parent, PieceColour.WHITE, x, y);
            case 'N':
                piece = new Knight(parent, PieceColour.BLACK, x, y);
            case 'n':
                piece = new Knight(parent, PieceColour.WHITE, x, y);
            case 'B':
                piece = new Bishop(parent, PieceColour.BLACK, x, y);
            case 'b':
                piece = new Bishop(parent, PieceColour.WHITE, x, y);
            case 'H':
                piece = new Archbishop(parent, PieceColour.BLACK, x, y);
            case 'h':
                piece = new Archbishop(parent, PieceColour.WHITE, x, y);
            case 'C':
                piece = new Camel(parent, PieceColour.BLACK, x, y);
            case 'c':
                piece = new Camel(parent, PieceColour.WHITE, x, y);
            case 'G':
                piece = new General(parent, PieceColour.BLACK, x, y);
            case 'g':
                piece = new General(parent, PieceColour.WHITE, x, y);
            case 'A':
                piece = new Amazon(parent, PieceColour.BLACK, x, y);
            case 'a':
                piece = new Amazon(parent, PieceColour.WHITE, x, y);
            case 'K':
                piece = new King(parent, PieceColour.BLACK, x, y);
            case 'k':
                piece = new King(parent, PieceColour.WHITE, x, y);
            case 'E':
                piece = new Chancellor(parent, PieceColour.BLACK, x, y);
            case 'e':
                piece = new Chancellor(parent, PieceColour.WHITE, x, y);
            case 'Q':
                piece = new Queen(parent, PieceColour.BLACK, x, y);
            case 'q':
                piece = new Queen(parent, PieceColour.WHITE, x, y);
            case ' ':
                
            default:
                piece = null;
        }
        
        return piece;
    }

    public void loadImages() {
        for (ChessPiece[] rows : pieces) {
            for (ChessPiece piece : rows) {
                piece.loadImage(App.PATH);
            }
        }
    }

    public void display() {
        for (ChessPiece[] rows : pieces) {
            for (ChessPiece piece : rows) {
                piece.display();
            }
        }
    }
}
