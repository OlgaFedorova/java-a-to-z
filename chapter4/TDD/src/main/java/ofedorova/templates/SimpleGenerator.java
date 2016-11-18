package ofedorova.templates;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Olga Fedorova
 * @version 1.0
 * @since 18.11.2016
 */
public class SimpleGenerator implements Template {
    /**
     * The method generates a new string, replacing the substring of type "${parametr}" to the values from array.
     *
     * @param template string for replacing
     * @param data     array with values for parameters
     * @return new string
     */
    @Override
    public String generate(String template, Object[] data) {
        final String regx = "\\$\\{\\w+?\\}";
        String result = template;
        Matcher matcher = Pattern.compile(regx).matcher(result);
        int index = 0;

        while (matcher.find()) {
            if (data != null && index < data.length) {
                result = matcher.replaceFirst((String) data[index++]);
                matcher.reset(result);
            }
        }
        return result;
    }

    /**
     * The method generates a new string, replacing the substring of type "${key}" to the values of keys from structure.
     *
     * @param template string for replacing
     * @param data     structure with keys and values
     * @return new string
     */
    @Override
    public String generate(String template, Map<String, String> data) {
        String result = template;
        if (data != null) {
            for (Map.Entry<String, String> record : data.entrySet()) {
                Matcher matcher = Pattern.compile(String.format("\\$\\{%s\\}", record.getKey())).matcher(result);
                result = matcher.replaceAll(record.getValue());
            }
        }
        return result;
    }
}
