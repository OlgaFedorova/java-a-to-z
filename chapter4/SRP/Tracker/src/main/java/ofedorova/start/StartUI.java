package ofedorova.start;

/**
 * The class starts the program.
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public class StartUI {
    
    /**
     * Object for input info.
     */
    private final Input input;
    /**
     * Menu for management of storage items.
     */
    private final MenuTracker menu;

    /**
     * Default constructor.
     * @param input
     * @param menu 
     */
    public StartUI(final Input input, final MenuTracker menu) {
        this.input = input;
        this.menu = menu;
    }
    
    /**
    * The method implements to work with menu of program.
    */
    public void init(){
        while (!this.menu.isExit()) {
            this.menu.show();
            this.menu.select(this.input.ask("Select the operation: ", this.menu.getRange()));
        }
        
        System.out.println("Bye-bye!");
    }
    
    /**
     * The main method for starting program.
     * @param args 
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillAction();
        new StartUI(input, menu).init();
    }
    
}
