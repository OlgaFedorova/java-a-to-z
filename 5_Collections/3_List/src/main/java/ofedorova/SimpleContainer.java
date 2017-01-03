package ofedorova;

/**
 * Created by Olga on 02.01.2017.
 */
public interface SimpleContainer<T> extends Iterable<T> {

    void add(T element);

    T get(int index);

    T set(int index, T element);

    int size();

    boolean isEmpty();

    boolean contains(T element);

    Object[] toArray();
}
