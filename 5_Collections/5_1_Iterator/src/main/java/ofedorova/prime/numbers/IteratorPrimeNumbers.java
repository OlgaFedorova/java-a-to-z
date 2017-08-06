package ofedorova.prime.numbers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implement iterator for simple numbers.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 18.12.2016
 */
public class IteratorPrimeNumbers implements Iterator<Integer> {
    /**
     * Object for conteiner.
     */
    private final int[] values;
    /**
     * Position for current element.
     */
    private int position;

    /**
     * Allocates a new {@code IteratorPrimeNumbers}.
     *
     * @param values value of field "values".
     */
    public IteratorPrimeNumbers(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    /**
     * Method checks has next element or not.
     *
     * @return if has next element returns true, else - false.
     */
    @Override
    public boolean hasNext() {
        return this.position < this.values.length && (this.isPrimeNumber() || this.movePositionAndCheckNumber());
    }

    /**
     * Method returns current element, and move position on next element.
     *
     * @return if has current element return it, else throws NoSuchElementException.
     */
    @Override
    public Integer next() {
        if (this.position >= this.values.length) {
            throw new NoSuchElementException();
        }
        Integer current = null;
        if (this.isPrimeNumber() || this.movePositionAndCheckNumber()) {
            current = this.values[this.position];
            this.movePositionAndCheckNumber();
        } else {
            throw new NoSuchElementException();
        }
        return current;
    }

    /**
     * Method moves position and check that number in position is prime.
     *
     * @return if number in position is prime return true, else return false.
     */
    private boolean movePositionAndCheckNumber() {
        boolean result = false;
        while (this.position < this.values.length) {
            this.movePosition();
            if (this.position < this.values.length) {
                result = this.isPrimeNumber();
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Method moves position.
     */
    private void movePosition() {
        this.position++;
    }

    /**
     * Method checks that number in position is prime.
     *
     * @return if number in position is prime return true, else return false.
     */
    private boolean isPrimeNumber() {
        boolean isPrimeNumber = true;
        for (int i = 2; i <= Math.sqrt(this.values[this.position]); i++) {
            if (this.values[this.position] % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }
        return isPrimeNumber;
    }
}
