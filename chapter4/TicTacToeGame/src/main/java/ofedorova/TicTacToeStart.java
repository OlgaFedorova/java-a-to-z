package ofedorova;

import ofedorova.interfaces.ConsoleUserInterface;

/**
 * Main class for start game "TicTacToe".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.11.2016
 */
public class TicTacToeStart {
    /**
     * Main method for start game.
     *
     * @param args for start programm.
     */
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(new ConsoleUserInterface());
        ticTacToe.startGame();
    }
}
