package XXLChess;

import XXLChess.players.Player;
import processing.core.PApplet;

public class Board extends GameObject {

    private Tileset tiles;
    private Pieceset pieces; 

    private Player playerBlack;
    private Player playerWhite;

    public Board(PApplet parent, Tileset tiles, Pieceset pieces, Player playerBlack, Player playerWhite) {
        super(parent);
        this.tiles = tiles;
        this.pieces = pieces;
        this.playerBlack = playerBlack;
        this.playerWhite = playerWhite;
    }
}
