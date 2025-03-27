
public class RobotMonitor {
    // constant (ensure you have at least MAX)

    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 6;
    public static final int MIN_COL = 1;
    public static final int MAX_COL = 6;

    // Enumeration for moves
    public enum Move {
        RIGHT, LEFT, UP, DOWN
    }

    // attributes   
    private int row;
    private int col;
    private Move lastMove; // This value can be null if there is no move yet

    // invariant
    public boolean inv() {
        // code here
        return row >= MIN_ROW && row <= MAX_ROW
                && col >= MIN_COL && col <= MAX_COL;
    }

    // initialisation: robot starts at (1,1), no move
    public RobotMonitor() {
        this.row = MIN_ROW;
        this.col = MIN_COL;
        this.lastMove = null;
        assert inv();
    }

    //operations
    public int GetCol() {
        // code here
        return col;
    }

    public int GetRow() {
        // code here
        return row;
    }

    public Move GetMove() {
        // DO NOT MODIFY if you are sticking to the simple Robot model
        if (lastMove == null) {
            throw new IllegalStateException("No move has been made yet.");
        }
        return lastMove;
    }

    public void MoveRight() {
        /*
                CHECK precondtion
                IMPLEMENT postcondition
                CHECK invariant 
         */
        if (col >= MAX_COL) {
            throw new IllegalStateException("Precondition failed: Already at max column.");
        }
        if (lastMove == Move.RIGHT) {
            throw new IllegalStateException("Precondition failed: Cannot move right twice in a row.");
        }

        col += 1;
        lastMove = Move.RIGHT;

        assert inv();
    }

    public void MoveLeft() {
        // code here     
        if (col <= MIN_COL) {
            throw new IllegalStateException("Precondition failed: Already at min column.");
        }
        if (lastMove == Move.LEFT) {
            throw new IllegalStateException("Precondition failed: Cannot move left twice in a row.");
        }

        col -= 1;
        lastMove = Move.LEFT;

        assert inv();
    }

    public void MoveDown() {
        // code here 
        if (row >= MAX_ROW) {
            throw new IllegalStateException("Precondition failed: Already at max row.");
        }
        if (lastMove == Move.DOWN) {
            throw new IllegalStateException("Precondition failed: Cannot move down twice in a row.");
        }

        row += 1;
        lastMove = Move.DOWN;

        assert inv();
    }

    public void MoveUp() {
        // code here 
        if (row <= MIN_ROW) {
            throw new IllegalStateException("Precondition failed: Already at min row.");
        }
        if (lastMove == Move.UP) {
            throw new IllegalStateException("Precondition failed: Cannot move up twice in a row.");
        }

        row -= 1;
        lastMove = Move.UP;

        assert inv();
    }

    public void Exit() {
        // code here
        if (row != MAX_ROW || col != MAX_COL) {
            throw new IllegalStateException("Precondition failed: Must be at (6,6) to exit.");
        }

        row = MIN_ROW;
        col = MIN_COL;
        lastMove = null;

        assert inv();
    }

    // toString method added
    public String toString() {
        // modify if you are using the text based tester
        return " ";
    }
}
