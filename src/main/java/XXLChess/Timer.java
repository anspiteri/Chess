package XXLChess;

import XXLChess.enums.Colour;

public class Timer {
    public static final int TEXT_SIZE = 32;

    private int seconds;
    private int increment;  

    public Timer(Colour colour) {
        this.seconds = 0;
        this.increment = 0;
    }

    public void setTime(int seconds, int increment) {
        this.seconds = seconds;
        this.increment = increment;
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
