package ofedorova.models;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The class for testing classes "Filter" and "FilterFactory".
 *
 * @author Olga Fedorova
 * @version 1
 * @since 18.08.2016
 */
public class FilterFactoryTest {

    @Test
    public void whenGetFilterByName() {
        final FilterFactory factory = new FilterFactory();
        final Filter filter = factory.getFilter("name", "name");

        final Item item1 = new Item("name1", "description1");
        final Item item2 = new Item("item2", "description2");
        final Item item3 = new Item("name3", "description3");
        final Item item4 = new Item("item4", "description4");

        final Item[] items = {item1, item2, item3, item4};
        final Item[] checked = {item1, item3};
        assertThat(filter.find(items), is(checked));
    }

    @Test
    public void whenGetFilterByDescription() {
        final FilterFactory factory = new FilterFactory();
        final Filter filter = factory.getFilter("description", "description");

        final Item item1 = new Item("name1", "description1");
        final Item item2 = new Item("item2", "infa2");
        final Item item3 = new Item("name3", "description3");
        final Item item4 = new Item("item4", "infa4");

        final Item[] items = {item1, item2, item3, item4};
        final Item[] checked = {item1, item3};
        assertThat(filter.find(items), is(checked));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void whenGetFilterExpectedIllegalArgumentException() {
        final FilterFactory factory = new FilterFactory();
        exception.expect(IllegalArgumentException.class);
        final Filter filter = factory.getFilter("field", "field");
    }
}
