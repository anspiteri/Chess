package XXLChess;

import XXLChess.enums.PieceType;
import XXLChess.exceptions.ValidationException;

import java.util.HashMap;
import java.util.Map;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

public class App extends PApplet {

    public static final int SPRITESIZE = 480;
    public static final int CELLSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 8;

    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE;

    public static final int FPS = 60;
    private int tickCounter = 0;
    private int tickTime = 0;

    public static final String PATH = "src/main/resources/XXLChess/";
    public static final String CONFIG = "config.json";

    private Map<PieceType, PImage> loadedImageMap;

    public App() {
    }

    /**
     * Initialise the setting of the window size.
    */
    public void settings() {
        size(WIDTH, HEIGHT);
    }
    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
    */
    public void setup() {
        frameRate(FPS);
        
        Config config = new Config();
        config.parseFile(App.CONFIG);
       
        // Load images during setup
        loadedImageMap = loadImages();

        // Starting turn. 
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
        tickCounter++;

        if (tickCounter == 60) {
            tickTime++;
            tick();
            tickCounter = 0;
            
            if (tickTime == 5) {
                tickTime = 0;
            }
        }

        background(128, 128, 128);

        drawTiles();
        drawPieces();
        drawUI();
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.

    /**
     * Helper method within App.setup() which loads all chess piece images from file. 
     * @return: returns a HashMap with keys defined in PieceType enumerator, and values
     * as PImage objects. 
     * <p/>
     * e.g. 
     *      imageHashMap.get(PieceType.BISHOP_B); 
     * <p/>
     *      // returns the black bishop png, loaded as a PImage.  
     */
    private Map<PieceType, PImage> loadImages() {
        Map<PieceType, PImage> imagesMap = new HashMap<>();

        // Iterate through the enumerator PieceType. 
        // Each PieceType constructs with a fileName attribute which is used in the loadImage method. 
        for (PieceType pieceType : PieceType.values()) {
            imagesMap.put(pieceType, loadImage(App.PATH + pieceType.imageFileName));
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

    private void drawTiles() {
        //TODO:
    }

    private void drawPieces() {
        // use loaded images here. 
        loadedImageMap.values();
    }

    private void drawUI() {
        //TODO:
    }

    /**
     * tick():
     * Updates every second (60 frames)
     */
    private void tick() {
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

    public DisplayObject getHumanPlayer() {
        return null;
    }

}
