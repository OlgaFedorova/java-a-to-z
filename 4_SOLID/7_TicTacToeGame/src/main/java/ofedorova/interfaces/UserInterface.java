package ofedorova.interfaces;

import ofedorova.areas.Symbol;

import java.io.IOException;

/**
 * Interface implements model of user interface.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.11.2016
 */
public interface UserInterface {

    /**
     * Method print info in interface.
     *
     * @param message info for orinting.
     */
    void printInfo(String message);

    /**
     * Method input data from interface.
     *
     * @return input data.
     * @throws IOException exception with work input data.
     */
    String input() throws IOException;

    /**
     * Method updates info about current state of area game.
     *
     * @param areaGame area game.
     */
    void showAreaGame(Symbol[][] areaGame);

}
