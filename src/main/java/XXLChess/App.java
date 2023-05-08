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

import XXLChess.players.Player;
import netscape.javascript.JSException;

import java.awt.Font;
import java.io.*;
import java.text.ParseException;
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

    private Tileset tiles;
    private Pieceset pieces;
    private Board board;

    private Player playerBlack;
    private Player playerWhite;


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

        tiles = new Tileset(this, BOARD_WIDTH, CELLSIZE);
        pieces = new Pieceset(this, BOARD_WIDTH);
        // add logic to decide whether to instantiate human players or AI players
        board = new Board(this, tiles, pieces, playerBlack, playerWhite);
        
        // Load images during setup
        pieces.loadImages(PATH);
        
		// load config
        try {
            JSONObject conf = loadJSONObject(new File(this.configPath));
        } catch (JSException e) {
            e.printStackTrace();
            System.out.println("Error parsing JSON file.");
        }

        // initialise gameboard
        tiles.setup();
        pieces.setup();
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
        tiles.display();

        
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
