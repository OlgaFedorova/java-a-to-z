package ofedorova.areas;

/**
 * Enum implements model of symbol game area.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 22.11.2016
 */
public enum Symbol {
    /**
     * Element X.
     */
    SYMBOL_X("X"),
    /**
     * Element O.
     */
    SYMBOL_O("O"),
    /**
     * Null-element.
     */
    SYMBOL_NULL("_");

    /**
     * Value of current element.
     */
    private final String value;

    /**
     * Allocates a new {@code Symbol}.
     *
     * @param value of current element.
     */
    Symbol(String value) {
        this.value = value;
    }

    /**
     * Returns a {@code Symbol} object representing.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return this.value;
    }
}
