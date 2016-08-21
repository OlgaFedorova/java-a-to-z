package ofedorova.start;

import java.util.Random;
import ofedorova.models.Comment;
import ofedorova.models.Filter;
import ofedorova.models.Item;

/**
  *The class implements storage of items.
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public class Tracker {
    private Item[] items = new Item[10];
    private int position = 0;
    private final Random RN = new Random();
    
    public Item addItem(Item item){
        if (this.position == this.items.length){
            Item[] temp = new Item[position + 10];
            System.arraycopy(this.items, 0, temp, 0, position);
            this.items = temp;    
        }
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    
    public Item addComment(Comment comment){
        Item item = this.findById(comment.getIdItem());
        item.addComment(comment);
        return item;
    }
    
    public boolean removeItem(Item item){
        
        boolean isRemove = false;
        
        for(int index = 0; index < this.position; index++){
            if(this.items[index] == item){
                Item[] firstPart = new Item[index];
                System.arraycopy(this.items, 0, firstPart, 0, index);
                Item[] secondPart = new Item[this.items.length - index -1];
                System.arraycopy(this.items, index+1, secondPart, 0, secondPart.length);
                this.items = new Item[this.items.length];
                System.arraycopy(firstPart, 0, this.items, 0, firstPart.length);
                System.arraycopy(secondPart, 0, this.items, firstPart.length, secondPart.length);
                position--;
                isRemove = true;
                break;                
            }
        }
        return isRemove;
    }
    
    public void editItem(Item item){
        for(int index = 0; index < position; index++){
            if(this.items[index] != null && this.items[index] .getId().equals(item.getId())){
                this.items[index]  = item;
                break;
            }
        }
    }
    
    public Item[] getItems(){
        Item[] result = new Item[position];
        System.arraycopy(items, 0, result, 0, position);
        return result;
    }
     
    public Item[] getItems(Filter filter){
        return filter.find(this.getItems());
    }
    
    protected Item findById(String id){
        Item result = null;
        for(Item item : items){
            if (item != null && item.getId().equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }
    
    private String generateId(){
        return String.valueOf(System.currentTimeMillis()+ RN.nextInt());
    }
    
}
