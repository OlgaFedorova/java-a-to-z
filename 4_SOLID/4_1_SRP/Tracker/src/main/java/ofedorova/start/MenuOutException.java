
package ofedorova.start;

/**
 * Exception for incorrect ate.
 *
 * @author Olga Fedorova
 * @version 1
 * @since 28.08.2016
 */
public class MenuOutException extends RuntimeException {

    /**
     * Allocates a new {@code MenuOutException}
     *
     * @param message
     */
    public MenuOutException(String message) {
        super(message);
    }

}
