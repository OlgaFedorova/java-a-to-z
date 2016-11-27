package ofedorova.businesslogic;

import ofedorova.areas.Symbol;

/**
 * Class consists algoritms for determine winner.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.11.2016
 */
public class AlgoritmForDetermineWinner extends AlgoritmsGame {
    /**
     * Allocates a new {@code AlgoritmsGame}.
     *
     * @param countForWin count a row for win
     */
    public AlgoritmForDetermineWinner(int countForWin) {
        super(countForWin);
    }

    /**
     * Method checks that count of symbol in vertical equals to count for win.
     *
     * @param x        coordinate x of current element.
     * @param y        coordinate y of current element.
     * @param areaGame array of area game.
     * @return if count of symbol in vertical equals to count for win return true, else false.
     */
    public boolean lineIsFullByVerticalForWin(int x, int y, Symbol[][] areaGame) {
        int countRow = 1;
        if (areaGame != null) {
            countRow = countRow + this.getCountInRowByVertical(x, y, areaGame[y][x], areaGame);
        }
        return countRow == this.getCountForWin();
    }

    /**
     * Method checks that count of symbol in horizontal equals to count for win.
     *
     * @param x        coordinate x of current element.
     * @param y        coordinate y of current element.
     * @param areaGame array of area game.
     * @return if count of symbol in horizontal equals to count for win return true, else false.
     */
    public boolean lineIsFullByHorizontalForWin(int x, int y, Symbol[][] areaGame) {
        int countRow = 1;
        if (areaGame != null) {
            countRow = countRow + this.getCountInRowByHorizontal(x, y, areaGame[y][x], areaGame);
        }
        return countRow == this.getCountForWin();
    }

    /**
     * Method checks that count of symbol in diagonal equals to count for win.
     *
     * @param x        coordinate x of current element.
     * @param y        coordinate y of current element.
     * @param areaGame array of area game.
     * @return if count of symbol in diagonal equals to count for win return true, else false.
     */
    public boolean lineIsFullByDioganalForWin(int x, int y, Symbol[][] areaGame) {
        int countRowByDiagonalLeftRight = 1;
        int countRowByDiagonalRightLeft = 1;
        if (areaGame != null) {
            countRowByDiagonalLeftRight = countRowByDiagonalLeftRight + this.getCountInRowByDiagonalFromLeftToRight(x, y, areaGame[y][x], areaGame);
            countRowByDiagonalRightLeft = countRowByDiagonalRightLeft + this.getCountInRowByDiagonalFromRightToLeft(x, y, areaGame[y][x], areaGame);
        }
        return countRowByDiagonalLeftRight == this.getCountForWin() || countRowByDiagonalRightLeft == this.getCountForWin();
    }
}
