package ofedorova.store;

import ofedorova.store.models.Base;

/**
 * Interface for store.
 *
 * @param <T> the class of the objects for store.
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public interface Store<T extends Base> {

    /**
     * Method adds new element in container.
     *
     * @param element value for adding in container.
     * @return if element adding return true, else return false.
     */
    boolean add(T element);

    /**
     * Method updates element in container by index.
     *
     * @param index   value of index, when states element in container.
     * @param element new value for updating.
     * @return if element updates return true, else return false.
     */
    boolean update(int index, T element);

    /**
     * Method deletes element from container by value.
     *
     * @param element value for deleting.
     * @return if element deletes return true, else return false.
     */
    boolean delete(T element);

    /**
     * Method deletes element from container by index.
     *
     * @param index index of deleting element.
     * @return value of deleting element/
     */
    T delete(int index);

    /**
     * Method get element by index.
     *
     * @param index index of element.
     * @return element by index.
     */
    T get(int index);

    /**
     * Method returns copy of container.
     *
     * @return copy of container.
     */
    Object[] toArray();

}
