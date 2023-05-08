package XXLChess;

import processing.core.PApplet;

public abstract class DisplayObject extends GameObject {

    protected DisplayObject(PApplet parent) {
        super(parent);
        //TODO Auto-generated constructor stub
    }
    
    protected abstract void display();
}
