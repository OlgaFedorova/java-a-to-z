
package ofedorova.models;

/**
  *The class uses for finding items by filter with field "name"
 * @author Olga Fedorova
 * @since 18.08.2016
 * @version 1
 */
class FilterByName extends Filter{

   /**
   * Allocates a new {@code FilterByName}
   * @param value - uses for searching.
   */
    public FilterByName(String value) {
        super(value);
    }

   /**
   * The method finds items to using the field "Value" by the field "Name" of the class "Item".
   * @param items - array for searching. 
   * @return array of items
   */
    @Override
    public Item[] find(Item[] items) {
        Item[] temp = new Item[items.length];
        int position = 0;
        
        for (Item item : items) {
            if(item.getName().contains(this.value)){
                temp[position++] = item;
            }
        }
        
        Item[] result = new Item[position];
        System.arraycopy(temp, 0, result, 0, position);
        return result;
    }
    
}
