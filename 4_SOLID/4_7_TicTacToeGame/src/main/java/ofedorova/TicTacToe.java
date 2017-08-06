package ofedorova;

import ofedorova.areas.GameArea;
import ofedorova.areas.GameAreaCellNotEmptyException;
import ofedorova.areas.GameAreaCoordinateOutOfBoundsException;
import ofedorova.areas.Symbol;
import ofedorova.businesslogic.AlgoritmForDetermineWinner;
import ofedorova.gamers.ComputerGamer;
import ofedorova.gamers.Gamer;
import ofedorova.gamers.User;
import ofedorova.interfaces.UserInterface;

import java.io.IOException;
import java.util.Map;


/**
 * Class for manage game "TicTacToe".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 25.11.2016
 */
public class TicTacToe {
    /**
     * Object for work with user interface.
     */
    private final UserInterface userInterface;
    /**
     * Object of area game.
     */
    private GameArea gameArea;
    /**
     * Current gamer.
     */
    private Gamer currentGamer;
    /**
     * User gamer.
     */
    private Gamer user;
    /**
     * Computer gamer.
     */
    private Gamer computer;
    /**
     * Object for work wirh logic game.
     */
    private AlgoritmForDetermineWinner algoritmsGame;
    /**
     * Count for win.
     */
    private int countForWin;

    /**
     * Allocates a new {@code TicTacToe}.
     *
     * @param userInterface value of field "userInterface".
     */
    public TicTacToe(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    /**
     * Method initilize size of area game with user interface.
     *
     * @return size of area game.
     */
    private int initilizeSizeAreaGame() {
        this.userInterface.printInfo("Input size of area game:");
        boolean sizeCorrect = false;
        int size = -1;
        while (!sizeCorrect) {
            try {
                size = Integer.parseInt(this.userInterface.input());
                if (size < 2) {
                    throw new NumberFormatException();
                }
                sizeCorrect = true;
            } catch (IOException | NumberFormatException e) {
                this.userInterface.printInfo("Input size is incorrect. Try again.");
            }
        }
        return size;
    }

    /**
     * Method initilize count for win with user interface.
     *
     * @param size size of area game.
     */
    private void initilizeCountForWin(int size) {
        this.userInterface.printInfo("Input count for win of area game:");
        boolean countForWinCorrect = false;
        while (!countForWinCorrect) {
            try {
                this.countForWin = Integer.parseInt(this.userInterface.input());
                if (this.countForWin <= 0 || this.countForWin > size) {
                    throw new NumberFormatException();
                }
                countForWinCorrect = true;
            } catch (IOException | NumberFormatException e) {
                this.userInterface.printInfo("Input count for win is incorrect. Try again.");
            }
        }
    }

    /**
     * Method initilize field "gameArea" and "algoritmsGame".
     */
    private void initilizeGameArea() {
        final int size = this.initilizeSizeAreaGame();
        this.initilizeCountForWin(size);
        this.gameArea = new GameArea(size);
        this.algoritmsGame = new AlgoritmForDetermineWinner(this.countForWin);
    }

    /**
     * Method initilize name of user with user interface.
     *
     * @return name of user.
     */
    private String initilizeNameOfUser() {
        this.userInterface.printInfo("Input name of user:");
        boolean nameOfUserCorrect = false;
        String nameOfUser = null;
        while (!nameOfUserCorrect) {
            try {
                nameOfUser = this.userInterface.input();
                nameOfUserCorrect = true;
            } catch (IOException e) {
                this.userInterface.printInfo("Input name of user is incorrect. Try again.");
            }
        }
        return nameOfUser;
    }

    /**
     * Method initilize symbol of user with user interface.
     *
     * @return symbol of user.
     */
    private Symbol initilizeSymbolOfUser() {

        this.userInterface.printInfo("Select symbol for user X or O");
        boolean symbolOfUserCorrect = false;
        Symbol symbolOfUser = null;
        while (!symbolOfUserCorrect) {
            try {
                String inputText = this.userInterface.input();
                if (inputText != null && inputText.equalsIgnoreCase("x")) {
                    symbolOfUser = Symbol.SYMBOL_X;
                } else if (inputText != null && (inputText.equalsIgnoreCase("o") || inputText.equals("0"))) {
                    symbolOfUser = Symbol.SYMBOL_O;
                } else {
                    throw new IOException();
                }
                symbolOfUserCorrect = true;
            } catch (IOException e) {
                this.userInterface.printInfo("Select symbol for user is incorrect. Try again.");
            }
        }

        return symbolOfUser;

    }

    /**
     * Method initilize field "user".
     */
    private void initilizeUser() {
        final String nameOfUser = this.initilizeNameOfUser();
        final Symbol symbolOfUser = this.initilizeSymbolOfUser();
        this.user = new User(nameOfUser, symbolOfUser);
    }

    /**
     * Method initilize field "computer".
     */
    private void initilizeComputer() {
        if (this.user.getSymbol().equals(Symbol.SYMBOL_O)) {
            this.computer = new ComputerGamer(Symbol.SYMBOL_X, this.gameArea, this.countForWin);
        } else {
            this.computer = new ComputerGamer(Symbol.SYMBOL_O, this.gameArea, this.countForWin);
        }
    }

    /**
     * Method initilize field "currentGamer".
     */
    private void initilizeCurrentGamer() {
        this.userInterface.printInfo("User is first gamer? Y/N");
        boolean inputCorrect = false;
        while (!inputCorrect) {
            try {
                String inputText = this.userInterface.input();
                if (inputText != null && inputText.equalsIgnoreCase("y")) {
                    this.currentGamer = this.user;
                } else if (inputText != null && inputText.equalsIgnoreCase("n")) {
                    this.currentGamer = this.computer;
                } else {
                    throw new IOException();
                }
                inputCorrect = true;
            } catch (IOException e) {
                this.userInterface.printInfo("Input is incorrect. Try again.");
            }
        }
    }

    /**
     * Method initilize first state for start game.
     */
    private void initilize() {
        this.initilizeGameArea();
        this.initilizeUser();
        this.initilizeComputer();
        this.initilizeCurrentGamer();
    }

    /**
     * Method implement logic of moving for current gamer.
     *
     * @return coordinates X and Y for moving.
     */
    private Map<String, Integer> doStepForCurrentGamer() {
        boolean stepCorrect = false;
        Map<String, Integer> coordinates = null;
        while (!stepCorrect) {
            try {
                coordinates = this.currentGamer.doStep(this.userInterface);
                this.gameArea.addSymbol(coordinates.get("X"), coordinates.get("Y"), this.currentGamer.getSymbol());
                stepCorrect = true;
            } catch (GameAreaCoordinateOutOfBoundsException | GameAreaCellNotEmptyException e) {
                this.userInterface.printInfo(String.format("%s Try again.", e.getMessage()));
            }

        }
        return coordinates;
    }

    /**
     * Method check has winner or not.
     *
     * @param coordinates coordinates of current point.
     * @return if has winner return true, else false.
     */
    private boolean hasWinner(Map<String, Integer> coordinates) {
        boolean hasWinner = false;
        final Symbol[][] gameArea = this.gameArea.getArea();
        if (this.algoritmsGame.lineIsFullByDioganalForWin(coordinates.get("X"), coordinates.get("Y"), gameArea)
                || this.algoritmsGame.lineIsFullByHorizontalForWin(coordinates.get("X"), coordinates.get("Y"), gameArea)
                || this.algoritmsGame.lineIsFullByVerticalForWin(coordinates.get("X"), coordinates.get("Y"), gameArea)) {
            hasWinner = true;
        }
        return hasWinner;
    }

    /**
     * Method change current gamer on user or computer after current step.
     */
    private void changeCurrentGamer() {
        if (this.currentGamer.equals(this.user)) {
            this.currentGamer = this.computer;
        } else {
            this.currentGamer = this.user;
        }
    }

    /**
     * Mehod implemnts logic of process game.
     */
    private void processGame() {
        boolean hasWinner = false;
        while (!hasWinner && this.gameArea.hasFreeCells()) {
            this.userInterface.printInfo(String.format("Step of %s", this.currentGamer.toString()));
            final Map<String, Integer> coordinates = this.doStepForCurrentGamer();
            hasWinner = this.hasWinner(coordinates);
            this.userInterface.showAreaGame(this.gameArea.getArea());
            if (hasWinner) {
                this.userInterface.printInfo(String.format("Game over. Winner is %s", this.currentGamer.toString()));
            } else {
                this.changeCurrentGamer();
            }
        }
        if (!hasWinner) {
            this.userInterface.printInfo("Game over. Dead heat!");
        }
    }

    /**
     * Method for starting game.
     */
    public void startGame() {
        this.initilize();
        this.processGame();
    }
}
