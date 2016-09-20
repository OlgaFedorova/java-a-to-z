/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofedorova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class implement interactive calculator.
 * @author Olga Fedorova
 * @since 19.09.2016
 * @version 1
 */
public class InteractCalc extends Calculator{
    /**
     * Array of action menu
     */
    private final Action[] actions = new Action[6];
    /**
     * Sign that needs to exit from program.
     */
    private boolean exit = false;
    /**
     * First operand.
     */
    private double first;
    /**
     * Second operand.
     */
    private double second;
    /**
     * Sign that needs to use last calculation.
     */
    private boolean useLastCalculation;
    /**
     * Object for working with console.
     */
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Allocates a new {@code InteractCalc}
     */
    public InteractCalc() {
        this.setOperandsForStart();
        this.fillAction();
    }

    /**
     * Getter for field "exit".
     * @return exit
     */
    public boolean isExit() {
        return this.exit;
    }

    /**
     * Setter for field "exit".
     * @param exit 
     */
    public void setExit(boolean exit) {
        this.exit = exit;
    }
    
    /**
     * The methods sets values for the first and the second operands for use last calculation.
     */
    public void setOperandsForUseLastCalculation(){
        this.first = this.getResult();
        this.second = 0;
        this.useLastCalculation = true;
    }
    
    /**
     * The methods sets values for the first and the second operands for start calculation.
     */
    public void setOperandsForStart(){
        this.first = 0;
        this.second = 0;
        this.useLastCalculation = false;
    }
    
    /**
    * The method asks the question and returns an answer.
    * @param question for user
    * @return answer from user
    * @throws IOException
    */
    public String ask(String question) throws IOException  {
        System.out.println(question);
        return reader.readLine();
    }
    
    /**
    * The method excutes selected action.
    * @param key for action.
    */
    public void select(String key){
        for(Action action : this.actions){
            if(key != null && key.equalsIgnoreCase(action.getKey())){
                action.excute();
                break;
            }
        }
    }
    
    /**
    * The method prints info about available actions.
    */
    public void show(){
        for(Action action : this.actions){
            System.out.println(action.info());
        }
    }
    
    /**
    * The method fills the array "actions".
    */
    public void fillAction(){
        this.actions[0] = new AddingAction();
        this.actions[1] = new SubtractionAction();
        this.actions[2] = new DivisionAction();
        this.actions[3] = new MultiplicationAction();
        this.actions[4] = new ClearAction();
        this.actions[5] = new ExitAction();
    }
 
    /**
    * The method implements to work with menu of program.
    */
    public void init(){
        this.show();
        while (!this.isExit()) {
            try {
                if(!this.useLastCalculation){
                    this.first = new Double(this.ask("Input first operand:"));
                }
                this.select(this.ask("Select the operation:"));
            } catch (IOException ex) {
                Logger.getLogger(InteractCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Bye-bye!");
    }
    
    /**
    * The class implements abstract action.
    * @author Olga Fedorova
    * @since 19.09.2016
    * @version 1
    */
    protected abstract class Action{
        /**
         * Name of action.
         */
        private final String name;
        /**
         * Key for action.
         */
        private final String key;

        /**
         * Allocates a new {@code Action}
         * @param key
         * @param name 
         */
        public Action(String key, String name) {
            this.name = name;
            this.key = key;
        }

        /**
        * The method return info about action.
        * @return a string representation
        */
        public String info(){
            return String.format("%s - %s", this.key, this.name);
        }

        /**
         * Getter for field "key"
         * @return key
         */
        public String getKey() {
            return this.key;
        }
        
        /**
        * The method excutes action.
        */
        public abstract void excute();

    }
    
    /**
    * The class implements adding action.
    * @author Olga Fedorova
    * @since 19.09.2016
    * @version 1
    */
    private class AddingAction extends Action{

        /**
         * Allocates a new {@code AddingAction}
         * @param key
         * @param name 
         */
        public AddingAction() {
            super("+", "Adding");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            try {
                InteractCalc.this.second = new Double(InteractCalc.this.ask("Input second operand:"));
                InteractCalc.this.add(InteractCalc.this.first, InteractCalc.this.second);
                InteractCalc.this.setOperandsForUseLastCalculation();
                System.out.println("Result: " + InteractCalc.this.getResult());
            } catch (IOException ex) {
                Logger.getLogger(InteractCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
    * The class implements subtraction action.
    * @author Olga Fedorova
    * @since 19.09.2016
    * @version 1
    */
    private class SubtractionAction extends Action{

        /**
         * Allocates a new {@code SubtractionAction}
         * @param key
         * @param name 
         */
        public SubtractionAction() {
            super("-", "Subtraction");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            try {
                InteractCalc.this.second = new Double(InteractCalc.this.ask("Input second operand:"));
                InteractCalc.this.substruct(InteractCalc.this.first, InteractCalc.this.second);
                InteractCalc.this.setOperandsForUseLastCalculation();
                System.out.println("Result: " + InteractCalc.this.getResult());
            } catch (IOException ex) {
                Logger.getLogger(InteractCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
    * The class implements division action.
    * @author Olga Fedorova
    * @since 19.09.2016
    * @version 1
    */
    private class DivisionAction extends Action{

        /**
         * Allocates a new {@code DivisionAction}
         * @param key
         * @param name 
         */
        public DivisionAction() {
            super("/", "Division");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            try {
                InteractCalc.this.second = new Double(InteractCalc.this.ask("Input second operand:"));
                InteractCalc.this.div(InteractCalc.this.first, InteractCalc.this.second);
                InteractCalc.this.setOperandsForUseLastCalculation();
                System.out.println("Result: " + InteractCalc.this.getResult());
            } catch (IOException ex) {
                Logger.getLogger(InteractCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
    * The class implements multiplication action.
    * @author Olga Fedorova
    * @since 19.09.2016
    * @version 1
    */
    private class MultiplicationAction extends Action{

        /**
         * Allocates a new {@code MultiplicationAction}
         * @param key
         * @param name 
         */
        public MultiplicationAction() {
            super("*", "Multiplication");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            try {
                InteractCalc.this.second = new Double(InteractCalc.this.ask("Input second operand:"));
                InteractCalc.this.multiple(InteractCalc.this.first, InteractCalc.this.second);
                InteractCalc.this.setOperandsForUseLastCalculation();
                System.out.println("Result: " + InteractCalc.this.getResult());
            } catch (IOException ex) {
                Logger.getLogger(InteractCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
    * The class implements clear action.
    * @author Olga Fedorova
    * @since 19.09.2016
    * @version 1
    */
    private class ClearAction extends Action{

        /**
         * Allocates a new {@code ClearAction}
         * @param key
         * @param name 
         */
        public ClearAction() {
            super("C", "Clear");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            InteractCalc.this.setOperandsForStart();
        }
    }
    
     /**
    * The class implements command "Exit".
    * @author Olga Fedorova
    * @since 19.09.2016
    * @version 1
    */
    private class ExitAction extends Action{

        /**
         * Allocates a new {@code ExitAction}
         */
        public ExitAction() {
            super("Exit", "Exit");
        }

        /**
        * The method excutes action.
        */
        @Override
        public void excute() {
            try {
                String answerExit = InteractCalc.this.ask("Are you sure? Y/N: ");
                if(answerExit.equalsIgnoreCase("Y")){
                    InteractCalc.this.exit = true;
                }
            } catch (IOException ex) {
                Logger.getLogger(InteractCalc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        new InteractCalc().init();
    }

}
