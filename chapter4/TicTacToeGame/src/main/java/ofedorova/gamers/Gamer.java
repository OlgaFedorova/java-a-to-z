package ofedorova.gamers;

import ofedorova.areas.Symbol;
import ofedorova.interfaces.UserInterface;

import java.util.Map;

/**
 * Class implements model of gamer.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 23.11.2016
 */
public abstract class Gamer {
    /**
     * Name of gamer.
     */
    private final String name;
    /**
     * Symbol of gamer.
     */
    private final Symbol symbol;

    /**
     * Allocates a new {@code Gamer}.
     *
     * @param name   value of field "name".
     * @param symbol value of field ""symbol.
     */
    public Gamer(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Returns a {@code Gamer} object representing.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return "Gamer{"
                + "name='" + name + '\''
                + ", symbol=" + symbol
                + '}';
    }

    /**
     * Getter for field "symbol".
     *
     * @return value of field "symbol".
     */
    public Symbol getSymbol() {
        return this.symbol;
    }

    /**
     * Method for moving gamer.
     *
     * @param userInterface user interface for work game.
     * @return map of coordinates X and Y.
     */
    public abstract Map<String, Integer> doStep(UserInterface userInterface);

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj object to compare
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Gamer gamer = (Gamer) obj;

        if (!name.equals(gamer.name)) {
            return false;
        }
        return symbol == gamer.symbol;

    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        final int multiplier = 31;
        result = multiplier * result + symbol.hashCode();
        return result;
    }
}
