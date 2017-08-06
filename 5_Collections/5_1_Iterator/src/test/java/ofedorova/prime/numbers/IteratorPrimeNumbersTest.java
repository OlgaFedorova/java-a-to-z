package ofedorova.prime.numbers;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing "IteratorPrimeNumbers".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 18.12.2016
 */
public class IteratorPrimeNumbersTest {
    /**
     * Object for testing.
     */
    private IteratorPrimeNumbers iterator;
    /**
     * Value for first element of array.
     */
    private final int element1 = 43;
    /**
     * Value for second element of array.
     */
    private final int element2 = 24;
    /**
     * Value for third element of array.
     */
    private final int element3 = 71;
    /**
     * Value for fourth element of array.
     */
    private final int element4 = 60;
    /**
     * Value for fifth element of array.
     */
    private final int element5 = 101;

    /**
     * Initilize state for testing.
     */
    private void initilize() {
        this.iterator = new IteratorPrimeNumbers(new int[]{this.element1, this.element2, this.element3, this.element4, this.element5});
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
        final int expected = this.element1;
        final int actual = this.iterator.next();

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when getting second element.
     */
    @Test
    public void whenGetSecondElement() {
        this.initilize();
        final int expected = this.element3;
        this.iterator.next();
        final int actual = this.iterator.next();

        assertThat(actual, is(expected));
    }

    /**
     * Method tests when getting third element.
     */
    @Test
    public void whenGetThirdElement() {
        this.initilize();
        final int expected = this.element5;
        this.iterator.next();
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
                return IteratorPrimeNumbersTest.this.iterator;
            }
        };

        final int[] expected = new int[]{this.element1, this.element3, this.element5};
        final int length = 3;
        final int[] actual = new int[length];
        int index = 0;
        for (Integer integer : iterable) {
            actual[index++] = integer;
        }

        assertThat(actual, is(expected));
    }

    /**
     * Test when array hasn't prime number, аnd method hasNext return false.
     */
    @Test
    public void whenHasNotNextElement() {
        this.iterator = new IteratorPrimeNumbers(new int[]{this.element2, this.element4});
        final boolean expected = false;
        final boolean actual = this.iterator.hasNext();
        assertThat(actual, is(expected));
    }

}