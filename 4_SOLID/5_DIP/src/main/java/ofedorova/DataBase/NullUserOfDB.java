package ofedorova.DataBase;

/**
 * The class implements NULL functionality for the class "User of database".
 *
 * @author Olga Fedorova
 * @since 29.10.2016
 * @version 1
 */
public class NullUserOfDB extends UserOfDB {

    /**
     * Allocates a new {@code NullUserOfDB}
     *
     * @param id value for field "id"
     * @param name value for field "name"
     * @param age value for field "age"
     */
    public NullUserOfDB(String id, String name, String age) {
        super(id, name, age);
    }
    
    /**
     * Allocates a new {@code NullUserOfDB}
     */
    public NullUserOfDB() {
        super(new String(), new String(), new String());
    }

    /**
     * The method checks null-object.
     *
     * @return true - if this object is null, false - if this object isn't null
     */
    @Override
    public boolean isNull() {
        return true;
    }
}
