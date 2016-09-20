package ofedorova.models;

/**
  *The class uses for finding items by filter.
 * @author Olga Fedorova
 * @since 18.08.2016
 * @version 1
 */
public abstract class Filter {
    
  /**
   * Value for searching.
   */  
  protected String value;

  /**
   * Allocates a new {@code Filter}
   * @param value - uses for searching.
   */
  public Filter(String value) {
      this.value = value;
  }

  /**
   * The method finds items to using the field "Value". 
   * @param items - array for searching. 
   * @return array of items
   */
  public abstract Item[] find(Item[] items);

}
