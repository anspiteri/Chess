package XXLChess;

public class CoordinateCalculator {
    
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
}
