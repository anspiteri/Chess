package XXLChess;

public class Board {
    private Position[] boardPositions;

    public Board(int boardWidth, int boardHeight) {
        boardPositions = new Position[boardWidth * boardHeight];
    }

     // TODO:
    // Determine whether getOccupied is a relevent function, because if I'm checking if something 
    // is occupied, I often want to know what is there as well. So check whether I ever need isOccupied 
    // on its own, and if so, I need to work out some logic, (possibly an if-else statment) where if 
    // it is occupied, I use another function to get what is occupied there. 
    // TODO:
    // - figure out a method for retrieving what piece is occupied at a position, if the pieces are stored 
    // within the player classes. 
    public boolean getOccupied(int boardIndex) {
        return boardPositions[boardIndex].isOccupied();
    }

    
    public class Position {
        private boolean isOccupied;

        public Position() {
            isOccupied = false; 
        }

        public boolean isOccupied() {
            return isOccupied;
        }
    }

    /**
     * This method is used to calculate the coordinates of a given position. 
     * This is required especially for drawing object positions to the screen. 
     * @param boardIndex
     * @return A Point object which contains the x and y coordinate as params. 
     */
    public static Point getCoordinate(int boardIndex) {
        double xCoord, yCoord;

        //TODO: Algorithm for calculating coords from board index. 
        xCoord = 0;
        yCoord = 0;

        return new Point(xCoord, yCoord);
    }

   

    /*
     * Possible movement methods.
     * Not sure whether these work the best in this particular class...
     */

    public static void MOVE_LEFT() {
    }

    public static void MOVE_RIGHT() {
    }

    public static void MOVE_UP() {
    }

    public static void MOVE_DOWN() {
    }
}
