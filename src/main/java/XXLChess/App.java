package XXLChess;

import XXLChess.board.ChessBoard;
import XXLChess.board.ChessPiece;
import XXLChess.enums.PieceType;
import XXLChess.enums.TeamColour;
import XXLChess.exceptions.ValidationException;

import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

public class App extends PApplet {

    public static final int CHESS_SPRITE_PX = 500;
    public static final int BOARD_SPRITE_PX = 2050;
    
    public static final int SIDEBAR = 1000;
    public static final int HEADER = 500;

    public static final double SCALE_FACTOR_L = 1;
    public static final double SCALE_FACTOR_M = 0.4;
    public static final double SCALE_FACTOR_S = 0.24;
    public static final double SCALE_FACTOR_MICRO = 0.20;

    public static final int FPS = 60;

    private ChessBoard chessBoard; 

    private PImage boardSprite;
    private Map<PieceType, PImage> chessSprites;

    private int[][] coordinateData;

    private double headerSize, headerOffset; 
    private double sidebarSize, sidebarOffset;
    private double boardDim, pieceDim;
    private double spriteOffsetHorTop, spriteOffsetVerTop;
    private double spriteOffsetHorBottom, spriteOffsetVerBottom;
    private int width, height;

    public App() {
    }

    /**
     * Initialise the setting of the window size.
    */
    public void settings() {
        double scaleFactor = SCALE_FACTOR_S;

        boardDim = (BOARD_SPRITE_PX * scaleFactor); 
        pieceDim = (CHESS_SPRITE_PX * (scaleFactor - 0.01));
        
        headerSize = (HEADER * scaleFactor);
        headerOffset = headerSize;
        
        sidebarSize = (SIDEBAR * scaleFactor);
        sidebarOffset = (sidebarSize - (0 * scaleFactor));

        spriteOffsetHorTop = pieceDim / 4.8;
        spriteOffsetVerTop = pieceDim / 2.5;

        spriteOffsetHorBottom = pieceDim / 4;
        spriteOffsetVerBottom = pieceDim / 2.2;

        width = (int) (boardDim + 2*sidebarSize);
        height = (int) (boardDim + headerOffset);
        
        size(width, height);
        //surface.setResizable(true);
    }
    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
    */
    public void setup() {
        final String path = "src/main/resources/XXLChess/";

        frameRate(FPS);

        coordinateData = initCoordinateArray();
        
        TeamColour playerColour = TeamColour.WHITE;
        if (playerColour != TeamColour.NULL) {
            chessBoard = new ChessBoard(playerColour);
        } else {
            System.err.println("Player colour not properly set.");
            System.exit(0);
        }
       
        boardSprite = loadBoardImage(path);   
        chessSprites = loadImages(path);
    }

    /**
     * Receive key pressed signal from the keyboard.
    */
    public void keyPressed(){
        if (keyCode == ESC) {
            System.exit(0);
        }

    }
    
    /**
     * Receive key released signal from the keyboard.
    */
    public void keyReleased(){

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    /**
     * Draw all elements in the game by current frame. 
    */
    public void draw() {

        background(128, 128, 128);

        drawBoard();
        drawPieces();
    }

    private int[][] initCoordinateArray() {
        int[][] array = new int[64][2];
        
        for (int i = 0; i < 64; i++) {
            double x, y, offsetH, offsetV;
            if (i < 32) {
                offsetH = spriteOffsetHorTop;
                offsetV = spriteOffsetVerTop;
            } else {
                offsetH = spriteOffsetHorBottom;
                offsetV = spriteOffsetVerBottom;
            }
            x = (sidebarOffset - offsetH) + ((i%8) * (boardDim/8));
            y = (headerOffset - offsetV) + ((i/8) * (boardDim/8));
            array[i][0] = (int) x;
            array[i][1] = (int) y; 
        }
        return array;
    }
    
    private PImage loadBoardImage(String path) {
        PImage boardSprite = loadImage(path + "board.png");
        try {
            if (boardSprite == null) {
                throw new ValidationException("Error loading board sprite.");
            }
        } catch (Exception ve) {
            System.err.println(ve.getMessage());
            System.exit(0);
        }
        return boardSprite;
    }
    
    /**
     * Loads all chess piece images from file. 
     * @return: returns a HashMap with keys defined in PieceType enumerator, and values
     * as PImage objects. 
     * <p/>
     * e.g. 
     *      PImageMap.get(PieceType.BISHOP_B); 
     * <p/>
     *      // returns the black bishop png, loaded as a PImage.  
     */
    private Map<PieceType, PImage> loadImages(String path) {
        Map<PieceType, PImage> imagesMap = new HashMap<>();

        for (PieceType pieceType : PieceType.values()) {
            if (pieceType != PieceType.NONE) {
                imagesMap.put(pieceType, loadImage(path + pieceType.imageFileName));
            }
        }
        
        // Validate that images have loaded correctly.
        try {
            for (PieceType imageKey : imagesMap.keySet()) {
            if (imagesMap.get(imageKey) == null) {
                throw new ValidationException("Error loading image: " + imageKey);
            }
        }
        } catch (ValidationException ve) {
            System.err.println(ve.getMessage());
            System.exit(0);
        }

        return imagesMap;
    }

    private void drawBoard() {
        image(boardSprite, (int) sidebarOffset, (int) headerOffset, (int) boardDim, (int) boardDim);
    }
    
    private void drawPieces() {
        for (int i = 0; i < 64; i++) {
            ChessPiece piece = chessBoard.getChessPiece(i);
            if (piece != null) {
                int j = piece.getPosition();
                int x = coordinateData[j][0];
                int y = coordinateData[j][1];
                PImage img = chessSprites.get(piece.getPieceType());

                image(img, x, y, (int) pieceDim, (int) pieceDim);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }
}
