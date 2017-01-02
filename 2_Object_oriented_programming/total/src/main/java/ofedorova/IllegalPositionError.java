package ofedorova;

/**
 * The class implements error for an incorrect position of chessman.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class IllegalPositionError extends Exception{

    public IllegalPositionError(String message) {
        super(message);
    }
 
}
