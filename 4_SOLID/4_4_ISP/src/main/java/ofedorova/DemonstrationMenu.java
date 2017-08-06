package ofedorova;

/**
 * The class is for demonstration of menu.
 *
 * @author Olga Fedorova
 * @since 16.10.2016
 * @version 1
 */
public class DemonstrationMenu {
    
    public static void init(Menu menu){
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
        Item item_2_2_3 = new Item("2.2.3", "Задача 2.2.3");

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
    
    public static void main(String[] args) {
        Menu menu = new Menu();
        init(menu);
        menu.print("----");
        String id = menu.askId();
        if(menu.select(id) != null){
            menu.select(id).excute();
        }
    }
    
}
