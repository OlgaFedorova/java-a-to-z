package ofedorova;

import ofedorova.interfaces.ConsoleUserInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing class "TicTacToe".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 28.11.2016
 */
public class TicTacToeTest {
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
        in = new FileInputStream("src/test/java/ofedorova/InputConsoleUserInterface.txt");
        out = new PrintStream(new FileOutputStream("src/test/java/ofedorova/OutputConsoleUserInterface.txt"));
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
     * Method for testing start game.
     *
     * @throws IOException exception will be when work with stream.
     */
    @Test
    public void whenStartGame() throws IOException {
        new TicTacToe(new ConsoleUserInterface()).startGame();
        final BasicTestTicTacToe basicTestTicTacToe = new BasicTestTicTacToe();
        final String expected = basicTestTicTacToe.getOuputConsoleString();
        final String actual = basicTestTicTacToe.getStingInFileOutputConsoleUserInterface();

        assertEquals(expected, actual);
    }

}