package ofedorova.PrimeNumbers;

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
        return this.position < this.values.length;
    }

    /**
     * Method returns current element, and move position on next element.
     *
     * @return if has current element return it, else throws NoSuchElementException.
     */
    @Override
    public Integer next() {
        Integer current = null;
        if (this.position >= this.values.length) {
            throw new NoSuchElementException();
        } else if (this.position == 0) {
            if (this.checkPrimeNumber(this.values[this.position])) {
                current = this.values[this.position];
            } else {
                this.movePosition();
                current = this.values[this.position];
            }
        } else {
            current = this.values[this.position];
        }
        this.movePosition();

        return current;
    }

    /**
     * Method move position on next prime number.
     */
    private void movePosition() {
        boolean findPrimeNumber = false;
        while (!findPrimeNumber) {
            this.position++;
            if (this.position < this.values.length) {
                findPrimeNumber = this.checkPrimeNumber(this.values[this.position]);
            } else {
                break;
            }
        }
    }

    /**
     * Method checks that number is prime.
     *
     * @param number for checking.
     * @return if number is prime return true, else return false.
     */
    private boolean checkPrimeNumber(int number) {
        boolean isPrimeNumber = true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrimeNumber = false;
                break;
            }
        }
        return isPrimeNumber;
    }
}
