package ofedorova.ConvertIteraror;

import java.util.Iterator;

/**
 * Interface implements converter for iterator of number.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 20.12.2016
 */
public interface Convertible {
    /**
     * Method converts iterator of iterators into iterator of numbers.
     *
     * @param it iterator of iterators for convert.
     * @return iterator of numbers.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);

}
