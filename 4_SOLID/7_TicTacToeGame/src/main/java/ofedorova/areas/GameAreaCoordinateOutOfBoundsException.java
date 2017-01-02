package ofedorova.areas;

/**
 * Exception for context, when coordinate is out of bounds game area.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 22.11.2016
 */
public class GameAreaCoordinateOutOfBoundsException extends Exception {

    /**
     * Allocates a new {@code GameAreaCoordinateOutOfBoundsException}.
     *
     * @param message info about exception.
     */
    public GameAreaCoordinateOutOfBoundsException(String message) {
        super(message);
    }
}
