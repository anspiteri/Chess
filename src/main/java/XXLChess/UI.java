package XXLChess;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import XXLChess.board.Message;
import XXLChess.board.Timer;
import XXLChess.enums.Colour;
import XXLChess.enums.GameOver;
import processing.core.PApplet;

public class UI extends SetObject {
    private final String TIME_BLACK_WIN = "Black\nwins.";
    private final String TIME_WHITE_WIN = "White\nwins.";
    private final String TIME_DRAW = "Draw.";
    private final String CHECKMATE_BLACK_WIN = "Checkmate, black wins.";
    private final String CHECKMATE_WHITE_WIN = "Checkmate, white wins.";
    private final String STANDARD_DRAW = "Draw.";

    private final int[] TIMER_TOP_XY = {App.WIDTH - 2*App.CELLSIZE, App.CELLSIZE};
    private final int[] TIMER_BOTTOM_XY = {App.WIDTH - 2*App.CELLSIZE, App.HEIGHT - App.CELLSIZE};
    private final int[] MESSAGE_XY = {(App.CELLSIZE * App.BOARD_WIDTH) + 16, (App.HEIGHT/2) + 24};

    private final Map<Colour, Timer> timerDict;

    private Timer timerTop;
    private Timer timerBottom;
    private Message message;
    private boolean gameOver;

    public UI(PApplet parent, Colour playerColour, Colour AIColour) {
        super(parent);
        timerTop = new Timer(parent, TIMER_TOP_XY[0], TIMER_TOP_XY[1], AIColour);
        timerBottom = new Timer(parent, TIMER_BOTTOM_XY[0], TIMER_BOTTOM_XY[1], playerColour);
        message = null;
        gameOver = false;

        timerDict = Collections.unmodifiableMap(new HashMap<Colour, Timer>() {{
            put(timerTop.getColour(), timerTop);
            put(timerBottom.getColour(), timerBottom);
        }});
    }

    public void setupTimers(int secondsHuman, int incrementHuman, int secondsAI, int incrementAI) {
        timerTop.setTime(secondsAI, incrementAI);
        timerBottom.setTime(secondsHuman, incrementHuman);
    }

    public Timer getTimer(Colour teamColour) {
        return timerDict.get(teamColour);
    }

    public void updateTimers() {
        timerTop.updateTimer();
        timerBottom.updateTimer();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void gameOver(GameOver condition, Colour winner) {
        if (condition == GameOver.TIME) {
            if (winner == Colour.BLACK) {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, TIME_BLACK_WIN);
            } else if (winner == Colour.WHITE) {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, TIME_WHITE_WIN);
            } else {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, TIME_DRAW);
            }
        } else if (condition == GameOver.CHECKMATE) {
            if (winner == Colour.BLACK) {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, CHECKMATE_BLACK_WIN);
            } else if (winner == Colour.WHITE) {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, CHECKMATE_WHITE_WIN);
            }
        } else {
            message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, STANDARD_DRAW);
        }
        gameOver = true; 
    }

    @Override
    public void display() {
        timerTop.display();
        timerBottom.display();

        if (gameOver == true) {
           message.display();
        }
    }

    
}
