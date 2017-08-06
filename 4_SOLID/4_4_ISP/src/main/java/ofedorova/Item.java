package ofedorova;

import ofedorova.prototypes.Printable;
import java.util.ArrayList;
import java.util.List;
import ofedorova.prototypes.Action;
import ofedorova.prototypes.Selectable;
import ofedorova.prototypes.Addable;

/**
 * The class implements an item of menu.
 *
 * @author Olga Fedorova
 * @since 16.10.2016
 * @version 1
 */
public class Item implements Printable, Addable, Selectable, Action {

    /**
     * Id of item.
     */
    private final String id;
    /**
     * Name of item.
     */
    private final String name;
    /**
     * List of items.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Allocates a new {@code Item}
     *
     * @param id
     * @param name
     */
    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * The method print info.
     *
     * @param prefix
     */
    @Override
    public void print(String prefix) {
        System.out.printf("%s %s.%n", prefix, this.name);
        for (Item item : this.items) {
            item.print(String.format("%s%s", prefix, prefix));
        }
    }

    /**
     * The method adds new item in list.
     *
     * @param item
     * @return
     */
    @Override
    public boolean addItem(Item item) {
        return this.items.add(item);
    }

    /**
     * The method selects an item by id.
     *
     * @param id
     * @return
     */
    @Override
    public Item select(String id) {
        Item result = null;
        if (this.id != null && this.id.equals(id)) {
            result = this;
        } else {
            for (Item item : this.items) {
                if (item.select(id) != null) {
                    result = item.select(id);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * The method excutes action.
     */
    @Override
    public void excute() {
        this.print("****");
    }

}
