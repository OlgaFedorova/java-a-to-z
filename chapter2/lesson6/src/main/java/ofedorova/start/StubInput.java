package ofedorova.start;

import ofedorova.start.Input;

/**
 * The class implements model "Input" with static datas.
 * @author Olga Fedorova
 * @since 24.08.2016
 * @version 1
 */
public class StubInput implements Input{
    private final String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }


    /*
    *The metod asks the question and returns a answer.
    *@return answer
    */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    /*
    *The metod asks number from the range.
    *@param question
    *@param range
    *@return answer
    */
    @Override
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        return -1;
    }
    
}
