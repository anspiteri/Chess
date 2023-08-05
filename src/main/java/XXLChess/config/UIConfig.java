package XXLChess.config;

import XXLChess.App;

public class UIConfig {
    
    // Text sizes
    public static final int TIMER_TEXT_SIZE = 32;
    public static final int MSG_TEXT_SIZE = 16;
    
    // Placement of UI
    public static final int[] TIMER_TOP_XY = {App.WIDTH - 2*App.CELLSIZE, App.CELLSIZE};
    public static final int[] TIMER_BOTTOM_XY = {App.WIDTH - 2*App.CELLSIZE, App.HEIGHT - App.CELLSIZE};
    public static final int[] MESSAGE_XY = {(App.CELLSIZE * App.BOARD_WIDTH) + 16, (App.HEIGHT/2) + 16};
    
    // Messages
    public static final String TIME_BLACK_WIN = "Black wins\non time.";
    public static final String TIME_WHITE_WIN = "White wins\non time.";
    public static final String CHECK = "Check!";
    public static final String CHECKMATE_BLACK_WIN = "Black wins\nby checkmate.";
    public static final String CHECKMATE_WHITE_WIN = "White wins\nby checkmate.";
    public static final String STALEMATE_DRAW = "Stalemate\ndraw.";
}
