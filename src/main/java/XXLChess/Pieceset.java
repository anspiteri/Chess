package XXLChess;

import java.util.ArrayList;

import XXLChess.enums.Colour;
import XXLChess.exceptions.PieceCreationException;
import XXLChess.pieces.*;
import processing.core.PApplet;

public class Pieceset extends SetObject {

    private ArrayList<ArrayList<Character>> chessLayout;
    private ChessPiece[][] pieces;

    public Pieceset(PApplet parent, ArrayList<ArrayList<Character>> chessLayout) {
        super(parent);
        this.chessLayout = chessLayout;
        pieces = new ChessPiece[App.BOARD_WIDTH][App.BOARD_WIDTH];
    }

    public void setup(Tileset tiles) {

        for (int row = 0; row < pieces.length; row++) {
            for (int column = 0; column < pieces.length; column++) {
                char key = chessLayout.get(row).get(column);

                try {
                    ChessPiece piece = createPiece(key, column * App.CELLSIZE, row * App.CELLSIZE);
                    if (piece != null) {
                        pieces[row][column] = piece;
                        // Check if the piece is an empty<"T"> or real piece for tile state.
                        if (piece.getKey() != "T") {
                            tiles.getTiles()[row][column].setOccupied(true);
                        }
                    } else {
                        throw new PieceCreationException("Layout key invalid: " + key);
                    }
                } catch (PieceCreationException e) {
                    System.err.println("Piece Creation Error: " + e.getMessage());
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

    public ChessPiece createPiece(char key, int x, int y) {
        ChessPiece piece;

        switch (key) {
            case 'P':
                piece = new Pawn(parent, x, y, Colour.BLACK);
                break;
            case 'p':
                piece = new Pawn(parent, x, y, Colour.WHITE);
                break;
            case 'R':
                piece = new Rook(parent, x, y, Colour.BLACK);
                break;
            case 'r':
                piece = new Rook(parent, x, y, Colour.WHITE);
                break;
            case 'N':
                piece = new Knight(parent, x, y, Colour.BLACK);
                break;
            case 'n':
                piece = new Knight(parent, x, y, Colour.WHITE);
                break;
            case 'B':
                piece = new Bishop(parent, x, y, Colour.BLACK);
                break;
            case 'b':
                piece = new Bishop(parent, x, y, Colour.WHITE);
                break;
            case 'H':
                piece = new Archbishop(parent, x, y, Colour.BLACK);
                break;
            case 'h':
                piece = new Archbishop(parent, x, y, Colour.WHITE);
                break;
            case 'C':
                piece = new Camel(parent, x, y, Colour.BLACK);
                break;
            case 'c':
                piece = new Camel(parent, x, y, Colour.WHITE);
                break;
            case 'G':
                piece = new General(parent, x, y, Colour.BLACK);
                break;
            case 'g':
                piece = new General(parent, x, y, Colour.WHITE);
                break;
            case 'A':
                piece = new Amazon(parent, x, y, Colour.BLACK);
                break;
            case 'a':
                piece = new Amazon(parent, x, y, Colour.WHITE);
                break;
            case 'K':
                piece = new King(parent, x, y, Colour.BLACK);
                break;
            case 'k':
                piece = new King(parent, x, y, Colour.WHITE);
                break;
            case 'E':
                piece = new Chancellor(parent, x, y, Colour.BLACK);
                break;
            case 'e':
                piece = new Chancellor(parent, x, y, Colour.WHITE);
                break;
            case 'Q':
                piece = new Queen(parent, x, y, Colour.BLACK);
                break;
            case 'q':
                piece = new Queen(parent, x, y, Colour.WHITE);
                break;
            case 'T':
                piece = new Empty(parent, x, y, Colour.NULL); // indicates an empty but valid tile
                break;
            default:
                piece = null; // invalid key.
                break;
        }
        return piece;
    }

    public void loadImages() {
        for (ChessPiece[] rows : pieces) {
            for (ChessPiece piece : rows) {
                piece.loadImage();
            }
        }
    }

    public ChessPiece getPiece(int row, int col) {
        return pieces[row][col];
    }

    @Override
    public void display() {
        for (ChessPiece[] rows : pieces) {
            for (ChessPiece piece : rows) {
                piece.display();
            }
        }
    }
}
