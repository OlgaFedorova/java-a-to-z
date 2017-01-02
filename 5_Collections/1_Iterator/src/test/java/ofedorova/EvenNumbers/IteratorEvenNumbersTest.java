package ofedorova.EvenNumbers;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Class for testing "IteratorEvenNumbers".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 17.12.2016
 */
public class IteratorEvenNumbersTest {
    /**
     * Object for testing.
     */
    private IteratorEvenNumbers iterator;
    /**
     * Value for first element of array.
     */
    private final int element1 = 1;
    /**
     * Value for second element of array.
     */
    private final int element2 = 2;
    /**
     * Value for third element of array.
     */
    private final int element3 = 3;
    /**
     * Value for fourth element of array.
     */
    private final int element4 = 4;
    /**
     * Value for fifth element of array.
     */
    private final int element5 = 5;

    /**
     * Initilize state for testing.
     */
    private void initilize() {
        this.iterator = new IteratorEvenNumbers(new int[]{this.element1, this.element2, this.element3, this.element4, this.element5});
    }

    /**
     * Method tests when has next element.
     */
    @Test
    public void whenHasNextTrue() {
        this.initilize();
        this.iterator.next();
        final boolean expected = true;
        final boolean actual = this.iterator.hasNext();

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when hasn't next element.
     */
    @Test
    public void whenHasNextFalse() {
        this.initilize();
        this.iterator.next();
        this.iterator.next();
        final boolean expected = false;
        final boolean actual = this.iterator.hasNext();

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when getting first element.
     */
    @Test
    public void whenGetFirstElement() {
        this.initilize();
        final int expected = 2;
        final int actual = this.iterator.next();

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when getting second element.
     */
    @Test
    public void whenGetSecondElement() {
        this.initilize();
        final int expected = 4;
        this.iterator.next();
        final int actual = this.iterator.next();

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when getting element and there no such element.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetElementAndNoSuchElement() {
        this.initilize();
        this.iterator.next();
        this.iterator.next();
        this.iterator.next();
    }

    /**
     * When testing to use iterator in "for each".
     */
    @Test
    public void testForEach() {
        this.initilize();
        Iterable<Integer> iterable = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return IteratorEvenNumbersTest.this.iterator;
            }
        };

        final int[] expected = new int[]{this.element2, this.element4};
        final int[] actual = new int[2];
        int index = 0;
        for (Integer integer : iterable) {
            actual[index++] = integer;
        }

        assertThat(actual, is(expected));
    }

    /**
     * Test when array hasn't event number, аnd method hasNext return false.
     */
    @Test
    public void whenHasNotNextElement() {
        this.iterator = new IteratorEvenNumbers(new int[]{this.element1, this.element3, this.element5});
        final boolean expected = false;
        final boolean actual = this.iterator.hasNext();
        assertThat(actual, is(expected));
    }

}