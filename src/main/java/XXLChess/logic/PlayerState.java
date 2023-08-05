package XXLChess.logic;

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

    public boolean isHuman() {
        return isHuman;
    }

    public boolean currentTurn() {
        return isPlayersTurn;
    }

    public boolean inCheck() {
        return inCheck;
    }

    public boolean inCheckMate() {
        return inCheckMate;
    }
}
