package ofedorova.start;

import ofedorova.start.Input;

/**
 * The class implements model "Input" with static dates.
 * @author Olga Fedorova
 * @since 24.08.2016
 * @version 1
 */
public class StubInput implements Input{
    /**
     * Array of answers.
     */
    private final String[] answers;
    /**
     * Position for current answer.
     */
    private int position = 0;

    /**
     * Allocates a new {@code StubInput}
     * @param answers 
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }


    /**
    * The method asks the question and returns a answer.
    * @param question
    * @return answer
    */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /**
    *The method asks number from the range.
    *@param question
    *@param range
    *@return answer
    */
    @Override
    public int ask(String question, int[] range) {
        return -1;
    }
    
}
