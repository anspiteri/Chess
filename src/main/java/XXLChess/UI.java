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
    private final int[] TIMER_TOP_XY = {App.WIDTH - 2*App.CELLSIZE, App.CELLSIZE};
    private final int[] TIMER_BOTTOM_XY = {App.WIDTH - 2*App.CELLSIZE, App.HEIGHT - App.CELLSIZE};

    private final Map<Colour, Timer> timerDict;

    private Timer timerTop;
    private Timer timerBottom;

    public UI(PApplet parent, Colour playerColour, Colour AIColour) {
        super(parent);
        timerTop = new Timer(parent, TIMER_TOP_XY[0], TIMER_TOP_XY[1], AIColour);
        timerBottom = new Timer(parent, TIMER_BOTTOM_XY[0], TIMER_BOTTOM_XY[1], playerColour);

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

    public Message gameOver(GameOver condition) {
        Message message = null;
        if (condition == GameOver.TIME) {
            message = new Message(parent, TIMER_TOP_XY[0], App.HEIGHT / 2, null, "Times up!");
        }

        return message;
    }

    @Override
    public void display() {
        timerTop.display();
        timerBottom.display();
    }

    
}
