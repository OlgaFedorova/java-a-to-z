package ofedorova.start;

import java.util.Scanner;

/**
 * The class implements interface "Input" with class "Scanner".
 * @author Olga Fedorova
 * @since 22.08.2016
 * @version 1
 */
public class ConsoleInput implements Input{
    
    private final Scanner scanner = new Scanner(System.in);

    /*
    *The method asks the question and returns a answer.
    *@return answer
    */
    @Override
    public String ask(String question)  {
        System.out.print(question);
        return scanner.next();
    }

    /*
    *The method asks number from the range.
    *@param question
    *@param range
    *@return answer
    */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for(int value : range){
            if(value == key){
                exist = true;
                break;                
            }
        }
        if (exist){
            return key;
        }
        else {
            throw new MenuOutException("Out of menu range");
        }
    }
    
}
