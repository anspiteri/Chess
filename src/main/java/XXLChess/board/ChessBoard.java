package XXLChess.board;

import java.util.HashMap;
import java.util.Map;

import XXLChess.config.StartingPositions;
import XXLChess.enums.PieceType;
import XXLChess.enums.TeamColour;
import XXLChess.exceptions.PieceCreationException;
import processing.core.PImage;

public class ChessBoard {
    private ChessPiece[] boardPositions; 

    public ChessBoard(Map<PieceType, PImage> PImageMap, TeamColour playerColour) {
        Map<Character, int[]> startingPositions = new HashMap<>();
        try {
            startingPositions = getStartingPositions(playerColour);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        initChessPiecesOnBoard(PImageMap, startingPositions);
        
    }

    private Map<Character, int[]> getStartingPositions(TeamColour playerColour) throws PieceCreationException {
        if (playerColour == TeamColour.NULL) {
            throw new PieceCreationException("Error: player colour is not correctly formatted.");
        }

        if (playerColour == TeamColour.BLACK) {
            return StartingPositions.startingPositionsBlack;
        } else {
            return StartingPositions.startingPositionsWhite;
        }
    }

    private void initChessPiecesOnBoard(Map<PieceType, PImage> PImageMap, Map<Character, int[]> startingPositions) {
        // LOOP#1 Iterates through every possible TYPE of piece. 
        for (PieceType pieceType : PieceType.values()) {
            if (pieceType != PieceType.NONE) {
                int[] piecePositions = startingPositions.get(pieceType.key);
                PImage image = PImageMap.get(pieceType);
                TeamColour colour = pieceType.colour;

                // LOOP#2 Uses TYPE as a key to access all starting positions for that type. 
                for (int position : piecePositions) {
                    //TODO: Starting coordinates and fix null pointer exception. 
                    //boardPositions[position] = new ChessPiece(pieceType, colour, position, 0, 0, image);
                }
            }
        }
    }

    // Setters
    public void moveChessPiece(int oldPosition, int newPosition) {
        ChessPiece piece = boardPositions[oldPosition];
        boardPositions[oldPosition] = null;

        boardPositions[newPosition] = piece;
        piece.changePosition(newPosition, 0, 0);
    }

    // Getters
    public ChessPiece getChessPiece(int boardPosition) {
        return boardPositions[boardPosition];
    }
}
