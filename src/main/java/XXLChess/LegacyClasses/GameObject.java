package XXLChess.LegacyClasses;

import processing.core.PApplet;

public class GameObject {
    protected PApplet parent;

    protected GameObject(PApplet parent) {
        this.parent = parent;
    }
}
