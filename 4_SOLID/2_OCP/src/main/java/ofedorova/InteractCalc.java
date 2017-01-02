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
     * Object for logging exception.
     */
    public final static Logger LOGER = Logger.getLogger(InteractCalc.class.getName());
    /**
     * Object for working with console.
     */
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * Array of action menu
     */
    private Action[] actions = new Action[6];
    /**
     * Position for adding new action in the array "actions".
     */
    private int position = 0;
    /**
     * Sign that needs to exit from program.
     */
    private boolean exit = false;
    /**
     * First operand.
     */
    private double operand;
    /**
     * Sign that needs to use last calculation.
     */
    private boolean useLastCalculation;
    
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
     * Getter for field "operand"
     * @return 
     */
    public double getOperand() {
        return this.operand;
    }

    /**
     * Setter for field "operand"
     * @param operand 
     */
    public void setOperand(double operand) {
        this.operand = operand;
    }
    
    /**
     * The methods sets values the operand for use last calculation.
     */
    public void setOperandsForUseLastCalculation(){
        this.operand = this.getResult();
        this.useLastCalculation = true;
    }
    
    /**
     * The methods sets values operand for start calculation.
     */
    public void setOperandsForStart(){
        this.operand = 0;
        this.useLastCalculation = false;
    }
    
    /**
    * The method asks the question and returns an answer.
    * @param question for user
    * @return answer from user
    */
    public String ask(String question)  {
        String result = null;
        try {
            System.out.println(question);
            result = reader.readLine();
        } catch (IOException ex) {
            LOGER.log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /**
    * The method asks enter number and return it.
    * @param question for user
    * @return number
    */
    public double askDouble(String question) {
        boolean isNumber = false;
        double number = 0;
        while(!isNumber){
            try {
                number = Double.parseDouble(this.ask(question));
                isNumber = true;
            } catch (NumberFormatException ex) {
                LOGER.log(Level.INFO, "Incorrect input double number. Try again.");
            }
        }
        return number;
    }
    
    /**
    * The method excutes selected action.
    * @param key for action.
    * @return true or false
    */
    public boolean select(String key){
        boolean isSelect = false;
        for(Action action : this.getActions()){
            if(key != null && key.equalsIgnoreCase(action.getKey())){
                action.excute();
                isSelect = true;
                break;
            }
        }
        return isSelect;
    }
    
    /**
    * The method prints info about available actions.
    */
    public void show(){
        for(Action action : this.getActions()){
            System.out.println(action.info());
        }
    }
    
    /**
    * The method fills the array "actions".
    */
    public void fillAction(){
        this.addAction(new AddingAction());
        this.addAction(new SubtractionAction());
        this.addAction(new DivisionAction());
        this.addAction(new MultiplicationAction());
        this.addAction(new ClearAction());
        this.addAction(new ExitAction());
    }
    
    /**
     * The method adds new Action into the array "actions".
     * @param action 
     */
    public void addAction(Action action){
        if (this.position == this.actions.length){
            Action[] temp = new Action[position + 10];
            System.arraycopy(this.actions, 0, temp, 0, position);
            this.actions = temp;    
        }
        this.actions[position++] = action;
    }

    /**
     * Getter for field "actions"
     * @return array of actions
     */
    public Action[] getActions() {
        Action[] result = new Action[position];
        System.arraycopy(this.actions, 0, result, 0, position);
        return result;
    }
 
    /**
    * The method implements to work with menu of program.
    */
    public void init(){
        this.show();
        while (!this.isExit()) {
            if(!this.useLastCalculation){
                this.operand = this.askDouble("Input operand:");
            }
            while(this.select(this.ask("Select the operation:")) != true){
                System.out.println("Incorrect select operation. Try again.");
            }

        }
        System.out.println("Bye-bye!");
    }
    
    /**
     * The method print result in console
     */
    public void showResult(){
        System.out.println(String.format("Result: %s", InteractCalc.this.getResult()));
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
            double second = new Double(InteractCalc.this.ask("Input operand:"));
            InteractCalc.this.add(InteractCalc.this.operand, second);
            InteractCalc.this.setOperandsForUseLastCalculation();
            InteractCalc.this.showResult();
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
            double second = new Double(InteractCalc.this.ask("Input operand:"));
            InteractCalc.this.substruct(InteractCalc.this.operand, second);
            InteractCalc.this.setOperandsForUseLastCalculation();
            InteractCalc.this.showResult();
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
            double second = new Double(InteractCalc.this.ask("Input operand:"));
            InteractCalc.this.div(InteractCalc.this.operand, second);
            InteractCalc.this.setOperandsForUseLastCalculation();
            InteractCalc.this.showResult();
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
            double second = new Double(InteractCalc.this.ask("Input operand:"));
            InteractCalc.this.multiple(InteractCalc.this.operand, second);
            InteractCalc.this.setOperandsForUseLastCalculation();
            InteractCalc.this.showResult();
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
            String answerExit = InteractCalc.this.ask("Are you sure? Y/N: ");
            if(answerExit.equalsIgnoreCase("Y")){
                InteractCalc.this.exit = true;
            }
        }
    }
    
    public static void main(String[] args) {
        new InteractCalc().init();
    }

}
