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

    /**
     * Compares this object to the specified object.  The result is
     * {@code true} if and only if the argument is not
     * {@code null} and is an {@code Item} object that
     * contains the same values of field "id" as this object.
     *
     * @param o the object to compare with.
     * @return {@code true} if the objects are the same;
     * {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Base base = (Base) o;

        return id != null ? id.equals(base.id) : base.id == null;

    }

    /**
     * Returns a hash code for this {@code Base}.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
