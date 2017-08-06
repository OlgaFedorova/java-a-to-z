package ofedorova.prototype;

import java.util.Objects;

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
    
    /**
     * The method checks null-object.
     *
     * @return true - if this object is null, false - if this object isn't null
     */
    public abstract boolean isNull();

    /**
     * Returns a object representing
     * @return object representing
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }

    /**
     * Returns a hash code for this {@code User}.
     *
     * @return  a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.age);
        return hash;
    }

    /**
     * Compares this object to the other object.  
     * 
     * @param   obj   the object to compare with.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        return true;
    }
}
