package ofedorova.models;

/**
 * The class uses for finding items by filter with field "description".
 *
 * @author Olga Fedorova
 * @version 1
 * @since 18.08.2016
 */
class FilterByDescription extends Filter {

    /**
     * Allocates a new {@code FilterByDescription}.
     *
     * @param value - uses for searching.
     */
    FilterByDescription(String value) {
        super(value);
    }

    /**
     * The method finds items to using the field "Value" by the field "Description" of the class "Item".
     *
     * @param items - array for searching.
     * @return array of items.
     */
    @Override
    public Item[] find(Item[] items) {
        Item[] temp = new Item[items.length];
        int position = 0;

        for (Item item : items) {
            if (item.getDescription().contains(this.getValue())) {
                temp[position++] = item;
            }
        }

        Item[] result = new Item[position];
        System.arraycopy(temp, 0, result, 0, position);
        return result;
    }

}
