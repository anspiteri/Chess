package XXLChess.board;

import XXLChess.DisplayObject;
import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Timer extends DisplayObject {

    public Timer(PApplet parent, int x, int y, Colour colour) {
        super(parent, x, y, colour);
    }

    public void display() {
    }

    public Colour getColour() {
        return colour;
    }

    public void addTime(int time) {
    }
}
