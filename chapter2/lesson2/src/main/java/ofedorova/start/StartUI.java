package ofedorova.start;

import ofedorova.models.Comment;
import ofedorova.models.FilterFactory;
import ofedorova.models.Item;

/**
 * The class starts the program.
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public class StartUI {
    
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }
    
    public void init(){}
    
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        
        //Добавляем заявки
        System.out.println("Add items:");
        
        tracker.addItem(new Item("item1", "description1"));
        tracker.addItem(new Item("item2", "description2"));
        tracker.addItem(new Item("item3", "description3"));
        tracker.addItem(new Item("item4", "description4"));
        tracker.addItem(new Item("item5", "description5"));
        
        //Выводим на печать все заявки
        for(Item item : tracker.getItems()){
            System.out.println(item);
        }
        System.out.println("_________________________________________________________");
        
        //Добавляем комментарий
        System.out.println("Add comments:");
        
        tracker.addComment(new Comment(tracker.getItems()[2].getId(), "comment1"));
        tracker.addComment(new Comment(tracker.getItems()[2].getId(), "comment2"));
        
        //Выводим на печать все заявки
        for(Item item : tracker.getItems()){
            System.out.println(item);
        }
        System.out.println("_________________________________________________________");
        
        //Удаляем заявку
        System.out.println("Remove item:");
        
        tracker.removeItem(tracker.getItems()[1]);
        
        //Выводим на печать все заявки
        for(Item item : tracker.getItems()){
            System.out.println(item);
        }
        System.out.println("_________________________________________________________");
        
        //Редактируем заявку
        System.out.println("Edit item:");
        
        Item itemEdit = new Item("edit item", "edit");
        itemEdit.setId(tracker.getItems()[2].getId());
        tracker.editItem(itemEdit);
        
        //Выводим на печать все заявки
        for(Item item : tracker.getItems()){
            System.out.println(item);
        }
        System.out.println("_________________________________________________________");
        
        
        //Выводим список заявок по фильтру
        System.out.println("Get items by filter:");
        
        for(Item item : tracker.getItems(new FilterFactory().getFilter("name", "5"))){
            System.out.println(item);
        }
        System.out.println("_________________________________________________________");
        
        
        
        
    }
    
}
