package ofedorova.models;

import java.util.Date;

/**
 *The class implements model of  "application".
 * @author Olga Fedorova
 * @since 16.08.2016
 * @version 1
 */
public class Item {
    private String name;
    private String description;
    private Date dateCreate;
    private String[]comments = new String[10];
    private int position = 0;
    private String id;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return this.dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getComments() {
        String[] result = new String[position];
        System.arraycopy(this.comments, 0, result, 0, position);
        return result;
    }
    
    public void addComment(String comment){
        if (this.position == this.comments.length){
            String[] temp = new String[position + 10];
            System.arraycopy(this.comments, 0, temp, 0, position);
            this.comments = temp;    
        }
        this.comments[position++] = comment;
    }

    public Item(String name, String description, String comment) {
        this.name = name;
        this.description = description;
        this.dateCreate = new Date();
        this.comments[this.position++] = comment;
    }
    

}
