package XXLChess;

public class PlayerState {
    private boolean inCheck;
    private boolean inCheckMate;
    private boolean isPlayersTurn;

    private boolean isHuman;

    public PlayerState(boolean isPlayersTurn) {
        inCheck = false;
        inCheckMate = false;
        this.isPlayersTurn = isPlayersTurn;
    }

    public void makeHumanPlayer() {
        isHuman = true;
    }

    public void makeCpuPlayer() {
        isHuman = false;
    }

}
