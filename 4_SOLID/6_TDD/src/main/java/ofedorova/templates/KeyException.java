package ofedorova.templates;

/**
 * Exception? when key is not found or the key is extra.
 * @since 19.11.2016
 * @author Olga Fedorova
 * @version 1.0
 */
public class KeyException extends Exception {
    /**
     * Allocates a new {@code KeyException}.
     *
     * @param message info about exception
     */
    public KeyException(String message) {
        super(message);
    }
}
