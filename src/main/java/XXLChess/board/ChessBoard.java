package XXLChess.board;

import java.util.Map;

import XXLChess.config.StartingPositions;
import XXLChess.enums.PieceType;
import XXLChess.enums.TeamColour;

public class ChessBoard {
    private ChessPiece[] boardPositions; 

    public ChessBoard(TeamColour playerColour) {
        if (playerColour == TeamColour.BLACK) {
            initChessPiecesOnBoard(StartingPositions.startingPositionsBlack);
        } else {
            initChessPiecesOnBoard(StartingPositions.startingPositionsWhite);
        }
    }

    private void initChessPiecesOnBoard(Map<Character, int[]> startingPositions) {
        boardPositions = new ChessPiece[64];

        // LOOP#1 Iterates through every possible TYPE of piece. 
        for (PieceType pieceType : PieceType.values()) {
            if (pieceType != PieceType.NONE) {
                int[] piecePositions = startingPositions.get(pieceType.key);
                TeamColour colour = pieceType.colour;

                // LOOP#2 Uses TYPE as a key to access all starting positions for that type. 
                for (int position : piecePositions) {
                    boardPositions[position] = new ChessPiece(pieceType, colour, position);
                }
            }
        }
    }

    // Setters
    public void moveChessPiece(int oldPosition, int newPosition) {
        ChessPiece piece = boardPositions[oldPosition];
        boardPositions[oldPosition] = null;

        boardPositions[newPosition] = piece;
        piece.changePosition(newPosition);
    }

    // Getters
    public ChessPiece getChessPiece(int boardPosition) {
        return boardPositions[boardPosition];
    }
}
