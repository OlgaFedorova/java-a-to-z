
package ofedorova.start;

/**
 * The interface is the model "Input".
 * @author Olga Fedorova
 * @since 20.08.2016
 * @version 1
 */
public interface Input {
    
    /*
    *The metod asks the question and returns a answer.
    *@return answer
    */
    public String ask(String question);
    
    /*
    *The metod asks number from the range.
    *@param question
    *@param range
    *@return answer
    */
    public int ask(String question, int[] range);
    
}
