package ofedorova.prototype;

/**
 * The abstract class implements the model "User".
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public abstract class User {

    /**
     * Identifier of user.
     */
    protected String id;
    /**
     * Name of user.
     */
    protected String name;
    /**
     * Age of user.
     */
    protected String age;

    /**
     * Allocates a new {@code User}
     *
     * @param id value for field "id"
     * @param name value for field "name"
     * @param age value for field "age"
     */
    public User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Getter for field "id"
     *
     * @return value of field "id"
     */
    public String getId() {
        return this.id;
    }

    /**
     * Getter for field "name".
     *
     * @return value of field "name"
     */
    public String getName() {
        return name;
    }

    /**
     * The method edits user to set it new values of field "name" and "age".
     *
     * @param name new value for field "name"
     * @param age new value for field "age"
     */
    public abstract void edit(String name, String age);

}
