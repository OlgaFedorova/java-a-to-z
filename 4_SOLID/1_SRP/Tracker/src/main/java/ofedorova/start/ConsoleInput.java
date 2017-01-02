package ofedorova.start;

import java.util.Scanner;

/**
 * The class implements interface "Input" with class "Scanner".
 *
 * @author Olga Fedorova
 * @version 1
 * @since 22.08.2016
 */
public class ConsoleInput implements Input {

    /**
     * Object for working with console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * The method asks the question and returns a answer.
     *
     * @param question for user.
     * @return answer from user.
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.next();
    }

    /**
     * The method asks number from the range.
     *
     * @param question
     * @param range
     * @return answer
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        return this.checkNumberFromTheRange(key, range);
    }

    /**
     * The method checks to contains number "key" in the array of range.
     *
     * @param key
     * @param range
     * @return "key" if number is in the range, else throws "MenuOutException".
     */
    private int checkNumberFromTheRange(int key, int[] range) {
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }

}
