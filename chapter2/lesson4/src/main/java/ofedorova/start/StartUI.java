package ofedorova.start;

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
    * The metod implements to work with menu of profram.
    */
    public void init(){
        
        Tracker tracker = new Tracker();
        MenuTracker menuTracker = new MenuTracker(input, tracker);
        menuTracker.fillAction();
        while (!menuTracker.isExit()) {
            
            //Print menu
            menuTracker.show();
            
            //Excute choose operatin
            String operation = this.input.ask("Select the operation: ");
            menuTracker.select(Integer.valueOf(operation));
        }
        
        System.out.println("Bye-bye!");
    }
    
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }
    
}
