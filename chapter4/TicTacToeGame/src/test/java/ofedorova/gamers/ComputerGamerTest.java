package ofedorova.gamers;

import ofedorova.areas.GameArea;
import ofedorova.areas.GameAreaCellNotEmptyException;
import ofedorova.areas.GameAreaCoordinateOutOfBoundsException;
import ofedorova.areas.Symbol;
import ofedorova.interfaces.UserInterface;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing class "ComputerGamer".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 26.11.2016
 */
public class ComputerGamerTest {
    /**
     * Object of computer-gamer for testing.
     */
    private ComputerGamer computerGamer;

    /**
     * Method initilize first state game for testing.
     *
     * @throws GameAreaCoordinateOutOfBoundsException when coordinate is out of bounds game area.
     * @throws GameAreaCellNotEmptyException          when cell of game area is not empty.
     */
    @Before
    public void initilize() throws GameAreaCoordinateOutOfBoundsException, GameAreaCellNotEmptyException {
        final int size = 5;
        final int countForWin = 3;
        final GameArea gameArea = new GameArea(size);
        computerGamer = new ComputerGamer(Symbol.SYMBOL_X, gameArea, countForWin);

        final int x = 2;
        final int y1 = 2;
        final int y2 = 3;
        final int y3 = 4;

        gameArea.addSymbol(x, y1, Symbol.SYMBOL_O);
        gameArea.addSymbol(x, y2, Symbol.SYMBOL_O);
        gameArea.addSymbol(x, y3, Symbol.SYMBOL_X);
    }

    /**
     * Method tests moving computer gamer.
     */
    @Test
    public void whenDoStep() {

        final Map<String, Integer> expected = new HashMap<>();
        final int x = 2;
        final int y = 1;
        final int weight = 2;
        final int coefficientForBlocking = 1;
        expected.put("X", x);
        expected.put("Y", y);
        expected.put("weight", weight);
        expected.put("self", coefficientForBlocking);

        final Map<String, Integer> actual = this.computerGamer.doStep(new UserInterface() {
            @Override
            public void printInfo(String message) {
            }

            @Override
            public String input() throws IOException {
                return null;
            }

            @Override
            public void showAreaGame(Symbol[][] areaGame) {
            }
        });

        assertEquals(expected, actual);
    }

}