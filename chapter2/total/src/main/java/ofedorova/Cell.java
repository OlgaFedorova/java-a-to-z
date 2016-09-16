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

}
