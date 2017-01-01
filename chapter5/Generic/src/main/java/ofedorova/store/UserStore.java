package ofedorova.store;

import ofedorova.simplearray.SimpleArray;
import ofedorova.store.models.User;

/**
 * Class for store of user.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class UserStore implements Store<User> {

    /**
     * Object for store.
     */
    private final SimpleArray<User> store = new SimpleArray<>(10);

    /**
     * Method adds new element in container.
     *
     * @param element value for adding in container.
     * @return if element adding return true, else return false.
     */
    @Override
    public boolean add(User element) {
        return this.store.add(element);
    }

    /**
     * Method updates element in container by index.
     *
     * @param index   value of index, when states element in container.
     * @param element new value for updating.
     * @return if element updates return true, else return false.
     */
    @Override
    public boolean update(int index, User element) {
        return this.store.update(index, element);
    }

    /**
     * Method deletes element from container by value.
     *
     * @param element value for deleting.
     * @return if element deletes return true, else return false.
     */
    @Override
    public boolean delete(User element) {
        return this.store.delete(element);
    }

    /**
     * Method deletes element from container by index.
     *
     * @param index index of deleting element.
     * @return value of deleting element/
     */
    @Override
    public User delete(int index) {
        return this.store.delete(index);
    }

    /**
     * Method get element by index.
     *
     * @param index index of element.
     * @return element by index.
     */
    @Override
    public User get(int index) {
        return this.store.get(index);
    }

    /**
     * Method returns copy of container.
     *
     * @return copy of container.
     */
    @Override
    public Object[] toArray() {
        return this.store.toArray();
    }
}
