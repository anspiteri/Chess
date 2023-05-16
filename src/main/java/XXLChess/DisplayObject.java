package XXLChess;

import XXLChess.enums.Colour;
import processing.core.PApplet;

public class DisplayObject extends GameObject {
    protected int x, y;
    protected Colour colour;

    protected DisplayObject(PApplet parent, int x, int y, Colour colour) {
        super(parent);
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Colour getColour() {
        return colour;
    }
}
