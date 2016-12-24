package ofedorova.store;

import ofedorova.simplearray.SimpleArray;
import ofedorova.store.models.Role;

/**
 * Class for store of role.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public class RoleStore implements Store<Role> {
    /**
     * Object for store.
     */
    private final SimpleArray<Role> store = new SimpleArray<>(10);

    /**
     * Getter for store.
     *
     * @return value of field "store"
     */
    public SimpleArray<Role> getStore() {
        return this.store;
    }
}
