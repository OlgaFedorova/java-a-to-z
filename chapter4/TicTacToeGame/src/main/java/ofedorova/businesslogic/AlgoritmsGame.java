package ofedorova.businesslogic;

import ofedorova.areas.Symbol;

import java.util.HashMap;
import java.util.Map;


/**
 * Class consists algoritms for work with game "TicTacToe".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.11.2016
 */
public abstract class AlgoritmsGame {
    /**
     * Count of symbol a row for win.
     */
    private final int countForWin;

    /**
     * Allocates a new {@code AlgoritmsGame}.
     *
     * @param countForWin count a row for win
     */
    public AlgoritmsGame(int countForWin) {
        this.countForWin = countForWin;
    }

    /**
     * Enum implements type of direction movement on game area.
     *
     * @author Olga Fedorova
     * @version 1.0
     * @since 27.11.2016
     */
    private enum DirectionOfMovementOnGameArea {
        /**
         * Movement by vertical up.
         */
        VERTICAL_UP,
        /**
         * Movement by vertical down.
         */
        VERTICAL_DOWN,
        /**
         * Movement by horizontal left.
         */
        HORIZONTAL_LEFT,
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

        if (DirectionOfMovementOnGameArea.DIAGONAL_DOWN_LEFT.equals(directionOfMovement)) {
            xNext = x - 1;
            yNext = y + 1;
        } else if (DirectionOfMovementOnGameArea.DIAGONAL_DOWN_RIGHT.equals(directionOfMovement)) {
            xNext = x + 1;
            yNext = y + 1;
        } else if (DirectionOfMovementOnGameArea.DIAGONAL_UP_LEFT.equals(directionOfMovement)) {
            xNext = x - 1;
            yNext = y - 1;
        } else if (DirectionOfMovementOnGameArea.DIAGONAL_UP_RIGHT.equals(directionOfMovement)) {
            xNext = x + 1;
            yNext = y - 1;
        } else if (DirectionOfMovementOnGameArea.HORIZONTAL_LEFT.equals(directionOfMovement)) {
            xNext = x - 1;
            yNext = y;
        } else if (DirectionOfMovementOnGameArea.HORIZONTAL_RIGHT.equals(directionOfMovement)) {
            xNext = x + 1;
            yNext = y;
        } else if (DirectionOfMovementOnGameArea.VERTICAL_DOWN.equals(directionOfMovement)) {
            xNext = x;
            yNext = y + 1;
        } else if (DirectionOfMovementOnGameArea.VERTICAL_UP.equals(directionOfMovement)) {
            xNext = x;
            yNext = y - 1;
        }
        nextCoordinates.put("X", xNext);
        nextCoordinates.put("Y", yNext);
        return nextCoordinates;
    }

    /**
     * Method compares current symbol with parameter symbol.
     *
     * @param directionOfMovement direction of moving.
     * @param x                   coordinate x of current element.
     * @param y                   coordinate y of current element.
     * @param symbol              for compare with current.
     * @param areaGame            area game
     * @return count of symbol in a row.
     */
    private int checkSymbol(DirectionOfMovementOnGameArea directionOfMovement, int x, int y, Symbol symbol, Symbol[][] areaGame) {
        int countRow = 0;
        if (y >= 0 && y < areaGame.length && x >= 0 && x < areaGame[y].length && areaGame[y][x].equals(symbol)) {
            countRow++;
            final Map<String, Integer> nextCoordinates = this.getNextCoordinates(directionOfMovement, x, y);
            countRow = countRow + this.checkSymbol(directionOfMovement, nextCoordinates.get("X"), nextCoordinates.get("Y"), symbol, areaGame);
        }
        return countRow;
    }

    /**
     * Method computes a count in a row by horizontal.
     *
     * @param x                coordinate x of current element.
     * @param y                coordinate y of current element.
     * @param symbolForCompare symbol for compare.
     * @param areaGame         array of area game.
     * @return a count in a row by horizontal.
     */
    protected int getCountInRowByHorizontal(int x, int y, Symbol symbolForCompare, Symbol[][] areaGame) {
        final Map<String, Integer> nextCoordinatesLeft = this.getNextCoordinates(DirectionOfMovementOnGameArea.HORIZONTAL_LEFT, x, y);
        final Map<String, Integer> nextCoordinatesRight = this.getNextCoordinates(DirectionOfMovementOnGameArea.HORIZONTAL_RIGHT, x, y);
        final int countRow = this.checkSymbol(DirectionOfMovementOnGameArea.HORIZONTAL_LEFT, nextCoordinatesLeft.get("X"), nextCoordinatesLeft.get("Y"),
                symbolForCompare, areaGame)
                + this.checkSymbol(DirectionOfMovementOnGameArea.HORIZONTAL_RIGHT, nextCoordinatesRight.get("X"), nextCoordinatesRight.get("Y"),
                symbolForCompare, areaGame);

        return countRow;
    }

    /**
     * Method computes a count in a row by vertical.
     *
     * @param x                coordinate x of current element.
     * @param y                coordinate y of current element.
     * @param symbolForCompare symbol for compare.
     * @param areaGame         array of area game.
     * @return a count in a row by vertical.
     */
    protected int getCountInRowByVertical(int x, int y, Symbol symbolForCompare, Symbol[][] areaGame) {
        final Map<String, Integer> nextCoordinatesUp = this.getNextCoordinates(DirectionOfMovementOnGameArea.VERTICAL_UP, x, y);
        final Map<String, Integer> nextCoordinatesDown = this.getNextCoordinates(DirectionOfMovementOnGameArea.VERTICAL_DOWN, x, y);
        final int countRow = this.checkSymbol(DirectionOfMovementOnGameArea.VERTICAL_UP, nextCoordinatesUp.get("X"), nextCoordinatesUp.get("Y"),
                symbolForCompare, areaGame)
                + this.checkSymbol(DirectionOfMovementOnGameArea.VERTICAL_DOWN, nextCoordinatesDown.get("X"), nextCoordinatesDown.get("Y"),
                symbolForCompare, areaGame);

        return countRow;
    }

    /**
     * Method computes a count in a row by diagonal from left to right.
     *
     * @param x                coordinate x of current element.
     * @param y                coordinate y of current element.
     * @param symbolForCompare symbol for compare.
     * @param areaGame         array of area game.
     * @return a count in a row by diagonal from left to right.
     */
    protected int getCountInRowByDiagonalFromLeftToRight(int x, int y, Symbol symbolForCompare, Symbol[][] areaGame) {
        final Map<String, Integer> nextCoordinatesUpLeft = this.getNextCoordinates(DirectionOfMovementOnGameArea.DIAGONAL_UP_LEFT, x, y);
        final Map<String, Integer> nextCoordinatesDownRight = this.getNextCoordinates(DirectionOfMovementOnGameArea.DIAGONAL_DOWN_RIGHT, x, y);
        final int countRow = this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_UP_LEFT, nextCoordinatesUpLeft.get("X"), nextCoordinatesUpLeft.get("Y"),
                symbolForCompare, areaGame)
                + this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_DOWN_RIGHT, nextCoordinatesDownRight.get("X"), nextCoordinatesDownRight.get("Y"),
                symbolForCompare, areaGame);
        return countRow;
    }

    /**
     * Method computes a count in a row by diagonal from right to left.
     *
     * @param x                coordinate x of current element.
     * @param y                coordinate y of current element.
     * @param symbolForCompare symbol for compare.
     * @param areaGame         array of area game.
     * @return a count in a row by diagonal from right to left.
     */
    protected int getCountInRowByDiagonalFromRightToLeft(int x, int y, Symbol symbolForCompare, Symbol[][] areaGame) {
        final Map<String, Integer> nextCoordinatesUpRight = this.getNextCoordinates(DirectionOfMovementOnGameArea.DIAGONAL_UP_RIGHT, x, y);
        final Map<String, Integer> nextCoordinatesDownLeft = this.getNextCoordinates(DirectionOfMovementOnGameArea.DIAGONAL_DOWN_LEFT, x, y);
        final int countRow = this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_UP_RIGHT, nextCoordinatesUpRight.get("X"), nextCoordinatesUpRight.get("Y"),
                symbolForCompare, areaGame)
                + this.checkSymbol(DirectionOfMovementOnGameArea.DIAGONAL_DOWN_LEFT, nextCoordinatesDownLeft.get("X"), nextCoordinatesDownLeft.get("Y"),
                symbolForCompare, areaGame);
        return countRow;
    }

    /**
     * Getter for field "countForWin".
     *
     * @return value of field "countForWin".
     */
    public int getCountForWin() {
        return this.countForWin;
    }
}
