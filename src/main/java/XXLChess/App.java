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

import XXLChess.exceptions.DimensionException;
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
        try {
            conf  = loadJSONObject(new File(this.configPath));
        } catch (JSException e) {
            e.printStackTrace();
            System.out.println("Error parsing JSON file.");
        }

        String layoutFileString = conf.getString("layout");
        ArrayList<ArrayList<Character>> chessLayout = parseLayout(layoutFileString);

        // Instantiate board components
        tiles = new Tileset(this);
        pieces = new Pieceset(this, chessLayout);
        // add logic to decide whether to instantiate human players or AI players
        board = new Board(this, tiles, pieces, playerBlack, playerWhite);
        
        // initialise gameboard
        tiles.setup();
        pieces.setup();
        board.setup();

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
    public void mouseClicked(MouseEvent e) {
        
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


    public ArrayList<ArrayList<Character>> parseLayout(String layoutFileString) {
        Scanner sc = null;
        ArrayList<ArrayList<Character>> chessLayout = new ArrayList<ArrayList<Character>>();
        
        // Parse the layout file into the buffer. 
        try {
            sc = new Scanner(new File(layoutFileString));
            sc.useDelimiter("\\n"); // Use delimiter instead of nextLine() as to not skip whitespaces. 

            while (sc.hasNext()) {
                ArrayList<Character> rowList = new ArrayList<>();
                String line = sc.next();
                
                if (line.charAt(0) != '\n') {
                    // If the line has chess positions: store keys into char array. 
                    for (char c : line.toCharArray()) {
                        if (c != '\n') {
                            rowList.add(c);
                        }
                    }
                } else {
                    // If it is an empty line: Create a char array with appropriate length.
                    for (int i = 0; i < BOARD_WIDTH; i++) {
                        rowList.add(' ');
                    }
                }

                chessLayout.add(rowList);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find layout file: " + layoutFileString);
            e.printStackTrace();
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
            System.out.println("Invalid layout file: " + e.getMessage());
        }

        try {
            for (ArrayList<Character> rowList : chessLayout) {
                if (rowList.size() != expectedCols) {
                    throw new DimensionException("Incorrect column length or mismatched column length.");
                }
            }
        } catch (DimensionException e) {
            System.err.println("Invalid layout file: " + e.getMessage());
            System.exit(0);
        }
       
        return chessLayout;
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
