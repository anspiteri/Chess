package XXLChess;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class App extends PApplet {

    public static final int SPRITESIZE = 480;
    public static final int CELLSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 14;

    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE;

    public static final int FPS = 60;
    private int tickCounter = 0;
    private int tickTime = 0;

    public static final String PATH = "src/main/resources/XXLChess/";
    public String configPath;

    public App() {
        this.configPath = "config.json";
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
        config.parseFile(configPath);
       
        // Load images during setup
        loadImages();

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

    private void loadImages() {
        //TODO:
    }

    private void drawTiles() {
        //TODO:
    }

    private void drawPieces() {
        //TODO:
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
