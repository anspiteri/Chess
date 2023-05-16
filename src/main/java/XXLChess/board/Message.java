package XXLChess.board;

import XXLChess.DisplayObject;
import XXLChess.enums.Colour;
import processing.core.PApplet;

public class Message extends DisplayObject {
    private String message;

    public Message(PApplet parent, int x, int y, Colour colour, String message) {
        super(parent, x, y, colour);
        this.colour = Colour.NULL;

        parent.textSize(32);
    }
    
    public void display() {
        parent.text(message, x, y);
    }
}