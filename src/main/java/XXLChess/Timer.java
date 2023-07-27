package XXLChess;

import XXLChess.enums.Colour;

public class Timer {
    private Colour teamColour;
    private int seconds;
    private int increment;  

    public Timer(Colour teamColour, int seconds, int increment) {
        this.teamColour = teamColour;
        this.seconds = seconds;
        this.increment = increment;
    }

    public Colour getColour() {
        return teamColour;
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
