package ofedorova.models;

import java.util.Arrays;
import java.util.Date;

/**
 *The class implements a model of  "application".
 * @author Olga Fedorova
 * @since 16.08.2016
 * @version 1
 */
public class Item {
    private String name;
    private String description;
    private Date dateCreate;
    private Comment[]comments = new Comment[10];
    private int position = 0;
    private String id;

    /*
    * Getter for the field "name".
    * return name
    */
    public String getName() {
        return this.name;
    }

    /*
    *Setter for the field "Name".
    *@param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /*
    *Getter for the field "Description".
    *@return description
    */
    public String getDescription() {
        return this.description;
    }

    /*
    *Setter for the field "Description".
    *@param description
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
    *Getter for the field "dateCreate".
    *@return dateCreate
    */
    public Date getDateCreate() {
        return this.dateCreate;
    }
    
    /*
    *Setter for the field "dateCreate".
    *@param dateCreate
    */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /*
    *Getter for the field "id".
    *@return id
    */
    public String getId() {
        return this.id;
    }

    /*
    *Setter for the field "id".
    *@param id
    */
    public void setId(String id) {
        this.id = id;
    }
    
    /*
    *Getter for the field "Comments".
    *@return comments
    */
    public Comment[] getComments() {
        Comment[] result = new Comment[position];
        System.arraycopy(this.comments, 0, result, 0, position);
        return result;
    }
    
    /*
    *The metod add new comment in the array "Comments".
    *@param comment
    */
    public void addComment(Comment comment){
        if (this.position == this.comments.length){
            Comment[] temp = new Comment[position + 10];
            System.arraycopy(this.comments, 0, temp, 0, position);
            this.comments = temp;    
        }
        this.comments[position++] = comment;
    }


    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.dateCreate = new Date();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 53 * hash + Arrays.deepHashCode(this.comments);
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", description=" + description + ", dateCreate=" + dateCreate 
                + (this.position == 0 ? "" : ", comments=" + Arrays.toString(this.getComments())) + '}';
    }
    
}
