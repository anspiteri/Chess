package XXLChess;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StartingPositions {
    public static final Map<Character, int[]> startingPositionsWhite;
    public static final Map<Character, int[]> startingPositionsBlack;

    /*
     * LOWERCASE denotes WHITE pieces. 
     */

    // Player == Black. 
    static {
        Map<Character, int[]> map = new HashMap<>();
        map.put('r', new int[] {0, 7});
        map.put('R', new int[] {56, 63});

        map.put('n', new int[] {1, 6});
        map.put('N', new int[] {57, 62});

        map.put('b', new int[] {2, 5});
        map.put('B', new int[] {58, 61});

        map.put('q', new int[] {3});
        map.put('Q', new int[] {59});

        map.put('k', new int[] {4});
        map.put('K', new int[] {60});

        map.put('p', new int[] {
            8, 9, 10, 11, 12, 13, 14, 15
        });
        map.put('P', new int[] {
            48, 49, 50, 51, 52, 53, 54, 55
        });

        startingPositionsBlack = Collections.unmodifiableMap(map);
    }

    // Player == White.
    static {
        Map<Character, int[]> map = new HashMap<>();
        map.put('R', new int[] {0, 7});
        map.put('r', new int[] {56, 63});

        map.put('N', new int[] {1, 6});
        map.put('n', new int[] {57, 62});

        map.put('B', new int[] {2, 5});
        map.put('b', new int[] {58, 61});

        map.put('Q', new int[] {3});
        map.put('q', new int[] {59});

        map.put('K', new int[] {4});
        map.put('k', new int[] {60});

        map.put('P', new int[] {
            8, 9, 10, 11, 12, 13, 14, 15
        });
        map.put('p', new int[] {
            48, 49, 50, 51, 52, 53, 54, 55
        });

        startingPositionsWhite = Collections.unmodifiableMap(map);
    }
}
