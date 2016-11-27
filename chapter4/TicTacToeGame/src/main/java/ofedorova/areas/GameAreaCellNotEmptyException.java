package ofedorova.areas;

/**
 * Exception for context, when cell of game area is not empty.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 22.11.2016
 */
public class GameAreaCellNotEmptyException extends Exception {

    /**
     * Allocates a new {@code GameAreaCellNotEmptyException}.
     *
     * @param message info about exception.
     */
    public GameAreaCellNotEmptyException(String message) {
        super(message);
    }
}
