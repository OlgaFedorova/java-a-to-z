package ofedorova.models;

/**
  *The class uses for finding items by filter.
 * @author Olga Fedorova
 * @since 18.08.2016
 * @version 1
 */
public abstract class Filter {
    
  protected String value;

  public Filter(String value) {
      this.value = value;
  }

  public abstract Item[] find(Item[] items);

}
