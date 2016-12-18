package ofedorova.EvenNumbers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implement iterator for even numbers.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 17.12.2016
 */
public class IteratorEvenNumbers implements Iterator<Integer> {
    /**
     * Object for conteiner.
     */
    private final int[] values;
    /**
     * Position for current element.
     */
    private int position;

    /**
     * Allocates a new {@code IteratorEvenNumbers}.
     *
     * @param values value of field "values".
     */
    public IteratorEvenNumbers(int[] values) {
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
        if (this.position >= this.values.length) {
            throw new NoSuchElementException();
        }

        Integer current = this.getCurrentAndMovePosition();
        this.position++;
        this.getCurrentAndMovePosition();
        return current;
    }

    /**
     * Private logic for returns current element, and move position on next element.
     *
     * @return current element.
     */
    private Integer getCurrentAndMovePosition() {
        Integer next = null;
        while (this.position < this.values.length) {
            next = this.values[this.position];
            if (next != null && next % 2 == 0) {
                break;
            } else {
                this.position++;
            }
        }
        return next;
    }
}
