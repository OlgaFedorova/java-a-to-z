package ofedorova.start;

import ofedorova.models.Comment;
import ofedorova.models.FilterFactory;
import ofedorova.models.Item;

/**
 * The class is used for controlling tracker.
 * @author Olga Fedorova
 * @since 27.08.2016
 * @version 1
 */
public class MenuTracker {
    
    private final Input input;
    private final Tracker tracker;
    private final UserAction[] actions = new UserAction[7];
    private boolean exit = false;
    
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    
    /*
    * The method fills the array "actions".
    */
    public void fillAction(){
        this.actions[0] = new AddNewItemAction();
        this.actions[1] = new EditAction();
        this.actions[2] = new RemoveAction();
        this.actions[3] = new ShowListItemsAction();
        this.actions[4] = new ShowListItemsByFilterAction();
        this.actions[5] = new AddNewCommentAction();
        this.actions[6] = new ExitAction();
        
    }
    
    /*
    * The method excutes selected action.
    */
    public void select(int key){
        this.actions[key-1].excute();
    }
    
    /*
    * The method prints info about available actions.
    */
    public void show(){
        for(UserAction action : this.actions){
            System.out.println(action.info());
        }
    }

    /*
    * Getter for the field "exit".
    */
    public boolean isExit() {
        return this.exit;
    }
    
    /*
    * The method returns range of numbers for actions.
    */
    public int[] getRange(){
        int[] result = new int[this.actions.length];
        int position = 0;
        for (UserAction action: this.actions){
            result[position++] = action.key();
        }
        return result;
    }
    
    private interface UserAction {
        /*
        * The method returns key of action.
        */
        public int key();
        
        /*
        * The method excutes action.
        */
        public void excute();
        
        /*
        * The method return info about action.
        */
        public String info();
    }
    
    /**
    * The class implements abstract action.
    * @author Olga Fedorova
    * @since 28.08.2016
    * @version 1
    */
    
    private abstract class BaseAction implements UserAction{
        
        private String name;

        public BaseAction(String name) {
            this.name = name;
        }

        /*
        * The method return info about action.
        */
        @Override
        public String info(){
            return String.format("%s. %s", this.key(), this.name);
        }

    }

    /**
    * The class implements command "Add new item".
    * @author Olga Fedorova
    * @since 27.08.2016
    * @version 1
    */
    private class AddNewItemAction extends BaseAction{

        public AddNewItemAction() {
            super("Add new item");
        }

        /*
        * The method returns key of action.
        */
        @Override
        public int key() {
            return 1;
        }

        /*
        * The method excutes action.
        */
        @Override
        public void excute() {
            String name = input.ask("Input a name of item: ");
            String description = input.ask("Input a description of item: ");
            tracker.addItem(new Item(name, description));
        }
    }
    
    /**
    * The class implements command "Edit item".
    * @author Olga Fedorova
    * @since 27.08.2016
    * @version 1
    */
    private class EditAction extends BaseAction{

        public EditAction() {
            super("Edit the item");
        }

        /*
        * The method returns key of action.
        */
        @Override
        public int key() {
            return 2;
        }

        /*
        * The method excutes action.
        */
        @Override
        public void excute() {
            String id = input.ask("Input the id of item: ");
            String name = input.ask("Input new name of item: ");
            String description = input.ask("Input new description of item: ");
            Item itemEdit = new Item(name, description);
            itemEdit.setId(id);
            tracker.editItem(itemEdit);
        }
    }
    
    /**
    * The class implements command "Remove item".
    * @author Olga Fedorova
    * @since 27.08.2016
    * @version 1
    */
    private class RemoveAction extends BaseAction{

        public RemoveAction() {
            super("Remove the item");
        }

        /*
        * The method returns key of action.
        */
        @Override
        public int key() {
            return 3;
        }

        /*
        * The method excutes action.
        */
        @Override
        public void excute() {
            String id = input.ask("Input the id of item: ");
            tracker.removeItem(tracker.findById(id));
        }
    }
    
    /**
    * The class implements command "Show all items".
    * @author Olga Fedorova
    * @since 27.08.2016
    * @version 1
    */
    private class ShowListItemsAction extends BaseAction{

        public ShowListItemsAction() {
            super("Show all items");
        }

        /*
        * The method returns key of action.
        */
        @Override
        public int key() {
            return 4;
        }

        /*
        * The method excutes action.
        */
        @Override
        public void excute() {
            for(Item item : tracker.getItems()){
                System.out.println(item);
            }
        }
    }
    
    /**
    * The class implements command "Show items by filter".
    * @author Olga Fedorova
    * @since 27.08.2016
    * @version 1
    */
    private class ShowListItemsByFilterAction extends BaseAction{

        public ShowListItemsByFilterAction() {
            super("Show items by filter");
        }

        /*
        * The method returns key of action.
        */
        @Override
        public int key() {
            return 5;
        }

        /*
        * The method excutes action.
        */
        @Override
        public void excute() {
            String key = input.ask("Input the field for finding items: ");
            String value = input.ask("Input the value of field for finding items: ");
            for(Item item : tracker.getItems(new FilterFactory().getFilter(key, value))){
                System.out.println(item);
            }
        }
    }
    
    /**
    * The class implements command "Add new comment into the item".
    * @author Olga Fedorova
    * @since 27.08.2016
    * @version 1
    */
    private class AddNewCommentAction extends BaseAction{

        public AddNewCommentAction() {
            super("Add new comment into the item");
        }

        /*
        * The method returns key of action.
        */
        @Override
        public int key() {
            return 6;
        }

        /*
        * The method excutes action.
        */
        @Override
        public void excute() {
            String id = input.ask("Input the id of item: ");
            String comment = input.ask("Input new comment for the item: ");
            tracker.addComment(new Comment(id, comment));
        }
    }
    
    /**
    * The class implements command "Exit".
    * @author Olga Fedorova
    * @since 27.08.2016
    * @version 1
    */
    private class ExitAction extends BaseAction{

        public ExitAction() {
            super("Exit");
        }

        /*
        * The method returns key of action.
        */
        @Override
        public int key() {
            return 7;
        }

        /*
        * The method excutes action.
        */
        @Override
        public void excute() {
            String answerExit = input.ask("Are you sure? Y/N: ");
            if(answerExit.equals("Y")){
                exit = true;
            }
        }
    }
}
