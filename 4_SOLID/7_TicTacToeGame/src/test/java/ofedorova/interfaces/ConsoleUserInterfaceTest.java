package ofedorova.interfaces;

import ofedorova.areas.GameArea;
import ofedorova.areas.GameAreaCellNotEmptyException;
import ofedorova.areas.GameAreaCoordinateOutOfBoundsException;
import ofedorova.areas.Symbol;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing class "ConsoleUserInterface".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 26.11.2016
 */
public class ConsoleUserInterfaceTest {
    /**
     * Default values of System.in.
     */
    private final InputStream defaultIn = System.in;
    /**
     * Default values of System.out.
     */
    private final PrintStream defaultOut = System.out;
    /**
     * Object for work with condole.
     */
    private ConsoleUserInterface userInterface;
    /**
     * Object for initilize System.in.
     */
    private InputStream in;
    /**
     * Object for initilize System.out.
     */
    private PrintStream out;

    /**
     * Method initilize first state of console user interface.
     *
     * @throws IOException exception will be when open stream.
     */
    @Before
    public void initilize() throws IOException {
        in = new FileInputStream("src/test/java/ofedorova/interfaces/InputConsoleUserInterface.txt");
        out = new PrintStream(new FileOutputStream("src/test/java/ofedorova/interfaces/OutputConsoleUserInterface.txt"));
        System.setIn(in);
        System.setOut(out);
        userInterface = new ConsoleUserInterface();
    }

    /**
     * Method closes stream of field "in", "out".
     *
     * @throws IOException exception will be when close stream.
     */
    @After
    public void closeStream() throws IOException {
        in.close();
        out.close();
        System.setIn(defaultIn);
        System.setOut(defaultOut);
    }

    /**
     * Method for testing print info.
     *
     * @throws IOException exception will be when worl with stream.
     */
    @Test
    public void whenPrintInfo() throws IOException {
        final String actualString = "Info.";
        String expectedString = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/ofedorova/interfaces/OutputConsoleUserInterface.txt"));) {
            this.userInterface.printInfo(actualString);
            expectedString = reader.readLine();
        }

        assertEquals(expectedString, actualString);
    }

    /**
     * Method for testing input data.
     *
     * @throws IOException exception will be when worl with stream.
     */
    @Test
    public void whenInput() throws IOException {
        final String expectedString = "Input data.";
        final String actualString = userInterface.input();

        assertEquals(expectedString, actualString);
    }

    /**
     * Method for testing show area game.
     *
     * @throws GameAreaCoordinateOutOfBoundsException when coordinate is out of bounds game area.
     * @throws GameAreaCellNotEmptyException          when cell of game area is not empty.
     * @throws IOException                            exception will be when work with stream.
     */
    @Test
    public void showAreaGame() throws GameAreaCoordinateOutOfBoundsException, GameAreaCellNotEmptyException, IOException {
        final int size = 3;
        final GameArea gameArea = new GameArea(size);
        gameArea.addSymbol(0, 0, Symbol.SYMBOL_X);
        gameArea.addSymbol(1, 1, Symbol.SYMBOL_X);
        gameArea.addSymbol(2, 0, Symbol.SYMBOL_X);
        gameArea.addSymbol(1, 2, Symbol.SYMBOL_X);

        gameArea.addSymbol(0, 1, Symbol.SYMBOL_O);
        gameArea.addSymbol(2, 2, Symbol.SYMBOL_O);
        gameArea.addSymbol(1, 0, Symbol.SYMBOL_O);
        gameArea.addSymbol(0, 2, Symbol.SYMBOL_O);

        this.userInterface.showAreaGame(gameArea.getArea());

        final StringBuilder expectedString = new StringBuilder("   0 1 2\n");
        expectedString.append(" 0|X|O|X|\n");
        expectedString.append(" 1|O|X|_|\n");
        expectedString.append(" 2|O|X|O|");

        final StringBuilder actualString = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/java/ofedorova/interfaces/OutputConsoleUserInterface.txt"));) {
            String readString = reader.readLine();
            int index = 0;
            while (readString != null) {
                if (index != 0) {
                    actualString.append("\n");
                }
                actualString.append(readString);
                readString = reader.readLine();
                index++;
            }
        }

        assertEquals(expectedString.toString(), actualString.toString());
    }
}