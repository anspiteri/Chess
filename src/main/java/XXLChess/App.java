package XXLChess;

import XXLChess.LegacyClasses.DisplayObject;
import XXLChess.LegacyClasses.Tile;
import XXLChess.LegacyClasses.players.Player;
import XXLChess.enums.Colour;
import XXLChess.enums.HighlightColour;
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
    
    public static final String PATH = "src/main/resources/XXLChess/";
    public static final String CONFIG = "config.json";
    
    private final int WHITE = color(255, 255, 240);
    private final int BLACK = color(85, 63, 47);
    private final int BLUE = color(0, 0, 255);
    private final int LIGHT_RED = color(255, 153, 153);
    private final int GREEN = color(0, 255, 0);
    private final int YELLOW = color(255, 255, 0);
    private final int DARK_RED = color(153, 0, 0);
    private final float HIGHLIGHT_AMT = 0.5f;

    private int tickCounter = 0;
    private int tickTime = 0;

    private Tiles tiles; 
    private Timer timerTop;
    private Timer timerBottom;
    private Map<PieceType, PImage> loadedImageMap;
    private PlayerState playerWhite;
    private PlayerState playerBlack;


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

        // Initialize board elements, timers & players
        tiles = new Tiles(BOARD_WIDTH * BOARD_WIDTH);

        timerTop = new Timer(config.getCpuColour(), config.getCpuClock(), config.getCpuIncrement());
        timerBottom = new Timer(config.getPlayerColour(), config.getPlayerClock(), config.getPlayerIncrement());
        
        initializePlayers(config);
        
       
        // Load images during setup
        loadedImageMap = loadImages();
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
	
	/*
     *                                              HELPER METHODS
     * -----------------------------------------------------------------------------------------------------
     */

    /**
     * Sets up the players with their respective colours, starting turn, and whether the player is a cpu or human. 
     * @param config - provides colour setting for cpu and human, as well as the play as cpu setting. 
     */
    private void initializePlayers(Config config) {
        playerWhite = new PlayerState(true);
        playerBlack = new PlayerState(false);
        
        if (config.getPlayAsCpu() == true) {
            playerBlack.makeCpuPlayer();
            playerWhite.makeCpuPlayer();
        } else {
            if (config.getPlayerColour() == Colour.BLACK) {
                playerBlack.makeHumanPlayer();
                playerWhite.makeCpuPlayer();
            } else {
                playerBlack.makeCpuPlayer();
                playerWhite.makeHumanPlayer();
            }
        }
    }

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

    // TODO: Work out how to implement tile highlighting into this logic as well as how the colour system works in Processing. 
    private void drawTiles() {
        Colour[] tilesList = tiles.getTileList();
        for (int i = 0; i < tilesList.length; i++) {
            if (tilesList[i] == Colour.WHITE) {
                fill(WHITE);
            } else if (tilesList[i] == Colour.BLACK) {
                fill(BLACK);
            } else {
                highlightTile(tilesList[i]);
            }
            // Want this to be running every draw call. 
            stroke(0);
            strokeWeight(1);
            rect(CoordinateCalculator.getCoordinate(i).xCoord(), CoordinateCalculator.getCoordinate(i).yCoord(), App.CELLSIZE, App.CELLSIZE);
        }
    }

    private void highlightTile(Colour highlightColour) {
        switch (highlightColour) {
            case BLUE:
                fill(lerpColor(colorDict.get(this.colour), BLUE, HIGHLIGHT_AMT));
                break;
            case LIGHT_RED:
                fill(lerpColor(colorDict.get(this.colour), LIGHT_RED, HIGHLIGHT_AMT));
                break;
            case GREEN:
                fill(lerpColor(colorDict.get(this.colour), GREEN, HIGHLIGHT_AMT));
                break;
            case YELLOW:
                fill(lerpColor(colorDict.get(this.colour), YELLOW, HIGHLIGHT_AMT));
                break;
            case DARK_RED:
                fill(lerpColor(colorDict.get(this.colour), DARK_RED, HIGHLIGHT_AMT));
                break;
            default:
                stroke(0);
                break;
        }
    }

    private void drawPieces() {
        // use loaded images here. 
        loadedImageMap.values();
    }

    private void drawUI() {
        //TODO:
        drawTimers();

    }

    private void drawTimers() {
        textSize(UserInterfaceConfig.TIMER_TEXT_SIZE);
        text(timerTop.getTime(), UserInterfaceConfig.TIMER_TOP_XY[0], UserInterfaceConfig.TIMER_TOP_XY[1]);
        text(timerBottom.getTime(), UserInterfaceConfig.TIMER_BOTTOM_XY[0], UserInterfaceConfig.TIMER_BOTTOM_XY[1]);
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
}
