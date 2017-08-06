package ofedorova.gamers;

import ofedorova.areas.Symbol;
import ofedorova.interfaces.UserInterface;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing class "User".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 26.11.2016
 */
public class UserTest {
    /**
     * Object for work with user gamer.
     */
    private final User user = new User("User", Symbol.SYMBOL_X);
    /**
     * Object for work with user interface.
     */
    private final UserInterface userInterface = new UserInterface() {
        /**
         * Data for input.
         */
        private final String[] data = {"3", "4"};
        /**
         * Index for next input data.
         */
        private int index = 0;

        /**
         * Method print info in interface.
         *
         * @param message info for orinting.
         */
        @Override
        public void printInfo(String message) {
        }

        /**
         * Method input data from interface.
         *
         * @return input data.
         * @throws IOException exception with work input data.
         */
        @Override
        public String input() throws IOException {
            return this.data[index++];
        }

        /**
         * Method updates info about current state of area game.
         *
         * @param areaGame area game.
         */
        @Override
        public void showAreaGame(Symbol[][] areaGame) {
        }
    };

    /**
     * Method tests moving user gamer.
     */
    @Test
    public void whenDoStep() {
        final int x = 3;
        final int y = 4;
        final Map<String, Integer> expectCoordinates = new HashMap<>();
        expectCoordinates.put("X", x);
        expectCoordinates.put("Y", y);

        final int countForWin = 3;
        final Map<String, Integer> actualCoordinates = this.user.doStep(this.userInterface);
        assertEquals(expectCoordinates, actualCoordinates);
    }
}