package ofedorova.start;

/**
 * The class implements interface "Input" with class "Scanner" and check validate.
 * @author Olga Fedorova
 * @since 28.08.2016
 * @version 1
 */
public class ValidateInput extends ConsoleInput{

    /*
    *The method asks number from the range.
    *@param question
    *@param range
    *@return answer
    */
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do{
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter validate date again");
            }
        } while (invalid);
        return value;
    }
    
}
