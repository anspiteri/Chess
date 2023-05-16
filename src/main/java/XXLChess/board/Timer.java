package XXLChess.board;

import XXLChess.DisplayObject;
import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Timer extends DisplayObject {
    private final int TEXT_SIZE = 32;

    private int seconds;
    private int increment;

    public Timer(PApplet parent, int x, int y, Colour colour) {
        super(parent, x, y, colour);
        this.seconds = 0;
        this.increment = 0;
        parent.textSize(TEXT_SIZE);
    }

    public void setTime(int seconds, int increment) {
        this.seconds = seconds;
        this.increment = increment;
    }

    public void display() {
        parent.text(seconds, x, y);
    }

    public void addTime() {
        seconds += increment;
    }

    public void updateTimer() {
        if (seconds > 0) {
            seconds -= 1;
        }
    }

    public int getTime() {
        return seconds;
    }
}
