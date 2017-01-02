package ofedorova;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing class "TicTacToe".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 01.12.2016
 */
public class TicTacToeTest {
    /**
     * Size of game field.
     */
    private final int size = 7;
    /**
     * Count of symbol a row for win.
     */
    private final int countForWin = 3;
    /**
     * Game field.
     */
    private int[][] field;
    /**
     * Symbol X.
     */
    private final int symbolX = 1;
    /**
     * Symbol O.
     */
    private final int symbolO = 2;

    /**
     * Method initilize first state for runnig tests.
     */
    @Before
    public void initilize() {
        this.field = new int[this.size][this.size];
    }

    /**
     * Method tests when has winner on diagonal with coordinates from (x = 0; y =0) to ( x = 6; y = 6).
     */
    @Test
    public void whenHasWinnerOnDioganalFromX0Y0ToX6Y6() {
        int x = 0;
        int y = 0;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on diagonal with coordinates from (x = 0; y = 3) to ( x = 3; y = 6).
     */
    @Test
    public void whenHasWinnerOnDioganalFromX0Y3ToX3Y6() {
        final int xStart = 0;
        final int yStart = 3;
        int x = xStart;
        int y = yStart;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on diagonal with coordinates from (x = 3; y = 0) to ( x = 6; y = 3).
     */
    @Test
    public void whenHasWinnerOnDioganalFromX3Y0ToX6Y3() {
        final int xStart = 3;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on diagonal with coordinates from (x = 6; y = 0) to ( x = 0; y = 6).
     */
    @Test
    public void whenHasWinnerOnDioganalFromX6Y0ToX0Y6() {
        final int xStart = 4;
        final int yStart = 2;
        int x = xStart;
        int y = yStart;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on diagonal with coordinates from (x = 3; y = 0) to ( x = 0; y = 3).
     */
    @Test
    public void whenHasWinnerOnDioganalFromX3Y0ToX0Y3() {
        final int xStart = 3;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on diagonal with coordinates from (x = 6; y = 2) to ( x = 2; y = 6).
     */
    @Test
    public void whenHasWinnerOnDioganalFromX6Y2ToX2Y6() {
        final int xStart = 6;
        final int yStart = 2;
        int x = xStart;
        int y = yStart;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on horizontal with coordinates from (x = 0; y = 0) to ( x = 6; y = 0).
     */
    @Test
    public void whenHasWinnerOnHorizontalFromX0Y0ToX6Y0() {
        final int xStart = 0;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on horizontal with coordinates from (x = 0; y = 6) to ( x = 6; y = 6).
     */
    @Test
    public void whenHasWinnerOnHorizontalFromX0Y6ToX6Y6() {
        final int xStart = 0;
        final int yStart = 6;
        int x = xStart;
        int y = yStart;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on horizontal with coordinates from (x = 0; y = 4) to ( x = 6; y = 4).
     */
    @Test
    public void whenHasWinnerOnHorizontalFromX0Y4ToX6Y4() {
        final int xStart = 2;
        final int yStart = 4;
        int x = xStart;
        int y = yStart;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on vertical with coordinates from (x = 0; y = 0) to ( x = 0; y = 6).
     */
    @Test
    public void whenHasWinnerOnVerticalFromX0Y0ToX0Y6() {
        final int xStart = 0;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on vertical with coordinates from (x = 6; y = 0) to ( x = 6; y = 6).
     */
    @Test
    public void whenHasWinnerOnVerticalFromX6Y0ToX6Y6() {
        final int xStart = 6;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when has winner on vertical with coordinates from (x = 4; y = 0) to ( x = 4; y = 6).
     */
    @Test
    public void whenHasWinnerOnVerticalFromX4Y0ToX4Y6() {
        final int xStart = 4;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on diagonal with coordinates from (x = 0; y =0) to ( x = 6; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnDioganalFromX0Y0ToX6Y6() {
        final int xStart = 0;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on diagonal with coordinates from (x = 0; y = 3) to ( x = 3; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnDioganalFromX0Y3ToX3Y6() {
        final int xStart = 0;
        final int yStart = 3;
        int x = xStart;
        int y = yStart;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on diagonal with coordinates from (x = 3; y = 0) to ( x = 6; y = 3).
     */
    @Test
    public void whenHasNotWinnerOnDioganalFromX3Y0ToX6Y3() {
        final int xStart = 3;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolO;
        this.field[y++][x++] = this.symbolX;
        this.field[y++][x++] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on diagonal with coordinates from (x = 6; y = 0) to ( x = 0; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnDioganalFromX6Y0ToX0Y6() {
        final int xStart = 4;
        final int yStart = 2;
        int x = xStart;
        int y = yStart;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on diagonal with coordinates from (x = 3; y = 0) to ( x = 0; y = 3).
     */
    @Test
    public void whenHasNotWinnerOnDioganalFromX3Y0ToX0Y3() {
        final int xStart = 3;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on diagonal with coordinates from (x = 6; y = 2) to ( x = 2; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnDioganalFromX6Y2ToX2Y6() {
        final int xStart = 6;
        final int yStart = 2;
        int x = xStart;
        int y = yStart;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        this.field[y++][x--] = this.symbolX;
        this.field[y++][x--] = this.symbolO;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on horizontal with coordinates from (x = 0; y = 0) to ( x = 6; y = 0).
     */
    @Test
    public void whenHasNotWinnerOnHorizontalFromX0Y0ToX6Y0() {
        final int xStart = 0;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on horizontal with coordinates from (x = 0; y = 6) to ( x = 6; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnHorizontalFromX0Y6ToX6Y6() {
        final int xStart = 0;
        final int yStart = 6;
        int x = xStart;
        int y = yStart;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on horizontal with coordinates from (x = 0; y = 4) to ( x = 6; y = 4).
     */
    @Test
    public void whenHasNotWinnerOnHorizontalFromX0Y4ToX6Y4() {
        final int xStart = 2;
        final int yStart = 4;
        int x = xStart;
        int y = yStart;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        this.field[y][x++] = this.symbolO;
        this.field[y][x++] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on vertical with coordinates from (x = 0; y = 0) to ( x = 0; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnVerticalFromX0Y0ToX0Y6() {
        final int xStart = 0;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on vertical with coordinates from (x = 6; y = 0) to ( x = 6; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnVerticalFromX6Y0ToX6Y6() {
        final int xStart = 6;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

    /**
     * Method tests when hasn't winner on vertical with coordinates from (x = 4; y = 0) to ( x = 4; y = 6).
     */
    @Test
    public void whenHasNotWinnerOnVerticalFromX4Y0ToX4Y6() {
        final int xStart = 4;
        final int yStart = 0;
        int x = xStart;
        int y = yStart;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        this.field[y++][x] = this.symbolO;
        this.field[y++][x] = this.symbolX;
        final TicTacToe ticTacToe = new TicTacToe(field, this.countForWin);

        assertFalse(ticTacToe.hasWinner());
    }

}