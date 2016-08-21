
package ofedorova.models;

/**
  *The class uses for finding items by filter with field "name"
 * @author Olga Fedorova
 * @since 18.08.2016
 * @version 1
 */
class FilterByName extends Filter{

    public FilterByName(String value) {
        super(value);
    }

   /*
   *The metod finds items to using the field "Value" by the field "Name" of the class "Item".
   *@return array of items
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
