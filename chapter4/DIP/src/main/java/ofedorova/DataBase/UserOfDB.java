package ofedorova.DataBase;

import ofedorova.prototype.User;

/**
 * The class implements the model "User of database".
 *
 * @author Olga Fedorova
 * @since 23.10.2016
 * @version 1
 */
public class UserOfDB extends User {

    /**
     * Allocates a new {@code UserOfDB}
     *
     * @param id value for field "id"
     * @param name value for field "name"
     * @param age value for field "age"
     */
    public UserOfDB(String id, String name, String age) {
        super(id, name, age);
    }

    /**
     * The method edits user to set it new values of field "name" and "age".
     *
     * @param name new value for field "name"
     * @param age new value for field "age"
     */
    @Override
    public void edit(String name, String age) {
        this.age = age;
        this.name = name;
    }

    /**
     * The method checks null-object.
     *
     * @return true - if this object is null, false - if this object isn't null
     */
    @Override
    public boolean isNull() {
        return false;
    }
}
