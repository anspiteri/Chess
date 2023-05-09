package XXLChess;

import processing.core.PApplet;

public abstract class DisplayObject extends GameObject {

    protected DisplayObject(PApplet parent) {
        super(parent);
    }
    
    protected abstract void display();
}
