package ofedorova;

import java.util.Arrays;

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
        final int[][] src = Arrays.copyOf(field, field.length);
        this.field = src;
        this.countForWinner = countForWinner;
    }

    /**
     * Method compares current symbol with next symbol and returns count of symbol in a row.
     *
     * @param x        coordinate x of current element.
     * @param y        coordinate y of current element.
     * @param stepX    step to moving for coordinate X.
     * @param stepY    step to moving for coordinate Y.
     * @param countRow count of symbol in a row.
     * @return if count a row equals count for win returns true, else return false.
     */
    private boolean checkCountForWin(int x, int y, int stepX, int stepY, int countRow) {
        boolean isCountForWin = false;
        final int xNext = x + stepX;
        final int yNext = y + stepY;
        if (yNext >= 0 && yNext < this.field.length
                && xNext >= 0 && xNext < this.field[yNext].length
                && this.field[y][x] != 0 && this.field[y][x] == this.field[yNext][xNext]) {
            countRow++;
            if (countRow == this.countForWinner) {
                isCountForWin = true;
            } else {
                isCountForWin = this.checkCountForWin(xNext, yNext, stepX, stepY, countRow);
            }
        }
        return isCountForWin;
    }

    /**
     * Method checks has winner or not.
     *
     * @return if has winner return true, else return false.
     */
    public boolean hasWinner() {
        boolean hasWinner = false;
        final int countARow = 1;
        for (int y = 0; y < this.field.length; y++) {
            for (int x = 0; x < this.field[y].length; x++) {
                hasWinner = this.checkCountForWin(x, y, 0, 1, countARow)
                        || this.checkCountForWin(x, y, 1, 0, countARow)
                        || this.checkCountForWin(x, y, 1, 1, countARow)
                        || this.checkCountForWin(x, y, 1, -1, countARow);
                if (hasWinner) {
                    break;
                }
            }
            if (hasWinner) {
                break;
            }
        }
        return hasWinner;
    }
}
