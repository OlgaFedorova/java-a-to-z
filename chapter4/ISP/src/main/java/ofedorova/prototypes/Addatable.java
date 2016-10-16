package ofedorova.prototypes;

import ofedorova.Item;

/**
 * The interface implements opportunity to adding.
 *
 * @author Olga Fedorova
 * @since 16.10.2016
 * @version 1
 */
public interface Addatable {

    /**
     * The method adds new item in list.
     *
     * @param item
     * @return
     */
    public boolean addItem(Item item);

}
