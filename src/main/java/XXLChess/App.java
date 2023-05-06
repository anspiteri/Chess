package XXLChess;

//import org.reflections.Reflections;
//import org.reflections.scanners.Scanners;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;
import processing.data.JSONArray;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.event.MouseEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import java.awt.Font;
import java.io.*;
import java.util.*;

public class App extends PApplet {

    public static final int SPRITESIZE = 480;
    public static final int CELLSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 14;

    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE;

    public static final int FPS = 60;

    public static final String PATH = "src/main/resources/XXLChess/";
	
    public String configPath;

    private Tileset tileset;
    private Pieceset pieceset;


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

        tileset = new Tileset(this, BOARD_WIDTH);
        pieceset = new Pieceset(this, BOARD_WIDTH);
        
        // Load images during setup
        pieceset.loadImages(PATH);
        
		// load config
        JSONObject conf = loadJSONObject(new File(this.configPath));

        // initialise gameboard
        tileset.setup(CELLSIZE);
    }

    /**
     * Receive key pressed signal from the keyboard.
    */
    public void keyPressed(){


    }
    
    /**
     * Receive key released signal from the keyboard.
    */
    public void keyReleased(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    /**
     * Draw all elements in the game by current frame. 
    */
    public void draw() {

        // Display chess board tiles as well as highlighted colours. 
        tileset.display(CELLSIZE);

        
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
