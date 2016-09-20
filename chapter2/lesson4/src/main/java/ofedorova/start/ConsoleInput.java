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
    
}
