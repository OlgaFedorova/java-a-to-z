package ofedorova.templates;

import java.util.Map;

/**
 * @author Olga Fedorova
 * @version 1.0
 * @since 18.11.2016
 */
public interface Template {

    /**
     * The method generates a new string, replacing the substring of type "${parametr}" to the values from array.
     *
     * @param template string for replacing
     * @param data     array with values for parameters
     * @return new string
     */
    String generate(String template, Object[] data);

    /**
     * The method generates a new string, replacing the substring of type "${key}" to the values of keys from structure.
     *
     * @param template string for replacing
     * @param data     structure with keys and values
     * @return new string
     * @throws KeyException when key is not found or the key is extra
     */
    String generate(String template, Map<String, String> data) throws KeyException;

}
