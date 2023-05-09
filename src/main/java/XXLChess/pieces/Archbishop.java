package XXLChess.pieces;

import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;

public class Archbishop extends ChessPiece {

    public Archbishop(PApplet parent, PieceColour colour, int x, int y) {
        super(parent, colour, x, y);
    }

    @Override
    public void loadImage(String PATH) {
        if (this.colour == PieceColour.BLACK) {
            try {
                image = parent.loadImage(PATH + "b-archbishop.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else if (this.colour == PieceColour.WHITE) {
            try {
                image = parent.loadImage(PATH + "w-archbishop.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    protected void setup() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setup'");
    }
    
}
