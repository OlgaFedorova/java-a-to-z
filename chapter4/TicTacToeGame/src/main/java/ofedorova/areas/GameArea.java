package ofedorova.areas;

import java.util.Arrays;

/**
 * Class implements model of game area.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 22.11.2016
 */
public class GameArea {
    /**
     * Array of symbols game area.
     */
    private final Symbol[][] area;
    /**
     * Count of free cells.
     */
    private int countOfFreeCells;

    /**
     * Allocates a new {@code GameArea}.
     *
     * @param size of game area.
     */
    public GameArea(int size) {
        this.area = new Symbol[size][size];
        this.countOfFreeCells = size * size;
        this.initilize();
    }

    /**
     * Method initilizes first state of game area.
     */
    private void initilize() {
        for (int y = 0; y < this.area.length; y++) {
            for (int x = 0; x < this.area[y].length; x++) {
                this.area[y][x] = Symbol.SYMBOL_NULL;
            }
        }
    }

    /**
     * Method add new symbol in game area.
     *
     * @param x      coordinate x of new symbol.
     * @param y      coordinate y of new symbol.
     * @param symbol for adding.
     * @throws GameAreaCoordinateOutOfBoundsException when coordinate is out of bounds game area.
     * @throws GameAreaCellNotEmptyException          when cell of game area is not empty.
     */
    public void addSymbol(int x, int y, Symbol symbol) throws GameAreaCoordinateOutOfBoundsException, GameAreaCellNotEmptyException {
        if (y >= this.area.length) {
            throw new GameAreaCoordinateOutOfBoundsException("Coordinate Y is out of bounds game area.");
        } else if (x >= this.area[y].length) {
            throw new GameAreaCoordinateOutOfBoundsException("Coordinate X is out of bounds game area.");
        } else if (this.area[y][x] != Symbol.SYMBOL_NULL) {
            throw new GameAreaCellNotEmptyException("Cell with coordinate is not empty.");
        } else {
            this.area[y][x] = symbol;
            this.countOfFreeCells--;
        }
    }

    /**
     * Getter for field "area".
     *
     * @return immutable value of field "area".
     */
    public Symbol[][] getArea() {
        return Arrays.copyOf(this.area, this.area.length);
    }

    /**
     * Method check free cells.
     *
     * @return if has free cells return true, else return false.
     */
    public boolean hasFreeCells() {
        return this.countOfFreeCells != 0;
    }
}
