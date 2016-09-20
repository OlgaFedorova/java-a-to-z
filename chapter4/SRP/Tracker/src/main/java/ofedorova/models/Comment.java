
package ofedorova.models;

/**
 * The class implements the model of  "comment in item".
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public class Comment {
    
    /**
     * value of field "id" object "Item". 
     */
    private String idItem;
    /**
     * value of comment.
     */
    private String value;
    
    /**
    *Getter for the field "Value".
    *@return field "Value"
    */
    public String getValue() {
        return value;
    }

    /**
    *Setter for the field "Value"
    *@param value
    */
    public void setValue(String value) {
        this.value = value;
    }

    /**
    *Getter for the field "idItem"
    *@return field "idItem"
    */
    public String getIdItem() {
        return idItem;
    }

    /**
    *Setter for the field "idItem"
    *@param idItem
    */
    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    /**
     * Allocates a new {@code Comment} that contains value for "Item" with id in the parameter.
     * @param idItem
     * @param value 
     */
    public Comment(String idItem, String value) {
        this.idItem = idItem;
        this.value = value;
    }

    /**
     * Returns a {@code Comment} object representing.
     * @return a string representation
     */
    @Override
    public String toString() {
        return value;
    }
    
}
