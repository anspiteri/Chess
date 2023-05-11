package XXLChess;

//import org.reflections.Reflections;
//import org.reflections.scanners.Scanners;
import processing.core.PApplet;
//import processing.core.PImage;
import processing.data.JSONObject;
//import processing.data.JSONArray;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.event.MouseEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import XXLChess.exceptions.DimensionException;
import XXLChess.players.Player;

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

    public static final boolean DEBUG = false;

    public static final String PATH = "src/main/resources/XXLChess/";
    public String configPath;
    public JSONObject conf;

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

        // load config
        ArrayList<ArrayList<Character>> chessLayoutBuffer = null;
        JSONObject timeControls = null;
        String playerColour = null;
        Double pieceMovementSpeed = 0.0, maxMovementTime = 0.0;

        try {
            conf = loadJSONObject(new File(this.configPath));
            
            String layoutFileString = conf.getString("layout");
            chessLayoutBuffer = parseLayout(layoutFileString);

            timeControls = conf.getJSONObject("time_controls");
            playerColour = conf.getString("player_colour");
            pieceMovementSpeed = conf.getDouble("piece_movement_speed");
            maxMovementTime = conf.getDouble("max_movement_time");

        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("Error parsing JSON file.");
            System.exit(1);
        }


        // Instantiate board components
        tiles = new Tileset(this);
        pieces = new Pieceset(this, chessLayoutBuffer);
        // add logic to decide whether to instantiate human players or AI players
        board = new Board(this, tiles, pieces, playerBlack, playerWhite);
        
        // initialise gameboard
        tiles.setup();
        pieces.setup();
        //board.setup();

        // Load images during setup
        pieces.loadImages();

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
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    /**
     * Draw all elements in the game by current frame. 
    */
    public void draw() {

        // Display chess board tiles, pieces, timers, messages
        tiles.display();
        pieces.display();
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.

    /**
     * parseLayout:
     * 
     * @param layoutFileString
     * @return ArrayList<ArrayList<Character>> chessLayout buffer of chess layout presented in level layout. 
     */
    public ArrayList<ArrayList<Character>> parseLayout(String layoutFileString) {
        Scanner sc = null;
        ArrayList<ArrayList<Character>> chessLayout = new ArrayList<ArrayList<Character>>();
        
        // Parse the layout file into the buffer. 
        try {
            sc = new Scanner(new File(layoutFileString));

            while (sc.hasNextLine()) {
                ArrayList<Character> rowList = new ArrayList<>();
                String line = sc.nextLine();
                
                if (line.length() > 1) {
                    // If the line has chess positions: store keys into char array. 
                    for (char c : line.toCharArray()) {
                        if (c != '\n') {
                            rowList.add(c);
                        }
                    }
                } else {
                    // If it is an empty line: Create a char array with appropriate length.
                    for (int i = 0; i < BOARD_WIDTH; i++) {
                        rowList.add('T');
                    }
                }

                if (rowList.size() < BOARD_WIDTH) {
                    // check if line is shorter than desired length. 
                    int padding = BOARD_WIDTH - rowList.size();
                    for (int i = 0; i < padding; i++) {
                        rowList.add('T');
                    }
                }
                chessLayout.add(rowList);
            }
        
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find layout file: " + layoutFileString);
            e.printStackTrace();
            System.exit(1);

        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        
        // Check that the proper dimensions are setup. 
        int expectedRows = BOARD_WIDTH, expectedCols = BOARD_WIDTH;

        try {
            if (chessLayout.size() != expectedRows) {
                throw new DimensionException("Incorrect number of rows.");
            }
        } catch (DimensionException e) {
            System.err.println("Invalid layout file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        try {
            for (ArrayList<Character> rowList : chessLayout) {
                if (rowList.size() != expectedCols) {
                    throw new DimensionException("Incorrect column length or mismatched column length.");
                }
            }
        } catch (DimensionException e) {
            System.err.println("Invalid layout file: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
       
        return chessLayout;
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
