package XXLChess;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import XXLChess.board.Timer;
import XXLChess.enums.Colour;
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

    @Override
    public void display() {
        timerTop.display();
        timerBottom.display();
    }

    public Timer getTimer(Colour teamColour) {
        return timerDict.get(teamColour);
    }
    
}
