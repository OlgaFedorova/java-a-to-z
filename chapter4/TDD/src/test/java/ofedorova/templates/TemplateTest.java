package ofedorova.templates;

import org.junit.Assert;
import org.junit.Test;

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
        final String result = template.generate(text, data);

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
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some keys, data is null and returns source text.
     */
    @Test
    public void whenTakeTextWithByKeyNullShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final Map<String, String> data = null;
        final String checked = "I am ${name}, Who are ${subject}?";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some keys, values in data is extra
     * and returns a text with the replacing keys from part of data.
     */
    @Test
    public void whenTakeTextWithByExtraKeyShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final Map<String, String> data = new HashMap<>();
        data.put("name", "Olga");
        data.put("subject", "you");
        data.put("name2", "Olga");
        data.put("subject2", "you");
        final String checked = "I am Olga, Who are you?";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

    /**
     * The method of testing when take text with some keys, values in data is less then count of keys in the text.
     * Returns a text with the replacing part of keys from data.
     */
    @Test
    public void whenTakeTextWithByFewKeyShouldReplaceParamsToData() {
        final Template template = new SimpleGenerator();
        final String text = "I am ${name}, Who are ${subject}?";
        final Map<String, String> data = new HashMap<>();
        data.put("name", "Olga");
        final String checked = "I am Olga, Who are ${subject}?";
        final String result = template.generate(text, data);

        Assert.assertThat(result, is(checked));
    }

}