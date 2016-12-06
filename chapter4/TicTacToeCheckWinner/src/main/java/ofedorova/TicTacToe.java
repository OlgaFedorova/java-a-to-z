package ofedorova;

import java.util.HashMap;
import java.util.Map;


/**
 * Class implement business logic of game "TicTacToe".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 01.12.2016
 */
public class TicTacToe {
    /**
     * Game field.
     */
    private final int[][] field;
    /**
     * Count for winner.
     */
    private final int countForWinner;

    /**
     * Allocates a new {@code TicTacToe}.
     *
     * @param field          value of field "field".
     * @param countForWinner value of field "countForWinner".
     */
    public TicTacToe(int[][] field, int countForWinner) {
        int[][] dest = new int[field.length][];
        for (int index = 0; index < field.length; index++) {
            dest[index] = field[index];
        }
        this.field = dest;
        this.countForWinner = countForWinner;
    }

    /**
     * Method return coordinates for next point depending from coordinates of current point and direction of moving.
     *
     * @param directionOfMovement direction of moving.
     * @param x                   coordinate x of current point.
     * @param y                   coordinate y of current point.
     * @return map of coordinates next point.
     */
    private Map<String, Integer> getNextCoordinates(DirectionOfMovementOnGameArea directionOfMovement, int x, int y) {
        int xNext = -1;
        int yNext = -1;
        final Map<String, Integer> nextCoordinates = new HashMap<>();

        if (DirectionOfMovementOnGameArea.DIAGONAL_DOWN_LEFT.equals(directionOfMovement)
                || DirectionOfMovementOnGameArea.DIAGONAL_UP_LEFT.equals(directionOfMovement)) {
            xNext = x - 1;
        } else if (DirectionOfMovementOnGameArea.DIAGONAL_DOWN_RIGHT.equals(directionOfMovement)
                || DirectionOfMovementOnGameArea.DIAGONAL_UP_RIGHT.equals(directionOfMovement)
                || DirectionOfMovementOnGameArea.HORIZONTAL_RIGHT.equals(directionOfMovement)) {
            xNext = x + 1;
        } else if (DirectionOfMovementOnGameArea.VERTICAL_DOWN.equals(directionOfMovement)) {
            xNext = x;
        }

        if (DirectionOfMovementOnGameArea.DIAGONAL_DOWN_LEFT.equals(directionOfMovement)
                || DirectionOfMovementOnGameArea.DIAGONAL_DOWN_RIGHT.equals(directionOfMovement)
                || DirectionOfMovementOnGameArea.VERTICAL_DOWN.equals(directionOfMovement)) {
            yNext = y + 1;
        } else if (DirectionOfMovementOnGameArea.DIAGONAL_UP_LEFT.equals(directionOfMovement)
                || DirectionOfMovementOnGameArea.DIAGONAL_UP_RIGHT.equals(directionOfMovement)) {
            yNext = y - 1;
        } else if (DirectionOfMovementOnGameArea.HORIZONTAL_RIGHT.equals(directionOfMovement)) {
            yNext = y;
        }
        nextCoordinates.put("X", xNext);
        nextCoordinates.put("Y", yNext);
        return nextCoordinates;
    }

    /**
     * Method compares current symbol with next symbol and returns count of symbol in a row.
     *
     * @param directionOfMovement direction of moving.
     * @param x                   coordinate x of current element.
     * @param y                   coordinate y of current element.
     * @param countRow            count of symbol in a row.
     * @return count of symbol in a row.
     */
    private int checkSymbol(DirectionOfMovementOnGameArea directionOfMovement, int x, int y, int countRow) {
        final Map<String, Integer> nextCoordinates = this.getNextCoordinates(directionOfMovement, x, y);
        final int xNext = nextCoordinates.get("X");
        final int yNext = nextCoordinates.get("Y");
        if (yNext >= 0 && yNext < this.field.length && xNext >= 0 && xNext < this.field[yNext].length && countRow != this.countForWinner) {
            if (this.field[y][x] != 0 && this.field[y][x] == this.field[yNext][xNext]) {
                countRow++;
                countRow = this.checkSymbol(directionOfMovement, xNext, yNext, countRow);
            } else {
                countRow = this.checkSymbol(directionOfMovement, xNext, yNext, 1);
            }
        }
        return countRow;
    }

    /**
     * Method checks has winner or not.
     *
     * @return if has winner return true, else return false.
     */
    public boolean hasWinner() {
        boolean hasWinner = false;
        for (int index = 0; index < this.field.length; index++) {
            final int countARowOnDiagonalDownLeft = this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_DOWN_LEFT, index, 0, 1);
            final int countARowOnDiagonalDownRight = this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_DOWN_RIGHT, index, 0, 1);
            final int countARowOnVerticalDown = this.checkSymbol(DirectionOfMovementOnGameArea.VERTICAL_DOWN, index, 0, 1);
            final int countARowOnHorizontalRight = this.checkSymbol(DirectionOfMovementOnGameArea.HORIZONTAL_RIGHT, 0, index, 1);
            final int countARowOnDiagonalUpLeft = this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_UP_LEFT, index, this.field.length - 1, 1);
            final int countARowOnDiagonalUpRight = this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_UP_RIGHT, index, this.field.length - 1, 1);
            hasWinner = countARowOnDiagonalDownLeft == this.countForWinner || countARowOnDiagonalDownRight == this.countForWinner
                    || countARowOnVerticalDown == this.countForWinner || countARowOnDiagonalUpLeft == this.countForWinner
                    || countARowOnDiagonalUpRight == this.countForWinner || countARowOnHorizontalRight == this.countForWinner;
            if (hasWinner) {
                break;
            }
        }
        return hasWinner;
    }

    /**
     * Enum implements type of direction movement on game area.
     *
     * @author Olga Fedorova
     * @version 1.0
     * @since 12.11.2016
     */
    private enum DirectionOfMovementOnGameArea {
        /**
         * Movement by vertical down.
         */
        VERTICAL_DOWN,
        /**
         * Movement by horizontal right.
         */
        HORIZONTAL_RIGHT,
        /**
         * Movement by diagonal up left.
         */
        DIAGONAL_UP_LEFT,
        /**
         * Movement by diagonal up right.
         */
        DIAGONAL_UP_RIGHT,
        /**
         * Movement by diagonal down left.
         */
        DIAGONAL_DOWN_LEFT,
        /**
         * Movement by diagonal down right.
         */
        DIAGONAL_DOWN_RIGHT;
    }
}
