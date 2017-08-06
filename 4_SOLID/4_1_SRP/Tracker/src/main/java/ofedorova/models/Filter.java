package ofedorova.models;

/**
 * The class uses for finding items by filter.
 *
 * @author Olga Fedorova
 * @version 1
 * @since 18.08.2016
 */
public abstract class Filter {

    /**
     * Value for searching.
     */
    private String value;

    /**
     * Allocates a new {@code Filter}.
     *
     * @param value - uses for searching.
     */
    public Filter(String value) {
        this.value = value;
    }

    /**
     * The method finds items to using the field "Value".
     *
     * @param items - array for searching.
     * @return array of items.
     */
    public abstract Item[] find(Item[] items);

    /**
     * Getter for field "value".
     *
     * @return value of field "value".
     */
    public String getValue() {
        return this.value;
    }

}
