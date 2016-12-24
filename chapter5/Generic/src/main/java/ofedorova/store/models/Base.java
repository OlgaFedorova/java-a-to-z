package ofedorova.store.models;

/**
 * Abstract class implements base of model.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.12.2016
 */
public abstract class Base {
    /**
     * Identifier of object.
     */
    private String id;

    /**
     * Allocates a new {@code Base}.
     *
     * @param id value of id.
     */
    public Base(String id) {
        this.id = id;
    }

    /**
     * Getter for field "id".
     *
     * @return value of field "id".
     */
    public String getId() {
        return this.id;
    }

    /**
     * Method sets value of field "id".
     *
     * @param id value for field "id".
     */
    public void setId(String id) {
        this.id = id;
    }
}
