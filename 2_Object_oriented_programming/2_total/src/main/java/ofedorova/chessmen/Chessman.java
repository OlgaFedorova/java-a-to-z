package ofedorova.chessmen;

import java.util.Objects;
import ofedorova.ChessBoard;
import ofedorova.IllegalPositionError;
import ofedorova.Position;

/**
 * The abstract class implements model of chessman.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public abstract class Chessman {
    
    private Position position;
    private final boolean isWhite;

    public Chessman(Position position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }

    /*
    * The method set new position
    */
    public void setPosition(Position position) {
        this.position = position;
    }

    /*
    * Getter for field "Position".
    */
    public Position getPosition() {
        return position;
    }

    /*
    * Check is white or black chessman
    */
    public boolean isWhite() {
        return this.isWhite;
    }
     
    /*
    * The method moves chessman to change position.
    * @param new position
    * @return array of position on path moving.
    * @throws IllegalPositionError, if new position is incorrect.
    */
    public abstract Position[] changePosition(Position newPosition) throws IllegalPositionError;
}
