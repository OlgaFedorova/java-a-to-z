package ofedorova.businesslogic;

import ofedorova.areas.GameArea;
import ofedorova.areas.GameAreaCellNotEmptyException;
import ofedorova.areas.GameAreaCoordinateOutOfBoundsException;
import ofedorova.areas.Symbol;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Class for testing class "AlgoritmForDetermineWinner".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.11.2016
 */
public class AlgoritmForDetermineWinnerTest {
    /**
     * Object of game area.
     */
    private GameArea gameArea;
    /**
     * Object of algoritms game.
     */
    private AlgoritmForDetermineWinner algoritmsGame;

    /**
     * Method initilize first state of game area.
     */
    @Before
    public void init() {
        final int size = 7;
        final int countForWin = 3;
        this.gameArea = new GameArea(size);
        this.algoritmsGame = new AlgoritmForDetermineWinner(countForWin);
    }

    /**
     * Method for testing when count of symbol is eguals count for win in vertical.
     */
    @Test
    public void whenLineIsFullByVerticalForWin() {
        final int x = 2;
        final int y0 = 0;
        final int y1 = 1;
        final int y2 = 2;
        final int y3 = 3;
        final int y4 = 4;
        try {
            this.gameArea.addSymbol(x, y0, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x, y2, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x, y3, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x, y4, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertTrue(this.algoritmsGame.lineIsFullByVerticalForWin(x, y2, this.gameArea.getArea()));
    }

    /**
     * Method for testing when count of symbol isn't eguals count for win in vertical.
     */
    @Test
    public void whenLineIsNotFullByVerticalForWin() {
        final int x = 2;
        final int y0 = 0;
        final int y1 = 1;
        final int y2 = 2;
        final int y3 = 3;
        final int y4 = 4;
        try {
            this.gameArea.addSymbol(x, y0, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x, y1, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x, y2, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x, y3, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x, y4, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertFalse(this.algoritmsGame.lineIsFullByVerticalForWin(x, y2, this.gameArea.getArea()));
    }

    /**
     * Method for testing when count of symbol is eguals count for win in horizontal.
     */
    @Test
    public void whenLineIsFullByHorizontalForWin() {
        final int y = 2;
        final int x0 = 0;
        final int x1 = 1;
        final int x2 = 2;
        final int x3 = 3;
        final int x4 = 4;
        try {
            this.gameArea.addSymbol(x0, y, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x1, y, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x3, y, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x4, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertTrue(this.algoritmsGame.lineIsFullByHorizontalForWin(x3, y, this.gameArea.getArea()));
    }

    /**
     * Method for testing when count of symbol isn't eguals count for win in horizontal.
     */
    @Test
    public void whenLineIsNotFullByHorizontalForWin() {
        final int y = 2;
        final int x0 = 0;
        final int x1 = 1;
        final int x2 = 2;
        final int x3 = 3;
        final int x4 = 4;
        try {
            this.gameArea.addSymbol(x0, y, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x1, y, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x2, y, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x3, y, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x4, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertFalse(this.algoritmsGame.lineIsFullByHorizontalForWin(x3, y, this.gameArea.getArea()));
    }

    /**
     * Method for testing when count of symbol is eguals count for win in diagonal.
     * Coordinate X of current element more y.
     */
    @Test
    public void whenLineIsFullByDioganalForWinXMoreY() {
        final int x0 = 2;
        final int y0 = 0;
        final int x1 = 3;
        final int y1 = 1;
        final int x2 = 4;
        final int y2 = 2;
        final int x3 = 5;
        final int y3 = 3;
        final int x4 = 6;
        final int y4 = 4;
        try {
            this.gameArea.addSymbol(x0, y0, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x3, y3, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x4, y4, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertTrue(this.algoritmsGame.lineIsFullByDioganalForWin(x2, y2, this.gameArea.getArea()));
    }

    /**
     * Method for testing when count of symbol isn't eguals count for win in diagonal.
     * Coordinate X of current element more y.
     */
    @Test
    public void whenLineIsNotFullByDioganalForWinXMoreY() {
        final int x0 = 2;
        final int y0 = 0;
        final int x1 = 3;
        final int y1 = 1;
        final int x2 = 4;
        final int y2 = 2;
        final int x3 = 5;
        final int y3 = 3;
        final int x4 = 6;
        final int y4 = 4;
        try {
            this.gameArea.addSymbol(x0, y0, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x3, y3, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x4, y4, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertFalse(this.algoritmsGame.lineIsFullByDioganalForWin(x2, y2, this.gameArea.getArea()));
    }

    /**
     * Method for testing when count of symbol is eguals count for win in diagonal.
     * Coordinate X of current element less y.
     */
    @Test
    public void whenLineIsFullByDioganalForWinXLessY() {
        final int x0 = 0;
        final int y0 = 2;
        final int x1 = 1;
        final int y1 = 3;
        final int x2 = 2;
        final int y2 = 4;
        final int x3 = 3;
        final int y3 = 5;
        final int x4 = 4;
        final int y4 = 6;
        try {
            this.gameArea.addSymbol(x0, y0, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x3, y3, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x4, y4, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertTrue(this.algoritmsGame.lineIsFullByDioganalForWin(x2, y2, this.gameArea.getArea()));
    }

    /**
     * Method for testing when count of symbol isn't eguals count for win in diagonal.
     * Coordinate X of current element less y.
     */
    @Test
    public void whenLineIsNotFullByDioganalForWinXLessY() {
        final int y0 = 2;
        final int x0 = 0;
        final int y1 = 3;
        final int x1 = 1;
        final int y2 = 4;
        final int x2 = 2;
        final int y3 = 5;
        final int x3 = 3;
        final int y4 = 6;
        final int x4 = 4;
        try {
            this.gameArea.addSymbol(x0, y0, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x3, y3, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x4, y4, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        assertFalse(this.algoritmsGame.lineIsFullByDioganalForWin(x2, y2, this.gameArea.getArea()));
    }
}