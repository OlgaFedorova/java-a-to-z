package ofedorova.templates;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Olga Fedorova
 * @version 1.0
 * @since 18.11.2016
 */
public class SimpleGenerator implements Template {
    /**
     * Pattern for find substring in the text.
     */
    private static final Pattern PATTERN = Pattern.compile("\\$\\{(\\w+?)\\}");

    /**
     * The method generates a new string, replacing the substring of type "${parametr}" to the values from array.
     *
     * @param template string for replacing
     * @param data     array with values for parameters
     * @return new string
     */
    @Override
    public String generate(String template, Object[] data) {
        String result = template;
        Matcher matcher = PATTERN.matcher(result);
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
     * @throws KeyException when key is not found or the key is extra
     * @return new string
     */
    @Override
    public String generate(String template, Map<String, String> data) throws KeyException {
        String result = template;
        Matcher matcher = PATTERN.matcher(result);
        Set<String> keyFound = new HashSet<>();
        while (matcher.find()){
            if(data != null && data.containsKey(matcher.group(1))){
                result = matcher.replaceFirst(data.get(matcher.group(1)));
                keyFound.add(matcher.group(1));
                matcher.reset(result);
            }
            else{
                throw new KeyException(String.format("Not found key - %s", matcher.group(1)));
            }
        }
        if(!keyFound.equals(data.keySet())){
            throw new KeyException("There are extra keys in tha data.");
        }
        return result;
    }
}
