package ofedorova.interfaces;


import ofedorova.areas.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class implements console interface.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.11.2016
 */
public class ConsoleUserInterface implements UserInterface {
    /**
     * Object for work with console.
     */
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Method print info in interface.
     *
     * @param message info for orinting.
     */
    @Override
    public void printInfo(String message) {
        System.out.println(message);
    }

    /**
     * Method input data from interface.
     *
     * @return input data.
     * @throws IOException exception with work input data.
     */
    @Override
    public String input() throws IOException {
        return reader.readLine();
    }

    /**
     * Method updates info about current state of area game.
     *
     * @param areaGame area game.
     */
    @Override
    public void showAreaGame(Symbol[][] areaGame) {
        for (int y = 0; y < areaGame.length; y++) {
            if (y == 0) {
                System.out.print("  ");
                for (int x = 0; x < areaGame[y].length; x++) {
                    System.out.printf("%2d", x);
                }
                System.out.println();
            }
            for (int x = 0; x < areaGame[y].length; x++) {
                if (x == 0) {
                    System.out.printf("%2d", y);
                }
                System.out.print("|");
                System.out.print(areaGame[y][x]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

}
