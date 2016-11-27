package ofedorova.gamers;

import ofedorova.businesslogic.AlgoritmeComputerGamer;
import ofedorova.areas.GameArea;
import ofedorova.areas.Symbol;
import ofedorova.interfaces.UserInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Class implements model of computer gamer.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @see {@linktourl https://habrahabr.ru/post/209544/}
 * @since 23.11.2016
 */
public class ComputerGamer extends Gamer {
    /**
     * Game area.
     */
    private final GameArea gameArea;
    /**
     * Object for work with algoritm of Artificial Intelligence.
     */
    private final AlgoritmeComputerGamer algoritmeComputerGamer;

    /**
     * Allocates a new {@code ComputerGamer}.
     *
     * @param symbol      value of field ""symbol.
     * @param countForWin count for win.
     * @param gameArea    value of field "gameArea".
     */
    public ComputerGamer(Symbol symbol, GameArea gameArea, int countForWin) {
        super("Computer", symbol);
        this.gameArea = gameArea;
        this.algoritmeComputerGamer = new AlgoritmeComputerGamer(countForWin);
    }

    /**
     * Method for moving gamer.
     *
     * @param userInterface user interface for work game.
     * @return map of coordinates X and Y.
     */
    @Override
    public Map<String, Integer> doStep(UserInterface userInterface) {
        final Symbol[][] gameArea = this.gameArea.getArea();
        final Map<String, Integer> coordinatesForMoving = this.algoritmeComputerGamer.getCoordinatesForMovingComputer(this.getSymbol(), gameArea);
        Map<String, Integer> coordinates;
        if (!coordinatesForMoving.isEmpty()) {
            coordinates = coordinatesForMoving;
        } else {
            coordinates = new HashMap<>();
            coordinates.put("X", gameArea.length / 2);
            coordinates.put("Y", gameArea.length / 2);
        }
        return coordinates;
    }
}
