package ofedorova.prototype;

/**
 * The interface implements opportunity to input data.
 *
 * @author Olga Fedorova
 * @since 29.10.2016
 * @version 1
 */
public interface Input {

    /**
     * The method asks user to input data.
     *
     * @return input data
     */
    String ask(String message);
}
