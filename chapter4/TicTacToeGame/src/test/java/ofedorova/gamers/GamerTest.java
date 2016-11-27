package ofedorova.gamers;

import ofedorova.areas.Symbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Class for testing class "Gamer".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 26.11.2016
 */
public class GamerTest {
    /**
     * Name of gamer.
     */
    private final String name = "User";
    /**
     * Object for testing method of class "Gamer".
     */
    private final Gamer gamer = new User(this.name, Symbol.SYMBOL_X);

    /**
     * Method tests getter for field "symbol".
     */
    @Test
    public void whenGetSymbol() {
        final Symbol expectedSymbol = Symbol.SYMBOL_X;
        final Symbol actualSymbol = this.gamer.getSymbol();

        assertEquals(expectedSymbol, actualSymbol);
    }

    /**
     * Method for testing object representing.
     */
    @Test
    public void whenToString() {
        final String expected = "Gamer{name='User', symbol=X}";
        final String actual = this.gamer.toString();

        assertEquals(expected, actual);
    }

    /**
     * Method for checking equals two gamers, when gamers is equals.
     */
    @Test
    public void whenEquals() {
        final Gamer gamerforCompare = new User("User", Symbol.SYMBOL_X);
        assertTrue(this.gamer.equals(gamerforCompare));
    }

    /**
     * Method for checking equals two gamers, when gamers is with equals name and they is not equals symbol.
     */
    @Test
    public void whenNotEqualsWithEqualsName() {
        final Gamer gamerforCompare = new User("User", Symbol.SYMBOL_O);
        assertFalse(this.gamer.equals(gamerforCompare));
    }

    /**
     * Method for checking equals two gamers, when gamers is with equals symbol and they is not equals name.
     */
    @Test
    public void whenNotEqualsWithEqualsSymbol() {
        final Gamer gamerforCompare = new User("User1", Symbol.SYMBOL_X);
        assertFalse(this.gamer.equals(gamerforCompare));
    }

    /**
     * Method for checking equals two gamers, when gamers is not with equals symbol and they is not equals name.
     */
    @Test
    public void whenNotEquals() {
        final Gamer gamerforCompare = new User("User1", Symbol.SYMBOL_O);
        assertFalse(this.gamer.equals(gamerforCompare));
    }

    /**
     * Method for testing hash code value for the object.
     */
    @Test
    public void whenGetHashCode() {
        final int multiplier = 31;
        final int expected = multiplier * this.name.hashCode() + this.gamer.getSymbol().hashCode();
        final int actual = this.gamer.hashCode();

        assertEquals(expected, actual);
    }
}