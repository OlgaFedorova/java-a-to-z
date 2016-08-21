
package ofedorova.models;

/**
 * The class implements model of  "comment in item".
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public class Comment {
    
    private String idItem;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public Comment(String idItem, String value) {
        this.idItem = idItem;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    
    
}
