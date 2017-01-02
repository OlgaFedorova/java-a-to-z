package ofedorova.gamers;

import ofedorova.areas.Symbol;
import ofedorova.interfaces.UserInterface;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implements model of user gamer.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 23.11.2016
 */
public class User extends Gamer {

    /**
     * Allocates a new {@code User}.
     *
     * @param name   value of field "name".
     * @param symbol value of field ""symbol.
     */
    public User(String name, Symbol symbol) {
        super(name, symbol);
    }

    /**
     * Method asks and returns coordinate for moving.
     *
     * @param userInterface interface for work with input.
     * @return input coordinate.
     */
    private int inputCoorinate(UserInterface userInterface) {
        boolean inputCorrect = false;
        int coordinte = -1;
        while (!inputCorrect) {
            try {
                coordinte = Integer.parseInt(userInterface.input());
                if (coordinte < 0) {
                    throw new NumberFormatException();
                }
                inputCorrect = true;
            } catch (IOException | NumberFormatException e) {
                userInterface.printInfo("Input coordinate is incorrect. Try again.");
            }
        }
        return coordinte;
    }

    /**
     * Method for moving gamer.
     *
     * @param userInterface user interface for work game.
     * @return map of coordinates X and Y.
     */
    @Override
    public Map<String, Integer> doStep(UserInterface userInterface) {
        final HashMap<String, Integer> coordinates = new HashMap<>();
        userInterface.printInfo("Input coordinate X:");
        coordinates.put("X", this.inputCoorinate(userInterface));
        userInterface.printInfo("Input coordinate Y:");
        coordinates.put("Y", this.inputCoorinate(userInterface));
        return coordinates;
    }
}
