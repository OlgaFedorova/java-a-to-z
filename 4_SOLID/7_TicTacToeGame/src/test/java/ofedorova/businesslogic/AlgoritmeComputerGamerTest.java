package ofedorova.businesslogic;

import ofedorova.areas.GameArea;
import ofedorova.areas.GameAreaCellNotEmptyException;
import ofedorova.areas.GameAreaCoordinateOutOfBoundsException;
import ofedorova.areas.Symbol;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing class "AlgoritmsComputerGamer".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.11.2016
 */
public class AlgoritmeComputerGamerTest {
    /**
     * Object of game area.
     */
    private GameArea gameArea;
    /**
     * Object of algoritms game.
     */
    private AlgoritmeComputerGamer algoritmsGame;

    /**
     * Method initilize first state of game area.
     */
    @Before
    public void init() {
        final int size = 7;
        final int countForWin = 3;
        this.gameArea = new GameArea(size);
        this.algoritmsGame = new AlgoritmeComputerGamer(countForWin);
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in down-left corner.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInDownLeftCorner() {
        final int x = 0;
        final int y = 6;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordUp = new HashMap<>();
        recordUp.put("X", x);
        recordUp.put("Y", y - 1);
        expectList.add(recordUp);
        final HashMap<String, Integer> recordRight = new HashMap<>();
        recordRight.put("X", x + 1);
        recordRight.put("Y", y);
        expectList.add(recordRight);
        final HashMap<String, Integer> recordUpRight = new HashMap<>();
        recordUpRight.put("X", x + 1);
        recordUpRight.put("Y", y - 1);
        expectList.add(recordUpRight);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in up-left corner.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInUpLeftCorner() {
        final int x = 0;
        final int y = 0;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordDown = new HashMap<>();
        recordDown.put("X", x);
        recordDown.put("Y", y + 1);
        expectList.add(recordDown);
        final HashMap<String, Integer> recordRight = new HashMap<>();
        recordRight.put("X", x + 1);
        recordRight.put("Y", y);
        expectList.add(recordRight);
        final HashMap<String, Integer> recordDownRight = new HashMap<>();
        recordDownRight.put("X", x + 1);
        recordDownRight.put("Y", y + 1);
        expectList.add(recordDownRight);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in middle of left border.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInMiddleOfLeftBorder() {
        final int x = 0;
        final int y = 4;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordUp = new HashMap<>();
        recordUp.put("X", x);
        recordUp.put("Y", y - 1);
        expectList.add(recordUp);
        final HashMap<String, Integer> recordUpRight = new HashMap<>();
        recordUpRight.put("X", x + 1);
        recordUpRight.put("Y", y - 1);
        expectList.add(recordUpRight);
        final HashMap<String, Integer> recordRight = new HashMap<>();
        recordRight.put("X", x + 1);
        recordRight.put("Y", y);
        expectList.add(recordRight);
        final HashMap<String, Integer> recordDown = new HashMap<>();
        recordDown.put("X", x);
        recordDown.put("Y", y + 1);
        expectList.add(recordDown);
        final HashMap<String, Integer> recordDownRight = new HashMap<>();
        recordDownRight.put("X", x + 1);
        recordDownRight.put("Y", y + 1);
        expectList.add(recordDownRight);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in up-right corner.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInUpRightCorner() {
        final int x = 6;
        final int y = 0;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordLeft = new HashMap<>();
        recordLeft.put("X", x - 1);
        recordLeft.put("Y", y);
        expectList.add(recordLeft);
        final HashMap<String, Integer> recordDown = new HashMap<>();
        recordDown.put("X", x);
        recordDown.put("Y", y + 1);
        expectList.add(recordDown);
        final HashMap<String, Integer> recordDownLeft = new HashMap<>();
        recordDownLeft.put("X", x - 1);
        recordDownLeft.put("Y", y + 1);
        expectList.add(recordDownLeft);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in middle of right border.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInMiddleOfUpBorder() {
        final int x = 4;
        final int y = 0;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordLeft = new HashMap<>();
        recordLeft.put("X", x - 1);
        recordLeft.put("Y", y);
        expectList.add(recordLeft);
        final HashMap<String, Integer> recordRight = new HashMap<>();
        recordRight.put("X", x + 1);
        recordRight.put("Y", y);
        expectList.add(recordRight);
        final HashMap<String, Integer> recordDown = new HashMap<>();
        recordDown.put("X", x);
        recordDown.put("Y", y + 1);
        expectList.add(recordDown);
        final HashMap<String, Integer> recordDownRight = new HashMap<>();
        recordDownRight.put("X", x + 1);
        recordDownRight.put("Y", y + 1);
        expectList.add(recordDownRight);
        final HashMap<String, Integer> recordDownLeft = new HashMap<>();
        recordDownLeft.put("X", x - 1);
        recordDownLeft.put("Y", y + 1);
        expectList.add(recordDownLeft);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in down-right corner.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInDownRightCorner() {
        final int x = 6;
        final int y = 6;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordUp = new HashMap<>();
        recordUp.put("X", x);
        recordUp.put("Y", y - 1);
        expectList.add(recordUp);
        final HashMap<String, Integer> recordUpLeft = new HashMap<>();
        recordUpLeft.put("X", x - 1);
        recordUpLeft.put("Y", y - 1);
        expectList.add(recordUpLeft);
        final HashMap<String, Integer> recordLeft = new HashMap<>();
        recordLeft.put("X", x - 1);
        recordLeft.put("Y", y);
        expectList.add(recordLeft);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in middle of down border.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInMiddleOfDownBorder() {
        final int x = 4;
        final int y = 6;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordUp = new HashMap<>();
        recordUp.put("X", x);
        recordUp.put("Y", y - 1);
        expectList.add(recordUp);
        final HashMap<String, Integer> recordUpLeft = new HashMap<>();
        recordUpLeft.put("X", x - 1);
        recordUpLeft.put("Y", y - 1);
        expectList.add(recordUpLeft);
        final HashMap<String, Integer> recordUpRight = new HashMap<>();
        recordUpRight.put("X", x + 1);
        recordUpRight.put("Y", y - 1);
        expectList.add(recordUpRight);
        final HashMap<String, Integer> recordLeft = new HashMap<>();
        recordLeft.put("X", x - 1);
        recordLeft.put("Y", y);
        expectList.add(recordLeft);
        final HashMap<String, Integer> recordRight = new HashMap<>();
        recordRight.put("X", x + 1);
        recordRight.put("Y", y);
        expectList.add(recordRight);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current point in middle of right border.
     */
    @Test
    public void whenGetNeedCellsCurrentPointInMiddleOfRightBorder() {
        final int x = 6;
        final int y = 4;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordUp = new HashMap<>();
        recordUp.put("X", x);
        recordUp.put("Y", y - 1);
        expectList.add(recordUp);
        final HashMap<String, Integer> recordUpLeft = new HashMap<>();
        recordUpLeft.put("X", x - 1);
        recordUpLeft.put("Y", y - 1);
        expectList.add(recordUpLeft);
        final HashMap<String, Integer> recordLeft = new HashMap<>();
        recordLeft.put("X", x - 1);
        recordLeft.put("Y", y);
        expectList.add(recordLeft);
        final HashMap<String, Integer> recordDown = new HashMap<>();
        recordDown.put("X", x);
        recordDown.put("Y", y + 1);
        expectList.add(recordDown);
        final HashMap<String, Integer> recordDownLeft = new HashMap<>();
        recordDownLeft.put("X", x - 1);
        recordDownLeft.put("Y", y + 1);
        expectList.add(recordDownLeft);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     * Current other point.
     */
    @Test
    public void whenGetNeedCellsCurrentOtherPoint() {
        final int x = 4;
        final int y = 4;
        try {
            this.gameArea.addSymbol(x, y, Symbol.SYMBOL_X);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> recordUp = new HashMap<>();
        recordUp.put("X", x);
        recordUp.put("Y", y - 1);
        expectList.add(recordUp);
        final HashMap<String, Integer> recordUpLeft = new HashMap<>();
        recordUpLeft.put("X", x - 1);
        recordUpLeft.put("Y", y - 1);
        expectList.add(recordUpLeft);
        final HashMap<String, Integer> recordUpRight = new HashMap<>();
        recordUpRight.put("X", x + 1);
        recordUpRight.put("Y", y - 1);
        expectList.add(recordUpRight);
        final HashMap<String, Integer> recordLeft = new HashMap<>();
        recordLeft.put("X", x - 1);
        recordLeft.put("Y", y);
        expectList.add(recordLeft);
        final HashMap<String, Integer> recordRight = new HashMap<>();
        recordRight.put("X", x + 1);
        recordRight.put("Y", y);
        expectList.add(recordRight);
        final HashMap<String, Integer> recordDown = new HashMap<>();
        recordDown.put("X", x);
        recordDown.put("Y", y + 1);
        expectList.add(recordDown);
        final HashMap<String, Integer> recordDownRight = new HashMap<>();
        recordDownRight.put("X", x + 1);
        recordDownRight.put("Y", y + 1);
        expectList.add(recordDownRight);
        final HashMap<String, Integer> recordDownLeft = new HashMap<>();
        recordDownLeft.put("X", x - 1);
        recordDownLeft.put("Y", y + 1);
        expectList.add(recordDownLeft);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get list of need coordinates for moving computer.
     */
    @Test
    public void whenGetNeedCellsFullCheck() {
        try {
            final int x1 = 2, y1 = 4;
            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_X);
            final int x2 = 3, y2 = 4;
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_X);
            final int x3 = 1, y3 = 5;
            this.gameArea.addSymbol(x3, y3, Symbol.SYMBOL_X);

            final int x4 = 3, y4 = 2;
            this.gameArea.addSymbol(x4, y4, Symbol.SYMBOL_O);
            final int x5 = 3, y5 = 3;
            this.gameArea.addSymbol(x5, y5, Symbol.SYMBOL_O);
            final int x6 = 4, y6 = 4;
            this.gameArea.addSymbol(x6, y6, Symbol.SYMBOL_O);
        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }
        final Set<Map<String, Integer>> expectList = new HashSet<>();
        final HashMap<String, Integer> record1 = new HashMap<>();
        final int x1 = 2;
        final int y1 = 1;
        record1.put("X", x1);
        record1.put("Y", y1);
        expectList.add(record1);
        final HashMap<String, Integer> record2 = new HashMap<>();
        final int x2 = 3;
        final int y2 = 1;
        record2.put("X", x2);
        record2.put("Y", y2);
        expectList.add(record2);
        final HashMap<String, Integer> record3 = new HashMap<>();
        final int x3 = 4;
        final int y3 = 1;
        record3.put("X", x3);
        record3.put("Y", y3);
        expectList.add(record3);
        final HashMap<String, Integer> record4 = new HashMap<>();
        final int x4 = 2;
        final int y4 = 2;
        record4.put("X", x4);
        record4.put("Y", y4);
        expectList.add(record4);
        final HashMap<String, Integer> record5 = new HashMap<>();
        final int x5 = 4;
        final int y5 = 2;
        record5.put("X", x5);
        record5.put("Y", y5);
        expectList.add(record5);
        final HashMap<String, Integer> record6 = new HashMap<>();
        final int x6 = 1;
        final int y6 = 3;
        record6.put("X", x6);
        record6.put("Y", y6);
        expectList.add(record6);
        final HashMap<String, Integer> record7 = new HashMap<>();
        final int x7 = 2;
        final int y7 = 3;
        record7.put("X", x7);
        record7.put("Y", y7);
        expectList.add(record7);
        final HashMap<String, Integer> record8 = new HashMap<>();
        final int x8 = 4;
        final int y8 = 3;
        record8.put("X", x8);
        record8.put("Y", y8);
        expectList.add(record8);
        final HashMap<String, Integer> record9 = new HashMap<>();
        final int x9 = 5;
        final int y9 = 3;
        record9.put("X", x9);
        record9.put("Y", y9);
        expectList.add(record9);
        final HashMap<String, Integer> record19 = new HashMap<>();
        final int x10 = 0;
        final int y10 = 4;
        record19.put("X", x10);
        record19.put("Y", y10);
        expectList.add(record19);
        final HashMap<String, Integer> record10 = new HashMap<>();
        final int x11 = 1;
        final int y11 = 4;
        record10.put("X", x11);
        record10.put("Y", y11);
        expectList.add(record10);
        final HashMap<String, Integer> record11 = new HashMap<>();
        final int x12 = 5;
        final int y12 = 4;
        record11.put("X", x12);
        record11.put("Y", y12);
        expectList.add(record11);
        final HashMap<String, Integer> record20 = new HashMap<>();
        final int x13 = 0;
        final int y13 = 5;
        record20.put("X", x13);
        record20.put("Y", y13);
        expectList.add(record20);
        final HashMap<String, Integer> record12 = new HashMap<>();
        final int x14 = 2;
        final int y14 = 5;
        record12.put("X", x14);
        record12.put("Y", y14);
        expectList.add(record12);
        final HashMap<String, Integer> record13 = new HashMap<>();
        final int x15 = 3;
        final int y15 = 5;
        record13.put("X", x15);
        record13.put("Y", y15);
        expectList.add(record13);
        final HashMap<String, Integer> record14 = new HashMap<>();
        final int x16 = 4;
        final int y16 = 5;
        record14.put("X", x16);
        record14.put("Y", y16);
        expectList.add(record14);
        final HashMap<String, Integer> record15 = new HashMap<>();
        final int x17 = 5;
        final int y17 = 5;
        record15.put("X", x17);
        record15.put("Y", y17);
        expectList.add(record15);
        final HashMap<String, Integer> record16 = new HashMap<>();
        final int x18 = 0;
        final int y18 = 6;
        record16.put("X", x18);
        record16.put("Y", y18);
        expectList.add(record16);
        final HashMap<String, Integer> record17 = new HashMap<>();
        final int x19 = 1;
        final int y19 = 6;
        record17.put("X", x19);
        record17.put("Y", y19);
        expectList.add(record17);
        final HashMap<String, Integer> record18 = new HashMap<>();
        final int x20 = 2;
        final int y20 = 6;
        record18.put("X", x20);
        record18.put("Y", y20);
        expectList.add(record18);

        assertEquals(expectList, this.algoritmsGame.getNeedCells(this.gameArea.getArea()));
    }

    /**
     * Method for testing to get coordinates for moving computer-gamer.
     * Returns coordinates for self and for blocking.
     */
    @Test
    public void whenGetCoordinatesForMovingComputerCoordinatesForSelfAndBlocking() {
        try {
            final int x1 = 2;
            final int y1 = 3;
            final int x2 = 1;
            final int y2 = 4;

            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_O);

            final int x3 = 3;
            this.gameArea.addSymbol(x3, y1, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x3, y2, Symbol.SYMBOL_X);

        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }

        final Map<String, Integer> expected = new HashMap<>();
        final int x = 3;
        final int y = 2;
        final int weight = 2;
        final int coefficientForSelfAndBlocking = 3;
        expected.put("X", x);
        expected.put("Y", y);
        expected.put("weight", weight);
        expected.put("self", coefficientForSelfAndBlocking);

        final Map<String, Integer> actual = this.algoritmsGame.getCoordinatesForMovingComputer(Symbol.SYMBOL_X, this.gameArea.getArea());

        assertEquals(expected, actual);
    }

    /**
     * Method for testing to get coordinates for moving computer-gamer.
     * Returns coordinates for self.
     */
    @Test
    public void whenGetCoordinatesForMovingComputerCoordinatesForSelf() {
        try {
            final int x1 = 2;
            final int y1 = 4;
            final int x2 = 3;
            final int y2 = 5;

            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_O);

            final int x3 = 3;
            final int y3 = 3;
            final int y4 = 4;
            this.gameArea.addSymbol(x3, y3, Symbol.SYMBOL_X);
            this.gameArea.addSymbol(x3, y4, Symbol.SYMBOL_X);

        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }

        final Map<String, Integer> expected = new HashMap<>();
        final int x = 3;
        final int y = 2;
        final int weight = 2;
        final int coefficientForSelf = 2;
        expected.put("X", x);
        expected.put("Y", y);
        expected.put("weight", weight);
        expected.put("self", coefficientForSelf);

        final Map<String, Integer> actual = this.algoritmsGame.getCoordinatesForMovingComputer(Symbol.SYMBOL_X, this.gameArea.getArea());

        assertEquals(expected, actual);
    }

    /**
     * Method for testing to get coordinates for moving computer-gamer.
     * Returns coordinates for blocking.
     */
    @Test
    public void whenGetCoordinatesForMovingComputerCoordinatesForBlocking() {
        try {
            final int x1 = 2;
            final int y1 = 4;
            final int x2 = 3;
            final int y2 = 5;

            this.gameArea.addSymbol(x1, y1, Symbol.SYMBOL_O);
            this.gameArea.addSymbol(x2, y2, Symbol.SYMBOL_O);

            final int x3 = 4;
            final int y4 = 6;
            this.gameArea.addSymbol(x3, y4, Symbol.SYMBOL_X);

        } catch (GameAreaCoordinateOutOfBoundsException e) {
            e.printStackTrace();
        } catch (GameAreaCellNotEmptyException e) {
            e.printStackTrace();
        }

        final Map<String, Integer> expected = new HashMap<>();
        final int x = 1;
        final int y = 3;
        final int weight = 2;
        final int coefficientForBlocking = 1;
        expected.put("X", x);
        expected.put("Y", y);
        expected.put("weight", weight);
        expected.put("self", coefficientForBlocking);

        final Map<String, Integer> actual = this.algoritmsGame.getCoordinatesForMovingComputer(Symbol.SYMBOL_X, this.gameArea.getArea());

        assertEquals(expected, actual);
    }

}