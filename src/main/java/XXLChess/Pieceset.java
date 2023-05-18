package XXLChess;

import java.util.ArrayList;

import XXLChess.enums.Colour;
import XXLChess.exceptions.PieceCreationException;
import XXLChess.pieces.*;
import processing.core.PApplet;

public class Pieceset extends SetObject {

    private ArrayList<ArrayList<Character>> chessLayout;
    private ChessPiece[][] pieces;
    private ChessPiece selectedPiece;

    public Pieceset(PApplet parent, ArrayList<ArrayList<Character>> chessLayout) {
        super(parent);
        this.chessLayout = chessLayout;
        pieces = new ChessPiece[App.BOARD_WIDTH][App.BOARD_WIDTH];
        selectedPiece = null;
    }

    public void capturePiece(ChessPiece capturingPiece, int row, int col) {
        // Store location information from capturing piece.  
        int oldRow = capturingPiece.getRow(), oldCol = capturingPiece.getCol();
        int oldX = capturingPiece.getX(), oldY = capturingPiece.getY();

        // Move capturing piece and replace the captured piece
        int newX = pieces[row][col].getX(), newY = pieces[row][col].getY();
        capturingPiece.setX(newX);
        capturingPiece.setY(newY);
        pieces[row][col] = capturingPiece;

        // Generate an empty piece for the old location. 
        pieces[oldRow][oldCol] = new Empty(parent, oldX, oldY, null, oldRow, oldCol);
    }

    public void movePiece(ChessPiece movingPiece, int row, int col) {
        // Store location information from moving piece.  
        int oldRow = movingPiece.getRow(), oldCol = movingPiece.getCol();
        int oldX = movingPiece.getX(), oldY = movingPiece.getY();

        // Move capturing piece and replace the captured piece
        int newX = pieces[row][col].getX(), newY = pieces[row][col].getY();
        movingPiece.setX(newX);
        movingPiece.setY(newY);
        pieces[row][col] = movingPiece;

        // Generate an empty piece for the old location. 
        pieces[oldRow][oldCol] = new Empty(parent, oldX, oldY, null, oldRow, oldCol);
    }

    public void selectPiece(ChessPiece piece) {
        selectedPiece = piece;
    }

    public void deselectPiece() {
        selectedPiece = null;
    }

    public ChessPiece getSelectedPiece() {
        return selectedPiece;
    }

    public void setup(Tileset tiles) {

        for (int row = 0; row < pieces.length; row++) {
            for (int column = 0; column < pieces.length; column++) {
                char key = chessLayout.get(row).get(column);

                try {
                    ChessPiece piece = createPiece(key, column * App.CELLSIZE, row * App.CELLSIZE, row, column);
                    if (piece != null) {
                        pieces[row][column] = piece;
                        // Check if the piece is an empty<"T"> or real piece for tile state.
                        if (piece.getKey() != "T") {
                            tiles.getTile(row, column).setOccupied(true);
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

    public ChessPiece createPiece(char key, int x, int y, int row, int col) {
        ChessPiece piece;

        switch (key) {
            case 'P':
                piece = new Pawn(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'p':
                piece = new Pawn(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'R':
                piece = new Rook(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'r':
                piece = new Rook(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'N':
                piece = new Knight(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'n':
                piece = new Knight(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'B':
                piece = new Bishop(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'b':
                piece = new Bishop(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'H':
                piece = new Archbishop(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'h':
                piece = new Archbishop(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'C':
                piece = new Camel(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'c':
                piece = new Camel(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'G':
                piece = new General(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'g':
                piece = new General(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'A':
                piece = new Amazon(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'a':
                piece = new Amazon(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'K':
                piece = new King(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'k':
                piece = new King(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'E':
                piece = new Chancellor(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'e':
                piece = new Chancellor(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'Q':
                piece = new Queen(parent, x, y, Colour.BLACK, row, col);
                break;
            case 'q':
                piece = new Queen(parent, x, y, Colour.WHITE, row, col);
                break;
            case 'T':
                piece = new Empty(parent, x, y, Colour.NULL, row, col); // indicates an empty but valid tile
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
