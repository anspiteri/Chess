package XXLChess.pieces;

import XXLChess.pieces.enums.PieceColour;
import processing.core.PApplet;

public class Knight extends ChessPiece {

    public Knight(PApplet parent, PieceColour colour, int x, int y) {
        super(parent, colour, x, y);
    }

    @Override
    public void loadImage(String PATH) {
        if (this.colour == PieceColour.BLACK) {
            try {
                image = parent.loadImage(PATH + "b-knight.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        } else if (this.colour == PieceColour.WHITE) {
            try {
                image = parent.loadImage(PATH + "w-knight.png");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void display() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'display'");
    }

    @Override
    protected void setup() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setup'");
    }
    
}
