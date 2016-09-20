package ofedorova.start;

import ofedorova.models.Comment;
import ofedorova.models.Item;
import ofedorova.models.FilterFactory;


/**
 * The class starts the program.
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public class StartUI {
    
    private final Input input;

    public StartUI(Input input) {
        this.input = input;
    }
    
    /*
    * The method implements to work with menu of profram.
    */
    public void init(){
        
        boolean exit = false;
        Tracker tracker = new Tracker();
        while (!exit) {
            
            //Print menu
            System.out.println("1. Add new item");
            System.out.println("2. Edit the item");
            System.out.println("3. Remove the item");
            System.out.println("4. Show all items");
            System.out.println("5. Show items by filter");
            System.out.println("6. Add new comment into the item");
            System.out.println("7. Exit");
            
            //Excute choose operatin
            String operation = this.input.ask("Select the operation: ");
            switch(operation){
                case "1":
                    String name = this.input.ask("Input a name of item: ");
                    String description = this.input.ask("Input a description of item: ");
                    tracker.addItem(new Item(name, description));
                    break;
                case "2":
                    String id = this.input.ask("Input the id of item: ");
                    name = this.input.ask("Input new name of item: ");
                    description = this.input.ask("Input new description of item: ");
                    Item itemEdit = new Item(name, description);
                    itemEdit.setId(id);
                    tracker.editItem(itemEdit);
                    break;
                case "3":
                    id = this.input.ask("Input the id of item: ");
                    tracker.removeItem(tracker.findById(id));
                    break;
                case "4":
                    for(Item item : tracker.getItems()){
                        System.out.println(item);
                    }
                    break;
                case "5":
                    String key = this.input.ask("Input the field for finding items: ");
                    String value = this.input.ask("Input the value of field for finding items: ");
                    for(Item item : tracker.getItems(new FilterFactory().getFilter(key, value))){
                        System.out.println(item);
                    }
                    break;
                case "6":
                    id = this.input.ask("Input the id of item: ");
                    String comment = this.input.ask("Input new comment for the item: ");
                    tracker.addComment(new Comment(id, comment));
                    break;
                case "7":
                    String answerExit = this.input.ask("Are you sure? Y/N: ");
                    if(answerExit.equals("Y")){
                        exit = true;
                    }
                    break;
            }
        }
        
        System.out.println("Bye-bye!");
    }
    
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }
    
}
