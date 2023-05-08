package XXLChess;

import XXLChess.pieces.ChessPiece;
import processing.core.PApplet;
import processing.core.PImage;

public class Pieceset extends DisplayObject {
    
    private ChessPiece[][] pieces;

    public Pieceset(PApplet parent, int BOARD_LENGTH) {
        super(parent);
    
        pieces = new ChessPiece[BOARD_LENGTH][BOARD_LENGTH];
    }

    public void loadImages(String PATH) {

        try {
            PImage amazonW = parent.loadImage(PATH + "w-amazon.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage amazonB = parent.loadImage(PATH + "b-amazon.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage archbishopW = parent.loadImage(PATH + "w-archbishop.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage archbishopB = parent.loadImage(PATH + "b-archbishop.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage bishopW = parent.loadImage(PATH + "w-bishop.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage bishopB = parent.loadImage(PATH + "b-bishop.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage camelW = parent.loadImage(PATH + "w-camel.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage camelB = parent.loadImage(PATH + "b-camel.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage chancellorW = parent.loadImage(PATH + "w-chancellor.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage chancellorB = parent.loadImage(PATH + "b-chancellor.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage kingW = parent.loadImage(PATH + "w-king.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage kingB = parent.loadImage(PATH + "b-king.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage knightKingW = parent.loadImage(PATH + "w-knight-king.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage knightKingB = parent.loadImage(PATH + "b-knight-king.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage knightW = parent.loadImage(PATH + "w-knight.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage knightB = parent.loadImage(PATH + "b-knight.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage pawnW = parent.loadImage(PATH + "w-pawn.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage pawnB = parent.loadImage(PATH + "b-pawn.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage queenW = parent.loadImage(PATH + "w-queen.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage queenB = parent.loadImage(PATH + "b-queen.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage rookW = parent.loadImage(PATH + "w-rook.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            PImage rookB = parent.loadImage(PATH + "b-rook.png");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    public void setup() {
        // Set up board.
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces.length; j++) {

            }
        }
    }

    public void display() {

    }
}
