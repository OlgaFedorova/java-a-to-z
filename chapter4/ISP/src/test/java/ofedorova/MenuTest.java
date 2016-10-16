package ofedorova;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author OLGA
 */
public class MenuTest {

    private final Menu menu = new Menu();
    private final Item item_2_2_3 = new Item("2.2.3", "Задача 2.2.3");

    @Before
    public void init() {
        Item item_1 = new Item("1", "Задача 1");
        Item item_1_1 = new Item("1.1", "Задача 1.1");
        Item item_1_1_1 = new Item("1.1.1", "Задача 1.1.1");
        Item item_1_1_2 = new Item("1.1.2", "Задача 1.1.2");
        Item item_1_1_3 = new Item("1.1.3", "Задача 1.1.3");
        Item item_1_2 = new Item("1.2", "Задача 1.2");
        Item item_1_2_1 = new Item("1.2.1", "Задача 1.2.1");
        Item item_1_2_2 = new Item("1.2.2", "Задача 1.2.2");
        Item item_1_2_3 = new Item("1.2.3", "Задача 1.2.3");

        item_1.addItem(item_1_1);
        item_1_1.addItem(item_1_1_1);
        item_1_1.addItem(item_1_1_2);
        item_1_1.addItem(item_1_1_3);
        item_1.addItem(item_1_2);
        item_1_2.addItem(item_1_2_1);
        item_1_2.addItem(item_1_2_2);
        item_1_2.addItem(item_1_2_3);

        Item item_2 = new Item("2", "Задача 2");
        Item item_2_1 = new Item("2.1", "Задача 2.1");
        Item item_2_1_1 = new Item("2.1.1", "Задача 2.1.1");
        Item item_2_1_2 = new Item("2.1.2", "Задача 2.1.2");
        Item item_2_1_3 = new Item("2.1.3", "Задача 2.1.3");
        Item item_2_2 = new Item("2.2", "Задача 2.2");
        Item item_2_2_1 = new Item("2.2.1", "Задача 2.2.1");
        Item item_2_2_2 = new Item("2.2.2", "Задача 2.2.2");

        item_2.addItem(item_2_1);
        item_2_1.addItem(item_2_1_1);
        item_2_1.addItem(item_2_1_2);
        item_2_1.addItem(item_2_1_3);
        item_2.addItem(item_2_2);
        item_2_2.addItem(item_2_2_1);
        item_2_2.addItem(item_2_2_2);
        item_2_2.addItem(item_2_2_3);

        menu.addItem(item_1);
        menu.addItem(item_2);
    }

    @Test
    public void testSelect() {
        assertEquals(item_2_2_3, menu.select("2.2.3"));
    }
}
