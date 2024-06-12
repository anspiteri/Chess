package XXLChess;

import XXLChess.board.ChessBoard;
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
    public static final int HEADER = 300;

    public static final double SCALE_FACTOR_L = 1;
    public static final double SCALE_FACTOR_M = 0.4;
    public static final double SCALE_FACTOR_S = 0.24;
    public static final double SCALE_FACTOR_MICRO = 0.20;

    public static final int FPS = 60;
    
    public static final String PATH = "src/main/resources/XXLChess/";
    public static final String CONFIG = "config.json";

    private double headerSize;
    private double headerOffset; 
    private double sidebarSize;
    private double sidebarOffset;
    private double boardDim;
    private double pieceDim;

    private ChessBoard chessBoard; 

    PImage boardSprite;

    public App() {
    }

    /**
     * Initialise the setting of the window size.
    */
    public void settings() {
        double scaleFactor = SCALE_FACTOR_S;

        boardDim = (BOARD_SPRITE_PX * scaleFactor); 
        pieceDim = (CHESS_SPRITE_PX * scaleFactor);
        
        headerSize = (HEADER * scaleFactor);
        headerOffset = headerSize;
        
        sidebarSize = (SIDEBAR * scaleFactor);
        sidebarOffset = (sidebarSize - (0 * scaleFactor));

        int width = (int) (boardDim + 2*sidebarSize);
        int height = (int) (boardDim + headerOffset);
        
        size(width, height);
    }
    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
    */
    public void setup() {
        frameRate(FPS);
        
        TeamColour playerColour = TeamColour.BLACK;
       
        boardSprite = loadImage("src/main/resources/XXLChess/board.png");        
        chessBoard = new ChessBoard(loadImages(), playerColour);
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

        image(boardSprite, (int) sidebarOffset, (int) headerOffset, (int) boardDim, (int) boardDim);
        drawPieces();
    }
	
	/*
     *                                              HELPER METHODS
     * -----------------------------------------------------------------------------------------------------
     */ 
    
     /**
     * Helper method within App.setup() which loads all chess piece images from file. 
     * @return: returns a HashMap with keys defined in PieceType enumerator, and values
     * as PImage objects. 
     * <p/>
     * e.g. 
     *      PImageMap.get(PieceType.BISHOP_B); 
     * <p/>
     *      // returns the black bishop png, loaded as a PImage.  
     */
    private Map<PieceType, PImage> loadImages() {
        Map<PieceType, PImage> imagesMap = new HashMap<>();

        // Iterate through the enumerator PieceType. 
        // Each PieceType constructs with a fileName attribute which is used in the loadImage method. 
        for (PieceType pieceType : PieceType.values()) {
            if (pieceType != PieceType.NONE) {
                imagesMap.put(pieceType, loadImage(App.PATH + pieceType.imageFileName));
            }
        }
        
        // Validate that images have loaded correctly.
        try {
            for (PieceType imageKey : imagesMap.keySet()) {
            if (imagesMap.get(imageKey) == null) { // if an image is not loaded correctly, the loadImage method returns null. 
                throw new ValidationException("Error loading image: " + imageKey);
            }
        }
        } catch (ValidationException ve) {
            System.err.println(ve.getMessage());
            System.exit(0);
        }

        return imagesMap;
    }

    private void drawPieces() {
        
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }
}
