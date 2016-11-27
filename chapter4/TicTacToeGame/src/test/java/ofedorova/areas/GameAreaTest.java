package ofedorova.areas;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

/**
 * Class for testing class "GameArea".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 22.11.2016
 */
public class GameAreaTest {
    /**
     * Object of game area.
     */
    private GameArea gameArea;

    /**
     * Method initilize first state of game area.
     */
    @Before
    public void init() {
        final int size = 5;
        final int countForWin = 3;
        this.gameArea = new GameArea(size);
    }

    /**
     * Expect exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Method for testing when expect exception for x coordinate.
     *
     * @throws GameAreaCoordinateOutOfBoundsException when coordinate is out of bounds game area.
     * @throws GameAreaCellNotEmptyException          when cell of game area is not empty.
     */
    @Test
    public void whenAddSymbolAndCoordinateXOutOfBounds() throws GameAreaCoordinateOutOfBoundsException, GameAreaCellNotEmptyException {
        exception.expect(GameAreaCoordinateOutOfBoundsException.class);
        final int x = 5;
        final int y = 4;
        this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
    }

    /**
     * Method for testing when expect exception for y coordinate.
     *
     * @throws GameAreaCoordinateOutOfBoundsException when coordinate is out of bounds game area.
     * @throws GameAreaCellNotEmptyException          when cell of game area is not empty.
     */
    @Test
    public void whenAddSymbolAndCoordinateYOutOfBounds() throws GameAreaCoordinateOutOfBoundsException, GameAreaCellNotEmptyException {
        exception.expect(GameAreaCoordinateOutOfBoundsException.class);
        final int x = 4;
        final int y = 5;
        this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
    }

    /**
     * Method for testing when expect exception for cell isn't empty.
     *
     * @throws GameAreaCoordinateOutOfBoundsException when coordinate is out of bounds game area.
     * @throws GameAreaCellNotEmptyException          when cell of game area is not empty.
     */
    @Test
    public void whenAddSymbolAndCellNotEmpty() throws GameAreaCoordinateOutOfBoundsException, GameAreaCellNotEmptyException {
        final int x = 3;
        final int y = 3;
        this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        exception.expect(GameAreaCellNotEmptyException.class);
        this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
    }

    /**
     * Method for testing getter for field "area".
     */
    @Test
    public void whenGetArea() {
        final int size = 5;
        final Symbol[][] symbols = new Symbol[size][size];
        for (int y = 0; y < symbols.length; y++) {
            for (int x = 0; x < symbols[y].length; x++) {
                symbols[y][x] = Symbol.SYMBOL_NULL;
            }
        }
        assertArrayEquals(this.gameArea.getArea(), symbols);
    }

}