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

import XXLChess.board.Tile;
import XXLChess.board.TileColour;
import XXLChess.pieces.ChessPiece;

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
	
    public String configPath;

    private Tile[][] tiles;
    private TileColour tileColour;
    private ChessPiece[][] whitePeices;
    private ChessPiece[][] blackPieces;


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
        
        // Load images during setup

        // PImage spr = loadImage("src/main/resources/XXLChess/"+...);

		// load config
        JSONObject conf = loadJSONObject(new File(this.configPath));

        // initialise gameboard
        tiles = new Tile[BOARD_WIDTH][BOARD_WIDTH];
        whitePeices = new ChessPiece[BOARD_WIDTH][2];
        blackPieces = new ChessPiece[BOARD_WIDTH][2];
        setupTiles(tiles);
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
        drawTiles();

        
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.
    public void setupTiles(Tile[][] tiles) {
        
        for (int i = 0; i < tiles.length; i++) {
            // determine the starting colour per row
            if (i % 2 == 0) {
                tileColour = TileColour.WHITE;
            } else {
                tileColour = TileColour.BLACK;
            }
            
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = new Tile(j * CELLSIZE, i * CELLSIZE, tileColour);
                // logic used to create alternating black and white tiles across rows
                if (tileColour == TileColour.WHITE) {
                    tileColour = TileColour.BLACK;
                } else {
                    tileColour = TileColour.WHITE;
                }
            }
        }

    }

    public void drawTiles() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (tiles[i][j].getTileColour() == TileColour.WHITE) {
                    fill(255, 255, 240);
                } else {
                    fill(85, 63, 47);
                }
                if (tiles[i][j].highlighted()) {
                    switch (tiles[i][j].getHighlightColour()) {
                        case BLUE:
                            stroke(0, 0, 255, 30);
                            break;
                        case LIGHT_RED:
                            stroke(255, 153, 153, 30);
                            break;
                        case GREEN:
                            stroke(0, 255, 0, 30);
                            break;
                        case YELLOW:
                            stroke(255, 255, 0, 30);
                            break;
                        case DARK_RED:
                            stroke(153, 0, 0, 30);
                            break;
                        default:
                            stroke(0);
                    }
                    strokeWeight(4);
                } else {
                    stroke(0);
                    strokeWeight(1);
                }
                rect(tiles[i][j].getX(), tiles[i][j].getY(), CELLSIZE, CELLSIZE);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
