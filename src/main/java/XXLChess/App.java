package XXLChess;

import processing.core.PApplet;
import processing.data.JSONObject;
import processing.event.MouseEvent;

import XXLChess.board.*;
import XXLChess.board.logic.Move;
import XXLChess.enums.*;
import XXLChess.exceptions.*;
import XXLChess.pieces.ChessPiece;
import XXLChess.players.*;

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
    private int tickCounter = 0;
    private int tickTime = 0;

    public static final boolean DEBUG = false;

    public static final String PATH = "src/main/resources/XXLChess/";
    public String configPath;
    public Config config;

    private Tileset tiles;
    private Pieceset pieces;
    private UI UI;

    private HumanPlayer humanPlayer;
    private AIPlayer aiPlayer;

    private Colour turnState;

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
        
        config = new Config();
        // deprecated -------------------------------->
        tiles = new Tileset(this);
        pieces = new Pieceset(this, chessLayoutBuffer);
        // <-------------------------------------------

        config.parseFile(configPath);

        // deprecated -------------------------------------------------------------------------------------------------------------->
        
        // Instantiate App components
       
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

        // initialise gameboard
        tiles.setup();
        pieces.setup(tiles); // requires tiles so that as pieces are instantiated, the corresponding tile state changes to 'occupied'.

        // Load images during setup
        pieces.loadImages();

        // Starting turn. 
        turnState = Colour.WHITE;

        // <--------------------------------------------------------------------------------------------------------------------------
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
        int mouseX = e.getX();
        int mouseY = e.getY();
        boolean clickValid = false;
        
        if ( (UI.isGameOver() == false) & (turnState == humanPlayer.getColour()) ) {
            Tile tile = tiles.checkTile(mouseX, mouseY); // checks mouse xy is in a tile x/y.
            if (tile != null) {
                ChessPiece piece = pieces.getPiece(tile.getRow(), tile.getCol());
                // INSTANCE ONE: 
                //  Player hasnt selected anything, and they want to click a valid piece.
                if ((humanPlayer.hasSelected() == false) & (tile.getOccupied())) {

                    if (piece.getColour() == humanPlayer.getColour()) {
                        clickValid = true;
                        humanPlayer.select(tile, piece, tiles, pieces, UI);
                    }
                // INSTANCE TWO
                // Player already has a piece selected but aborts that for another piece.
                } else if ((humanPlayer.hasSelected() == true) & (tile.getOccupied()) 
                        & (piece.getColour() == humanPlayer.getColour())) {

                    clickValid = true;
                    humanPlayer.select(tile, piece, tiles, pieces, UI);

                // INSTANCE THREE
                // Player has selected a piece and wants to make a move. 
                } else if (humanPlayer.hasSelected() == true) {
                    Move selectedMove = humanPlayer.isValidMove(tile.getRow(), tile.getCol());
                    if (selectedMove != null) {
                        // get row/col for click and move piece or capture & move. 
                        humanPlayer.makeMove(selectedMove, tiles, pieces);
                        // get x/y for animation
                        changeTurn();
                    }
                }
            }
        }

        // All conditions checked. 
        if (!clickValid) {
            humanPlayer.deselect(tiles, pieces);
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
            tickTime++;
            tick();
            tickCounter = 0;
            
            if (tickTime == 5) {
                tickTime = 0;
            }
        }

        background(128, 128, 128);

        // Display chess board tiles, pieces, timers, messages
        tiles.display();
        pieces.display();
        UI.display();
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.

    /**
     * tick():
     * Updates every second (60 frames)
     */
    public void tick() {

        // check game over condition for timer. 
        if ( (UI.getTimer(humanPlayer.getColour()).getTime() == 0) ) {
            UI.gameOver(GameOver.TIME, false);
        } else if (UI.getTimer(aiPlayer.getColour()).getTime() == 0) {
            UI.gameOver(GameOver.TIME, true);
        }

        // timer decreases 
        if (UI.isGameOver() == false) {
            UI.updateTimers(turnState);
        }

        if ((turnState == aiPlayer.getColour()) & (tickTime == 5)) {
            changeTurn();
        }
    }

    public void changeTurn() {
        // TODO: check for checkmate & set game over accordingly, make AI do their turn. 
        if (turnState == Colour.WHITE) {
            turnState = Colour.BLACK;
            UI.incrementTimer(Colour.WHITE);
        } else {
            turnState = Colour.WHITE;
            UI.incrementTimer(Colour.BLACK);
        }
    }
    
    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getAiPlayer() {
        return aiPlayer;
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
