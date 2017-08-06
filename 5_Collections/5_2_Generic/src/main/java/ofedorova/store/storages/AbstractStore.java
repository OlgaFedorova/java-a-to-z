package ofedorova.store.storages;

import ofedorova.simplearray.SimpleArray;
import ofedorova.store.models.Base;


/**
 * Class for store of objects extends Base.
 *
 * @param <T> type of object, which'll storage in container.
 * @author Olga Fedorova
 * @version 1.0
 * @since 06.08.2017
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Object for store.
     */
    private final SimpleArray<T> store = new SimpleArray<>(10);

    /**
     * Method adds new element in container.
     *
     * @param element value for adding in container.
     * @return if element adding return true, else return false.
     */
    @Override
    public boolean add(T element) {
        return this.store.add(element);
    }

    /**
     * Method updates element in container by identifier.
     *
     * @param id      value of identifier for the object, which'll be updated.
     * @param element new value for updating.
     * @return if element updates return true, else return false.
     */
    @Override
    public boolean update(String id, T element) {
        return this.store.update(this.getIndexOfElementById(id), element);
    }

    /**
     * Method deletes element from container by value.
     *
     * @param element value for deleting.
     * @return if element deletes return true, else return false.
     */
    @Override
    public boolean delete(T element) {
        return this.store.delete(element);
    }

    /**
     * Method deletes element from container by identifier.
     *
     * @param id value of identifier for the object, which'll be deleted.
     * @return value of deleting element/
     */
    @Override
    public T delete(String id) {
        return this.store.delete(this.getIndexOfElementById(id));
    }

    /**
     * Method get element by index.
     *
     * @param id index of element.
     * @return element by index.
     */
    @Override
    public T get(String id) {
        return this.store.get(this.getIndexOfElementById(id));
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

    /**
     * Method return index of element.
     *
     * @param id value of identifier for the object, which'll be updated.
     * @return if element finding in container returns its index, else return -1.
     */
    private int getIndexOfElementById(String id) {
        int index = -1;
        for (int i = 0; i < this.store.size(); i++) {
            if (this.store.get(i) != null && this.store.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
