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
     * Getter for store.
     *
     * @return value of field "store"
     */
    public SimpleArray<User> getStore() {
        return this.store;
    }

}
