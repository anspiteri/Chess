package XXLChess;

import processing.core.PApplet;

public abstract class GameObject {
    protected PApplet parent;

    protected GameObject(PApplet parent) {
        this.parent = parent;
    }
    
    protected abstract void setup();
}
