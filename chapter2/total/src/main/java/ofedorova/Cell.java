package ofedorova;

import java.util.Objects;
import ofedorova.chessmen.Chessman;

/**
 * The class implements a cell of chessboard.
 * @author Olga Fedorova
 * @since 16.09.2016
 * @version 1
 */
public class Cell {
    private final Position position;
    private Chessman chessman;

    public Cell(Position position) {
        this.position = position;
    }

    /*
    * Getter for field "chessman".
    */
    public Chessman getChessman() {
        return this.chessman;
    }

    /*
    *Setter for field "chessman". 
    */
    public void setChessman(Chessman chessman) {
        this.chessman = chessman;
    }

    /*
    *Getter for field "position".
    */
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.position);
        hash = 79 * hash + Objects.hashCode(this.chessman);
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
        final Cell other = (Cell) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.chessman, other.chessman)) {
            return false;
        }
        return true;
    }
    
    
    
}
