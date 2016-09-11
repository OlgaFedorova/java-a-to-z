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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.position);
        hash = 97 * hash + (this.isWhite ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chessman other = (Chessman) obj;
        if (this.isWhite != other.isWhite) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }
    
     
    /*
    * The method moves chessman to change position.
    * @param board, new position
    * @return true or false
    * @throws IllegalPositionError, if new position is incorrect.
    */
    public abstract boolean changePosition(ChessBoard board, Position newPosition) throws IllegalPositionError;
}
