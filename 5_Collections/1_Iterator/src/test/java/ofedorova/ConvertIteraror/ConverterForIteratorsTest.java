package ofedorova.ConvertIteraror;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing class "ConverterForIterators".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 20.12.2016
 */
public class ConverterForIteratorsTest {

    /**
     * Method tests when all iterators aren't null.
     */
    @Test
    public void whenConvert() {
        final List<Iterator<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{4, 2, 0, 4, 6, 4, 9}).iterator());
        list.add(Arrays.asList(new Integer[]{0, 9, 8, 7, 5}).iterator());
        list.add(Arrays.asList(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4}).iterator());

        final int[] expected = new int[]{4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4};
        final int[] actual = new int[21];
        final Iterator<Integer> actualIterator = new ConverterForIterators().convert(list.iterator());

        int position = 0;
        while (actualIterator.hasNext()) {
            actual[position++] = actualIterator.next();
        }

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when second iterator is null.
     */
    @Test
    public void whenConvertSecondIteratorNull() {
        final List<Iterator<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{4, 2, 0, 4, 6, 4, 9}).iterator());
        list.add(null);
        list.add(Arrays.asList(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4}).iterator());

        final int[] expected = new int[]{4, 2, 0, 4, 6, 4, 9, 1, 3, 5, 6, 7, 0, 9, 8, 4};
        final int[] actual = new int[16];
        final Iterator<Integer> actualIterator = new ConverterForIterators().convert(list.iterator());

        int position = 0;
        while (actualIterator.hasNext()) {
            actual[position++] = actualIterator.next();
        }

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when first iterator is null.
     */
    @Test
    public void whenConvertFirstIteratorNull() {
        final List<Iterator<Integer>> list = new ArrayList<>();
        list.add(null);
        list.add(Arrays.asList(new Integer[]{0, 9, 8, 7, 5}).iterator());
        list.add(Arrays.asList(new Integer[]{1, 3, 5, 6, 7, 0, 9, 8, 4}).iterator());

        final int[] expected = new int[]{0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4};
        final int[] actual = new int[14];
        final Iterator<Integer> actualIterator = new ConverterForIterators().convert(list.iterator());

        int position = 0;
        while (actualIterator.hasNext()) {
            actual[position++] = actualIterator.next();
        }

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when third iterator is null.
     */
    @Test
    public void whenConvertThirdIteratorNull() {
        final List<Iterator<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{4, 2, 0, 4, 6, 4, 9}).iterator());
        list.add(Arrays.asList(new Integer[]{0, 9, 8, 7, 5}).iterator());
        list.add(null);

        final int[] expected = new int[]{4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5};
        final int[] actual = new int[12];
        final Iterator<Integer> actualIterator = new ConverterForIterators().convert(list.iterator());

        int position = 0;
        while (actualIterator.hasNext()) {
            actual[position++] = actualIterator.next();
        }

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when iterators iterator ara null.
     */
    @Test
    public void whenConvertAllIteratorsNull() {
        final List<Iterator<Integer>> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);

        final int[] expected = new int[]{};
        final int[] actual = new int[0];
        final Iterator<Integer> actualIterator = new ConverterForIterators().convert(list.iterator());

        int position = 0;
        while (actualIterator.hasNext()) {
            actual[position++] = actualIterator.next();
        }

        assertThat(actual, is(expected));
    }


}