package XXLChess.LegacyClasses;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import XXLChess.App;
import XXLChess.Message;
import XXLChess.Timer;
import XXLChess.enums.Colour;
import XXLChess.enums.GameOver;
import processing.core.PApplet;

public class UI extends SetObject {
    private final String TIME_HUMAN_WIN = "You win\non time.";
    private final String TIME_CPU_WIN = "You lost\non time.";
    private final String CHECK = "Check!";
    private final String CHECKMATE_HUMAN_WIN = "You win\nby checkmate.";
    private final String CHECKMATE_CPU_WIN = "You lost\nby checkmate.";
    private final String STALEMATE_DRAW = "Stalemate\ndraw.";

    private final int[] TIMER_TOP_XY = {App.WIDTH - 2*App.CELLSIZE, App.CELLSIZE};
    private final int[] TIMER_BOTTOM_XY = {App.WIDTH - 2*App.CELLSIZE, App.HEIGHT - App.CELLSIZE};
    private final int[] MESSAGE_XY = {(App.CELLSIZE * App.BOARD_WIDTH) + 16, (App.HEIGHT/2) + 16};

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

    public void updateTimers(Colour playerTurn) {
        timerDict.get(playerTurn).updateTimer();
    }

    public void incrementTimer(Colour timer) {
        timerDict.get(timer).addTime();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void check() {
        message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, CHECK);
    }

    public void gameOver(GameOver condition, boolean humanWin) {
        if (condition == GameOver.TIME) {
            if (humanWin) {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, TIME_HUMAN_WIN);
            } else {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, TIME_CPU_WIN);
            }
        } else if (condition == GameOver.CHECKMATE) {
            if (humanWin) {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, CHECKMATE_HUMAN_WIN);
            } else if (!humanWin) {
                message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, CHECKMATE_CPU_WIN);
            }
        } else {
            message = new Message(parent, MESSAGE_XY[0], MESSAGE_XY[1], null, STALEMATE_DRAW);
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
