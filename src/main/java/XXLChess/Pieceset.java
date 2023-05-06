package XXLChess;

import XXLChess.pieces.ChessPiece;

public class Pieceset {
    private ChessPiece[][] whitePieces;
    private ChessPiece[][] blackPieces;

    public Pieceset(int BOARD_WIDTH) {
        whitePieces = new ChessPiece[BOARD_WIDTH][2];
        blackPieces = new ChessPiece[BOARD_WIDTH][2];
    }

    public void loadImages(String PATH) {

        // FINISH THIS UP NEXT.
        try {
            PImage amazonW = loadImage(PATH + "w-amazon.png");
        } catch (Exception e) {
            // TODO: handle exception
        }

        
        PImage amazonB = loadImage(PATH + "b-amazon.png");
        PImage archbishopW = loadImage(PATH + "w-archbishop.png");
        PImage archbishopB = loadImage(PATH + "b-archbishop.png");
        PImage bishopW = loadImage(PATH + "w-bishop.png");
        PImage bishopB = loadImage(PATH + "b-bishop.png");
        PImage camelW = loadImage(PATH + "b-amazon.png");
        PImage camelB = loadImage(PATH + "b-amazon.png");
        PImage chancellorW = loadImage(PATH + "b-amazon.png");
        PImage chancellorB = loadImage(PATH + "b-amazon.png");
        PImage kingW = loadImage(PATH + "b-amazon.png");
        PImage kingB = loadImage(PATH + "b-amazon.png");
        PImage knightKingW = loadImage(PATH + "b-amazon.png");
        PImage knightKingB = loadImage(PATH + "b-amazon.png");
        PImage pawnW = loadImage(PATH + "b-amazon.png");
        PImage pawnB = loadImage(PATH + "b-amazon.png");
        PImage queenW = loadImage(PATH + "b-amazon.png");
        PImage queenB = loadImage(PATH + "b-amazon.png");
        PImage rookW = loadImage(PATH + "b-amazon.png");
        PImage rookB = loadImage(PATH + "b-amazon.png");
    }

    public void setup() {

    }

    public void display() {

    }
}
