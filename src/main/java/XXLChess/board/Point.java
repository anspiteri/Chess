package XXLChess.board;

public class Point {
    private final double xCoord;
    private final double yCoord;

    public Point(double xCoord, double yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public double xCoord() {
        return xCoord;
    }

    public double yCoord() {
        return yCoord;
    }
}
