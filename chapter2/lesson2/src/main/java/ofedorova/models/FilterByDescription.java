package ofedorova.models;

/**
  *The class uses for finding items by filter with field "description"
 * @author Olga Fedorova
 * @since 18.08.2016
 * @version 1
 */
class FilterByDescription extends Filter{

    public FilterByDescription(String value) {
        super(value);
    }

    @Override
    public Item[] find(Item[] items) {
        Item[] temp = new Item[items.length];
        int position = 0;
        
        for (Item item : items) {
            if(item.getDescription().contains(this.value)){
                temp[position++] = item;
            }
        }
        
        Item[] result = new Item[position];
        System.arraycopy(temp, 0, result, 0, position);
        return result;
    }
    
}