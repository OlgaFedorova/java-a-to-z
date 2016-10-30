package ofedorova;

import ofedorova.DataBase.UserOfDBFactory;

/**
 * The class starts the program.
 *
 * @author Olga Fedorova
 * @since 29.10.2016
 * @version 1
 */
public class Start {

    /**
     * Menu for management of storage users.
     */
    private final Menu menu;

    /**
     * Allocates a new {@code Start}
     *
     * @param menu value for field "menu"
     */
    public Start(Menu menu) {
        this.menu = menu;
    }

    /**
     * The method implements to work with menu of program.
     */
    public void init() {
        while (!this.menu.isExit()) {
            this.menu.show();
            this.menu.select(Integer.parseInt(this.menu.ask("Select action.")));
        }
        System.out.println("Bye-bye!");
    }

    /**
     * The main method for starting program.
     *
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu(new UserOfDBFactory());
        menu.fillAction();
        new Start(menu).init();
    }

}
