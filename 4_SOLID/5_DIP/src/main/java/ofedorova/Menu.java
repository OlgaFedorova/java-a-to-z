package ofedorova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import ofedorova.prototype.Input;
import ofedorova.prototype.User;
import ofedorova.prototype.UserFactory;
import ofedorova.prototype.VerifierForUser;

/**
 * The class is used for works with user.
 *
 * @author Olga Fedorova
 * @since 29.10.2016
 * @version 1
 */
public class Menu implements Input {

    /**
     * Repository of gamers.
     */
    private final Repository repository;
    /**
     * Verifier for values of fields user.
     */
    private final VerifierForUser verifierForUser;

    /**
     * Array with actions for user.
     */
    private final List<Action> actions = new ArrayList<>();
    /**
     * Sign that needs to exit from program.
     */
    private boolean exit = false;
    /*
    * Reader for input data
     */
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Allocates a new {@code MenuUsers}
     *
     * @param userFactory
     */
    public Menu(UserFactory userFactory) {
        this.repository = new Repository(userFactory);
        this.verifierForUser = userFactory.getVerifierForUser();
    }

    /**
     * The method fills the array "actions".
     */
    public void fillAction() {
        this.actions.add(new AddNewUser(1, "Add new user"));
        this.actions.add(new EditUser(2, "Edit user"));
        this.actions.add(new RemoveUser(3, "Remove user"));
        this.actions.add(new ShowUsers(4, "Show list of gamers"));
        this.actions.add(new ExitAction(5, "Exit"));

    }

    /**
     * The method excutes selected action.
     *
     * @param key for action.
     */
    public void select(int key) {
        for (Action action : this.actions) {
            if (action.key() == key) {
                action.excute();
            }
        }
    }

    /**
     * The method prints info about available actions.
     */
    public void show() {
        for (Action action : this.actions) {
            System.out.println(action.info());
        }
    }

    /**
     * Getter for the field "exit".
     *
     * @return value of field "exit".
     */
    public boolean isExit() {
        return this.exit;
    }

    /**
     * The method asks user to input data.
     *
     * @param message about input
     * @return input data
     */
    @Override
    public String ask(String message) {
        System.out.println(message);
        String result;
        try {
            result = reader.readLine();
        } catch (IOException ex) {
            result = new String();
        }
        return result;
    }

    /**
     * The method asks user to input name of user.
     *
     * @return input name of user
     */
    private String askName() {
        String name = null;
        boolean nameCorrect = false;

        while (!nameCorrect) {
            name = this.ask("Input name of user");
            nameCorrect = this.verifierForUser.checkName(name);
            if (!nameCorrect) {
                System.out.println("Name is incorrect!");
            }
        }

        return name;

    }

    /**
     * The method asks user to input age of user.
     *
     * @return input age of user
     */
    private String askAge() {
        String age = null;
        boolean ageCorrect = false;

        while (!ageCorrect) {
            age = this.ask("Input age of user");
            ageCorrect = this.verifierForUser.checkAge(age);
            if (!ageCorrect) {
                System.out.println("Age is incorrect!");
            }
        }

        return age;
    }

    /**
     * The method asks user to input id of user.
     *
     * @return input id of user
     */
    private String askId() {
        String id = null;
        boolean idCorrect = false;

        while (!idCorrect) {
            id = this.ask("Input id of user");
            idCorrect = this.verifierForUser.checkId(id);
            if (!idCorrect) {
                System.out.println("Id is incorrect!");
            }
        }
        return id;
    }

    /**
     * The class implements abstract action.
     *
     * @author Olga Fedorova
     * @since 29.10.2016
     * @version 1
     */
    private abstract class Action {

        /**
         * Name of action.
         */
        private final String name;
        /**
         * Key foe action
         */
        private final int key;

        /**
         * Allocates a new {@code Action}
         *
         * @param key value of field "key"
         * @param name value of field "name"
         */
        public Action(int key, String name) {
            this.key = key;
            this.name = name;
        }

        /**
         * The method return info about action.
         *
         * @return a string representation
         */
        public String info() {
            return String.format("%s. %s", this.key, this.name);
        }

        /**
         * The method returns key of action.
         *
         * @return key for action
         */
        public int key() {
            return this.key;
        }

        /**
         * The method excutes action.
         */
        public abstract void excute();
    }

    /**
     * The class implements command "Add new user".
     *
     * @author Olga Fedorova
     * @since 29.10.2016
     * @version 1
     */
    private class AddNewUser extends Action {

        /**
         * Allocates a new {@code AddNewUser}
         *
         * @param key value of field "key"
         * @param name value of field "name"
         */
        public AddNewUser(int key, String name) {
            super(key, name);
        }

        /**
         * The method excutes action.
         */
        @Override
        public void excute() {
            String name = Menu.this.askName();
            String age = Menu.this.askAge();
            if(!Menu.this.repository.create(name, age)){
                System.out.println("User isn't creating.");
            }
        }
    }

    /**
     * The class implements command "Edit user".
     *
     * @author Olga Fedorova
     * @since 29.10.2016
     * @version 1
     */
    private class EditUser extends Action {

        /**
         * Allocates a new {@code EditUser}
         *
         * @param key value of field "key"
         * @param name value of field "name"
         */
        public EditUser(int key, String name) {
            super(key, name);
        }

        /**
         * The method excutes action.
         */
        @Override
        public void excute() {
            String id = Menu.this.askId();
            String name = Menu.this.askName();
            String age = Menu.this.askAge();
            if(!Menu.this.repository.edit(id, name, age)){
                System.out.println("User isn't edit.");
            }
        }
    }

    /**
     * The class implements command "Remove user".
     *
     * @author Olga Fedorova
     * @since 29.10.2016
     * @version 1
     */
    private class RemoveUser extends Action {

        /**
         * Allocates a new {@code RemoveUser}
         *
         * @param key value of field "key"
         * @param name value of field "name"
         */
        public RemoveUser(int key, String name) {
            super(key, name);
        }

        /**
         * The method excutes action.
         */
        @Override
        public void excute() {
            String id = Menu.this.askId();
            if(!Menu.this.repository.remove(id)){
                System.out.println("User isn't removing.");
            }
        }
    }

    /**
     * The class implements command "Show list of gamers".
     *
     * @author Olga Fedorova
     * @since 29.10.2016
     * @version 1
     */
    private class ShowUsers extends Action {

        /**
         * Allocates a new {@code ShowUsers}
         *
         * @param key value of field "key"
         * @param name value of field "name"
         */
        public ShowUsers(int key, String name) {
            super(key, name);
        }

        /**
         * The method excutes action.
         */
        @Override
        public void excute() {
            for (User user : Menu.this.repository.getUsers()) {
                System.out.println(user.toString());
            }
        }
    }

    /**
     * The class implements command "Exit".
     *
     * @author Olga Fedorova
     * @since 29.10.2016
     * @version 1
     */
    private class ExitAction extends Action {

        /**
         * Allocates a new {@code ExitAction}
         *
         * @param key value of field "key"
         * @param name value of field "name"
         */
        public ExitAction(int key, String name) {
            super(key, name);
        }

        /**
         * The method excutes action.
         */
        @Override
        public void excute() {
            String answerExit = Menu.this.ask("Are you sure? Y/N: ");
            if (answerExit.equalsIgnoreCase("Y")) {
                Menu.this.exit = true;
            }
        }
    }

}
