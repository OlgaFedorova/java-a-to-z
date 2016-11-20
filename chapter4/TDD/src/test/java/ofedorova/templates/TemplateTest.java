package ofedorova.templates;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

/**
 * @author Olga Fedorova
 * @version 1.0
 * @since 18.11.2016
 */
public class TemplateTest {

    /**
     * The method of testing when take text with a single parameter
     * and returns a text with the replacing parameter from data.
     */
    @Test
    public void whenTakeTextWithDataLenghtOneShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "Hello, ${name}.";
        final String[] data = new String[]{"Olga"};
        final String checked = "Hello, Olga.";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some parameter
     * and returns a text with the replacing parameter from data.
     */
    @Test
    public void whenTakeTextWithDataLenghtTwoShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final String[] data = new String[]{"Olga", "you"};
        final String checked = "I am Olga, Who are you?";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some parameter, value of data is null
     * and returns source text.
     */
    @Test
    public void whenTakeTextWithDataNullShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "Hello, ${name}.";
        final String[] data = null;
        final String checked = "Hello, ${name}.";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some parameter, values in data is extra
     * and returns a text with the replacing parameter from part of data.
     */
    @Test
    public void whenTakeTextWithExtraDataShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "Hello, ${name}.";
        final String[] data = new String[]{"Olga", "Ivan"};
        final String checked = "Hello, Olga.";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some parameter, data is empty
     * and returns source text.
     */
    @Test
    public void whenTakeTextWithEmptyDataShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "Hello, ${name}.";
        final String[] data = new String[]{};
        final String checked = "Hello, ${name}.";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with a single key and returns a text with the replacing key from data.
     */
    @Test
    public void whenTakeTextWithByKeyLenghtOneShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final Map<String, String> data = new HashMap<>();
        data.put("name", "Olga");
        data.put("subject", "you");
        final String checked = "I am Olga, Who are you?";
        String result = null;
        try {
            result = template.generate(text, data);
        } catch (KeyException e) {
            e.printStackTrace();
        }

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with a single repeat key and returns a text with the replacing key from data.
     */
    @Test
    public void whenTakeTextWithByOneRepeatKeyShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = " Help, ${sos}, ${sos}, ${sos}";
        final Map<String, String> data = new HashMap<>();
        data.put("sos", "Aaa");
        final String checked = " Help, Aaa, Aaa, Aaa";
        String result = null;
        try {
            result = template.generate(text, data);
        } catch (KeyException e) {
            e.printStackTrace();
        }

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some keys and returns a text with the replacing keys from data.
     */
    @Test
    public void whenTakeTextWithByKeyLenghtTwoShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}? I am ${name}, Who are ${subject}?";
        final Map<String, String> data = new HashMap<>();
        data.put("name", "Olga");
        data.put("subject", "you");
        final String checked = "I am Olga, Who are you? I am Olga, Who are you?";
        String result = null;
        try {
            result = template.generate(text, data);
        } catch (KeyException e) {
            e.printStackTrace();
        }

        Assert.assertThat(result, is(checked));
    }

    /**
     * Expected exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * The method of testing when take text with some keys, data is null and returns exception.
     * @throws KeyException when key is not found or the key is extra
     */
    @Test
    public void whenTakeTextWithByKeyNullShouldReplaceParamsToData() throws KeyException {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final Map<String, String> data = null;
        exception.expect(KeyException.class);
        String result = template.generate(text, data);
    }

    /**
     * The method of testing when take text with some keys, values in data is extra
     * and returns exception.
     * @throws KeyException when key is not found or the key is extra
     */
    @Test
    public void whenTakeTextWithByExtraKeyShouldReplaceParamsToData() throws KeyException {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final Map<String, String> data = new HashMap<>();
        data.put("name", "Olga");
        data.put("subject", "you");
        data.put("name2", "Olga");
        data.put("subject2", "you");
        exception.expect(KeyException.class);
        String result = template.generate(text, data);
    }

    /**
     * The method of testing when take text with some keys, values in data is less then count of keys in the text.
     * Returns exception.
     * @throws KeyException when key is not found or the key is extra
     */
    @Test
    public void whenTakeTextWithByFewKeyShouldReplaceParamsToData() throws KeyException {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final Map<String, String> data = new HashMap<>();
        data.put("name", "Olga");
        exception.expect(KeyException.class);
        String result = template.generate(text, data);
    }

}