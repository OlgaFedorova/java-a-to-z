package ofedorova.models;

import java.util.Arrays;
import java.util.Date;

/**
 * The class implements a model of  "application".
 *
 * @author Olga Fedorova
 * @version 1
 * @since 16.08.2016
 */
public class Item {
    /**
     * Name of item.
     */
    private String name;
    /**
     * Description of item.
     */
    private String description;
    /**
     * Date create of item.
     */
    private Date dateCreate;
    /**
     * List of comments.
     */
    private Comment[] comments = new Comment[10];
    /**
     * Current position in array of comments.
     */
    private int position = 0;
    /**
     * Id of item.
     */
    private String id;

    /**
     * Getter for the field "name".
     *
     * @return value of field "name"
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the field "Name".
     *
     * @param name value of field "name".
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the field "Description".
     *
     * @return value of field "description".
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for the field "Description".
     *
     * @param description value of field "description".
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the field "dateCreate".
     *
     * @return value of field "dateCreate".
     */
    public Date getDateCreate() {
        return this.dateCreate;
    }

    /**
     * Setter for the field "dateCreate".
     *
     * @param dateCreate value of field "dateCreate".
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * Getter for the field "id".
     *
     * @return value of field "id"
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for the field "id".
     *
     * @param id value of field "id".
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the field "Comments".
     *
     * @return value of field "comments".
     */
    public Comment[] getComments() {
        Comment[] result = new Comment[position];
        System.arraycopy(this.comments, 0, result, 0, position);
        return result;
    }

    /**
     * The method add new comment in the array "Comments".
     *
     * @param comment value of field "comments".
     */
    public void addComment(Comment comment) {
        if (this.position == this.comments.length) {
            Comment[] temp = new Comment[position + 10];
            System.arraycopy(this.comments, 0, temp, 0, position);
            this.comments = temp;
        }
        this.comments[position++] = comment;
    }

    /**
     * Allocates a new {@code Item} with parameters "name" and "description".
     *
     * @param name        value of field "nzme".
     * @param description value of field "description".
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateCreate = new Date();
    }

    /**
     * Returns a hash code for this {@code Item}.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 53 * hash + Arrays.deepHashCode(this.comments);
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares this object to the specified object.  The result is
     * {@code true} if and only if the argument is not
     * {@code null} and is an {@code Item} object that
     * contains the same values of field "name", "description", "id" and "comments" as this object.
     *
     * @param obj the object to compare with.
     * @return {@code true} if the objects are the same;
     * {@code false} otherwise.
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
        final Item other = (Item) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if (!Arrays.deepEquals(this.comments, other.comments)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a {@code Comment} object representing.
     *
     * @return a string representation.
     */
    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", description=" + description + ", dateCreate=" + dateCreate
                + (this.position == 0 ? "" : ", comments=" + Arrays.toString(this.getComments())) + '}';
    }

}
