package XXLChess;

public class Board extends App {
    private Tileset tileset;
    private Pieceset pieceset;

    public Board(Tileset tileset, Pieceset pieceset) {
        this.tileset = tileset;
        this.pieceset = pieceset;
    }

    public void setup() {
        tileset.setup();
        pieceset.setup();
    }

    public void display() {
        tileset.display();
        pieceset.display();
    }
}
