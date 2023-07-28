package XXLChess;

public class StartingPositions {
    
    // For the issue of black and white pieces differing in starting positions, this is solved 
    // in the BoardPieces class implementation. 
    public static final StartingPosition[] startingPositions = {
        new StartingPosition(0, 'r'),
        new StartingPosition(1, 'n'),
        new StartingPosition(2, 'b'),
        new StartingPosition(3, 'q'),
        new StartingPosition(4, 'k'),
        new StartingPosition(5, 'b'),
        new StartingPosition(6, 'n'),
        new StartingPosition(7, 'r'),
        new StartingPosition(8, 'p'),
        new StartingPosition(9, 'p'),
        new StartingPosition(10, 'p'),
        new StartingPosition(11, 'p'),
        new StartingPosition(12, 'p'),
        new StartingPosition(13, 'p'),
        new StartingPosition(14, 'p'),
        new StartingPosition(15, 'p'),
        new StartingPosition(48, 'P'),
        new StartingPosition(49, 'P'),
        new StartingPosition(50, 'P'),
        new StartingPosition(51, 'P'),
        new StartingPosition(52, 'P'),
        new StartingPosition(53, 'P'),
        new StartingPosition(54, 'P'),
        new StartingPosition(55, 'P'),
        new StartingPosition(56, 'R'),
        new StartingPosition(57, 'N'),
        new StartingPosition(58, 'B'),
        new StartingPosition(59, 'Q'),
        new StartingPosition(60, 'K'),
        new StartingPosition(61, 'B'),
        new StartingPosition(62, 'N'),
        new StartingPosition(63, 'R')
    };

    public class StartingPosition {
        private int positionalIndex; 
        private char pieceTypeKey;

        public StartingPosition(int positionalIndex, char pieceTypeKey) {
            this.positionalIndex = positionalIndex;
            this.pieceTypeKey = pieceTypeKey;
        }

        public int getStartingPosition() {
            return positionalIndex;
        }

        public char getPieceTypeKey() {
            return pieceTypeKey;
        }
    }
}
