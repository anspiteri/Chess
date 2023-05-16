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

import XXLChess.board.*;
import XXLChess.enums.*;
import XXLChess.exceptions.*;
import XXLChess.players.*;


import java.awt.Color;
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
    private int tickCounter = 0;

    public static final boolean DEBUG = false;

    public static final String PATH = "src/main/resources/XXLChess/";
    public String configPath;
    public JSONObject conf;

    private Tileset tiles;
    private Pieceset pieces;
    private UI UI;

    private Player humanPlayer;
    private Player aiPlayer;

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
        String playerColour = "null";
        Double pieceMovementSpeed = 0.0, maxMovementTime = 0.0;
        int secondsHuman = 0, incrementHuman = -1, secondsAI = 0, incrementAI = -1;

        try {
            conf = loadJSONObject(new File(this.configPath));
            
            String layoutFileString = conf.getString("layout");
            chessLayoutBuffer = parseLayout(layoutFileString);

            timeControls = conf.getJSONObject("time_controls");
            playerColour = conf.getString("player_colour");
            pieceMovementSpeed = conf.getDouble("piece_movement_speed");
            maxMovementTime = conf.getDouble("max_movement_time");

            secondsHuman = timeControls.getJSONObject("player").getInt("seconds");
            incrementHuman = timeControls.getJSONObject("player").getInt("increment");
            secondsAI = timeControls.getJSONObject("cpu").getInt("seconds");
            incrementAI = timeControls.getJSONObject("cpu").getInt("seconds");

        } catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println("Error parsing JSON file.");
            System.exit(1);
        }

        // Instantiate App components
        tiles = new Tileset(this);
        pieces = new Pieceset(this, chessLayoutBuffer);

        try {
            if (playerColour.equals("white")) {
                humanPlayer = new HumanPlayer(this, Colour.WHITE);
                aiPlayer = new AIPlayer(this, Colour.BLACK);
            } else if (playerColour.equals("black")) {
                humanPlayer = new HumanPlayer(this, Colour.BLACK);
                aiPlayer = new AIPlayer(this, Colour.WHITE);
            } else {
                throw new ConfigException("Syntax err in colour param, must be \"black\" or \"white\"");
            }
        } catch (ConfigException e) {
            System.err.println("Config Error: " + e);
            System.err.println("player colour param: " + playerColour);
            System.exit(1);
        }

        UI = new UI(this, humanPlayer.getColour(), aiPlayer.getColour());

        try {
            if (secondsHuman > 0 & incrementHuman >= 0 & secondsAI > 0 & incrementAI >= 0) {
                UI.setupTimers(secondsHuman, incrementHuman, secondsAI, incrementAI);
            } else {
                throw new ConfigException("Syntax err in time controls params, seconds: positive nums, increment: 0 or positive");
            }
        } catch (ConfigException e) {
            System.err.println("Config Error: " + e);
            System.exit(1);
        }

        // initialise gameboard
        tiles.setup();
        pieces.setup(tiles); // requires tiles so that as pieces are instantiated, the corresponding tile state changes to 'occupied'.

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
        int mouseX = e.getX();
        int mouseY = e.getY();
        boolean clickValid = false;


        /*
         * CONDITION CHECK 
         *  - player has selected a valid chess piece.
         */

        // I will use the tile as the coordinate bounds for selection, thus iterate through each tile in the tileset.
        for (int row = 0; row < tiles.getTiles().length; row++) {
            for (int col = 0; col < tiles.getTiles()[row].length; col++) {
                Tile tile = tiles.getTiles()[row][col];
                
                // Check if mouse press is within bounds of tile. 
                if ( (mouseX > tile.getX() & mouseX < (tile.getX() + CELLSIZE)) & (mouseY > tile.getY() & mouseY < (tile.getY() + CELLSIZE)) ) {
                    
                    // Within bounds of tile. Next check if tile is occupied. 
                    if (tile.getOccupied() == true) {
                        // Valid piece selection. 
                        clickValid = true;
                        tiles.clearHighlights();
                        tile.setHighlight(HighlightColour.GREEN);
                    } 
                }
            }
        }

        /*
         * CONDITION CHECK
         *  - player has selected a screen element. 
         */

        // All conditions checked. 
        if (!clickValid) {
            tiles.clearHighlights();
        }
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
            tick();
            tickCounter = 0;
        }

        background(128, 128, 128);

        // Display chess board tiles, pieces, timers, messages
        tiles.display();
        pieces.display();
        UI.display();
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.

    /**
     * parseLayout():
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

    /**
     * tick():
     * Updates every second (60 frames)
     */
    public void tick() {

        //TODO: Push message object to the main draw command where it will continually display on screen. 

        // check game over conditions. 
        if ( (UI.getTimer(Colour.BLACK).getTime() == 0) | (UI.getTimer(Colour.WHITE).getTime() == 0) ) {
            Message message = UI.gameOver(GameOver.TIME);
            message.display();
        }

        // timer decreases 
        UI.updateTimers();
    }    

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
