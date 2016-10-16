package ofedorova.prototypes;

import ofedorova.Item;

/**
 * The interface implements opportunity to selecting.
 *
 * @author Olga Fedorova
 * @since 16.10.2016
 * @version 1
 */
public interface Selectable {

    /**
     * The method selects an item by id.
     *
     * @param id
     * @return
     */
    public Item select(String id);

}
