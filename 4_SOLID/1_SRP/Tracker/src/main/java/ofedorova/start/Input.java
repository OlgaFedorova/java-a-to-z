
package ofedorova.start;

/**
 * The interface is the model "Input".
 *
 * @author Olga Fedorova
 * @version 1
 * @since 20.08.2016
 */
public interface Input {

    /**
     * The method asks the question and returns an answer.
     *
     * @param question
     * @return answer
     */
    public String ask(String question);

    /**
     * The method asks number from the range.
     *
     * @param question
     * @param range
     * @return answer
     */
    public int ask(String question, int[] range);

}
