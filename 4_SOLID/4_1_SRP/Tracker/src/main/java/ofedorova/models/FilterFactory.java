package ofedorova.models;

/**
 * The class is factory for the class "Filter".
 *
 * @author Olga Fedorova
 * @version 1
 * @since 18.08.2016
 */
public class FilterFactory {

    /**
     * The method returns the filter depending on the value of parameter "key".
     *
     * @param key key for search.
     * @param value value for search.
     * @return suitable type of filter.
     */
    public Filter getFilter(String key, String value) {
        Filter filter = null;
        if ("name".equals(key)) {
            filter = new FilterByName(value);
        } else if ("description".equals(key)) {
            filter = new FilterByDescription(value);
        } else {
            throw new IllegalArgumentException("Incorrect arguments");
        }

        return filter;
    }

}
