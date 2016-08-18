package ofedorova.models;

/**
  *The class is factory for the class "Filter".
 * @author Olga Fedorova
 * @since 18.08.2016
 * @version 1
 */
public class FilterFactory {
    
    public Filter getFilter(String key, String value){
        Filter filter = null;
        if ("name".equals(key)) {
            filter = new FilterByName(value);
        }
        else if("description".equals(key)) {
            filter = new FilterByDescription(value);
        }
        else{
            throw new IllegalArgumentException("Неверное поле для поиска");
        }
        
        return filter;
    }
    
}
