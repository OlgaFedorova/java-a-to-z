package ofedorova.store.storages;

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
     * Method updates element in container by identifier.
     *
     * @param id      value of identifier for the object, which'll be updated.
     * @param element new value for updating.
     * @return if element updates return true, else return false.
     */
    boolean update(String id, T element);

    /**
     * Method deletes element from container by value.
     *
     * @param element value for deleting.
     * @return if element deletes return true, else return false.
     */
    boolean delete(T element);

    /**
     * Method deletes element from container by identifier.
     *
     * @param id value of identifier for the object, which'll be deleted.
     * @return value of deleting element/
     */
    T delete(String id);

    /**
     * Method get element by identifier.
     *
     * @param id value of identifier for the object.
     * @return element by identifier.
     */
    T get(String id);

    /**
     * Method returns copy of container.
     *
     * @return copy of container.
     */
    Object[] toArray();

}
