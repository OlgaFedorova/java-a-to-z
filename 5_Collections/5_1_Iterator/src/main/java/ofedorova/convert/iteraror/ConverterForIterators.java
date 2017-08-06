package ofedorova.convert.iteraror;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class implements converter for iterator of number.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 20.12.2016
 */
public class ConverterForIterators implements Convertible {

    /**
     * Class implements iterator of number.
     *
     * @author Olga Fedorova
     * @version 1.0
     * @since 20.12.2016
     */
    private static class IteratorOfIterators implements Iterator<Integer> {
        /**
         * Object iterator of iterators.
         */
        private final Iterator<Iterator<Integer>> it;
        /**
         * Current iterator from "it".
         */
        private Iterator<Integer> position;

        /**
         * Allocates a new {@code IIteratorOfIterators}.
         *
         * @param it value of field "it".
         */
        private IteratorOfIterators(Iterator<Iterator<Integer>> it) {
            this.it = it;
        }

        /**
         * Method checks has next element or not.
         *
         * @return if has next element returns true, else - false.
         */
        @Override
        public boolean hasNext() {
            boolean hasNext = false;

            if (this.it != null) {
                if (this.position != null && this.position.hasNext()) {
                    hasNext = true;
                } else {
                    this.movePosition();
                    if (this.position != null && this.position.hasNext()) {
                        hasNext = true;
                    }
                }
            }
            return hasNext;
        }

        /**
         * Method returns current element, and move position on next iterator if need.
         *
         * @return if has current element return it, else throws NoSuchElementException.
         */
        @Override
        public Integer next() {
            Integer current = null;

            if (this.it != null && this.position != null) {
                while (this.position != null) {
                    try {
                        current = this.position.next();
                        break;
                    } catch (NoSuchElementException e) {
                        this.movePosition();
                    }
                }
            }
            return current;
        }

        /**
         * Method move position on next iterator.
         */
        private void movePosition() {
            while (this.it.hasNext()) {
                if (this.it.hasNext()) {
                    this.position = this.it.next();
                    if (this.position != null) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method converts iterator of iterators into iterator of numbers.
     *
     * @param it iterator of iterators for convert.
     * @return iterator of numbers.
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new IteratorOfIterators(it);
    }
}
