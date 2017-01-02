package ofedorova;

import ofedorova.prototypes.Printable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ofedorova.prototypes.Input;
import ofedorova.prototypes.Selectable;
import ofedorova.prototypes.Addable;

/**
 * The class implements to work with menu.
 *
 * @author Olga Fedorova
 * @since 16.10.2016
 * @version 1
 */
public class Menu implements Printable, Addable, Selectable, Input {

    /**
     * List of items.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * The method print info.
     *
     * @param prefix
     */
    @Override
    public void print(String prefix) {
        for (Item item : this.items) {
            item.print(prefix);
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
        return items.add(item);
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
        for (Item item : this.items) {
            if (item.select(id) != null) {
                result = item.select(id);
                break;
            }
        }
        return result;
    }

    /**
     * The method asks user to input id.
     *
     * @return id
     */
    @Override
    public String askId() {
        Scanner scanner = new Scanner(System.in);
        String result = null;
        boolean invalid = true;
        System.out.println("Input id of item.");
        do {
            result = scanner.next();
            if (result != null && result.matches("[1-9]\\d*?(.?[1-9]\\d*?){0,}")) {
                invalid = false;
            } else {
                System.out.println("Incorrect input, try again.");
            }
        } while (invalid);
        return result;
    }

}
