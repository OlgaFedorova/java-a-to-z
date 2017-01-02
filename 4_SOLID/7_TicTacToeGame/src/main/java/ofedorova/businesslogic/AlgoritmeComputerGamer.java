package ofedorova.businesslogic;

import ofedorova.areas.Symbol;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class consists algoritms for work with computer-gamer.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 24.11.2016
 */
public class AlgoritmeComputerGamer extends AlgoritmsGame {

    /**
     * Allocates a new {@code AlgoritmeComputerGamer}.
     *
     * @param countForWin count a row for win
     */
    public AlgoritmeComputerGamer(int countForWin) {
        super(countForWin);
    }


    /**
     * Method compare two symbols.
     *
     * @param currentSymbol current symbol
     * @param compareSymbol symbol for compare
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean isNeedCell(Symbol currentSymbol, Symbol compareSymbol) {
        boolean isNeedCell = false;
        if (currentSymbol != null && currentSymbol.equals(Symbol.SYMBOL_NULL)
                && compareSymbol != null && !compareSymbol.equals(Symbol.SYMBOL_NULL)) {
            isNeedCell = true;
        }
        return isNeedCell;
    }

    /**
     * Method checks the up-symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellUpSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y - 1][x]);
    }

    /**
     * Method checks the right-symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellRightSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y][x + 1]);
    }

    /**
     * Method checks the left-symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellLeftSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y][x - 1]);
    }

    /**
     * Method checks the down-symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellDownSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y + 1][x]);
    }

    /**
     * Method checks the up-left symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellUpLeftSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y - 1][x - 1]);
    }

    /**
     * Method checks the up-right symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellUpRightSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y - 1][x + 1]);
    }

    /**
     * Method checks the down-left symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellDownLeftSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y + 1][x - 1]);
    }

    /**
     * Method checks the down-right symbol of current symbol, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkForNeedCellDownRightSymbol(int x, int y, Symbol[][] area) {
        return this.isNeedCell(area[y][x], area[y + 1][x + 1]);
    }

    /**
     * Method checks point in up-left corner, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInUpLeftCorner(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellDownSymbol(x, y, area)
                || this.checkForNeedCellRightSymbol(x, y, area)
                || this.checkForNeedCellDownRightSymbol(x, y, area);
    }

    /**
     * Method checks point in down-left corner, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInDownLeftCorner(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellUpSymbol(x, y, area)
                || this.checkForNeedCellUpRightSymbol(x, y, area)
                || this.checkForNeedCellRightSymbol(x, y, area);
    }

    /**
     * Method checks point in middle of left border, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInMiddleOfLeftBorder(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellUpSymbol(x, y, area)
                || this.checkForNeedCellDownSymbol(x, y, area)
                || this.checkForNeedCellUpRightSymbol(x, y, area)
                || this.checkForNeedCellRightSymbol(x, y, area)
                || this.checkForNeedCellDownRightSymbol(x, y, area);
    }

    /**
     * Method checks point in up-right corner, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInUpRightCorner(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellLeftSymbol(x, y, area)
                || this.checkForNeedCellDownSymbol(x, y, area)
                || this.checkForNeedCellDownLeftSymbol(x, y, area);
    }

    /**
     * Method checks point in middle of up-border, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInMiddleOfUpBorder(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellLeftSymbol(x, y, area)
                || this.checkForNeedCellDownLeftSymbol(x, y, area)
                || this.checkForNeedCellDownSymbol(x, y, area)
                || this.checkForNeedCellRightSymbol(x, y, area)
                || this.checkForNeedCellDownRightSymbol(x, y, area);
    }

    /**
     * Method checks point in down-right corner, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInDownRightCorner(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellUpSymbol(x, y, area)
                || this.checkForNeedCellUpLeftSymbol(x, y, area)
                || this.checkForNeedCellLeftSymbol(x, y, area);
    }

    /**
     * Method checks point in middle of down border, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInMiddleOfDownBorder(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellUpSymbol(x, y, area)
                || this.checkForNeedCellUpLeftSymbol(x, y, area)
                || this.checkForNeedCellLeftSymbol(x, y, area)
                || this.checkForNeedCellUpRightSymbol(x, y, area)
                || this.checkForNeedCellRightSymbol(x, y, area);
    }

    /**
     * Method checks point in middle of right border, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkPointInMiddleOfRightBorder(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellUpSymbol(x, y, area)
                || this.checkForNeedCellUpLeftSymbol(x, y, area)
                || this.checkForNeedCellLeftSymbol(x, y, area)
                || this.checkForNeedCellDownLeftSymbol(x, y, area)
                || this.checkForNeedCellDownSymbol(x, y, area);
    }

    /**
     * Method checks other point, that to determine the need list of cells.
     *
     * @param x    coordinate x of current symbol.
     * @param y    coordinate y of current symbol.
     * @param area array of area game.
     * @return if current symbol need to add list of cells for moving computer - returns true, else false.
     */
    private boolean checkOtherPoint(int x, int y, Symbol[][] area) {
        return this.checkForNeedCellUpSymbol(x, y, area)
                || this.checkForNeedCellUpLeftSymbol(x, y, area)
                || this.checkForNeedCellLeftSymbol(x, y, area)
                || this.checkForNeedCellDownLeftSymbol(x, y, area)
                || this.checkForNeedCellDownSymbol(x, y, area)
                || this.checkForNeedCellUpRightSymbol(x, y, area)
                || this.checkForNeedCellRightSymbol(x, y, area)
                || this.checkForNeedCellDownRightSymbol(x, y, area);
    }

    /**
     * Method determines list of need coordinates for moving computer.
     *
     * @param area array of area game.
     * @return set of need coordinates for moving computer.
     */
    public Set<Map<String, Integer>> getNeedCells(Symbol[][] area) {
        final Set<Map<String, Integer>> setNeedCells = new HashSet<>();
        for (int y = 0; y < area.length; y++) {
            for (int x = 0; x < area[y].length; x++) {
                boolean isNeedCell = false;
                if (x == 0 && y == 0) {
                    isNeedCell = this.checkPointInUpLeftCorner(x, y, area);
                } else if (x == area[y].length - 1 && y == 0) {
                    isNeedCell = this.checkPointInUpRightCorner(x, y, area);
                } else if (y == 0) {
                    isNeedCell = this.checkPointInMiddleOfUpBorder(x, y, area);
                } else if (x == 0 && y == area.length - 1) {
                    isNeedCell = this.checkPointInDownLeftCorner(x, y, area);
                } else if (x == area[y].length - 1 && y == area.length - 1) {
                    isNeedCell = this.checkPointInDownRightCorner(x, y, area);
                } else if (y == area.length - 1) {
                    isNeedCell = this.checkPointInMiddleOfDownBorder(x, y, area);
                } else if (x == 0) {
                    isNeedCell = this.checkPointInMiddleOfLeftBorder(x, y, area);
                } else if (x == area[y].length - 1) {
                    isNeedCell = this.checkPointInMiddleOfRightBorder(x, y, area);
                } else {
                    isNeedCell = this.checkOtherPoint(x, y, area);
                }
                if (isNeedCell) {
                    final Map<String, Integer> coordinates = new HashMap<>();
                    coordinates.put("X", x);
                    coordinates.put("Y", y);
                    setNeedCells.add(coordinates);
                }
            }
        }
        return setNeedCells;
    }

    /**
     * Method returns opposite symbol for current symbol.
     *
     * @param currentSymbol current symbol.
     * @return opposite symbol.
     */
    private Symbol getOppositeSymbol(Symbol currentSymbol) {
        Symbol oppositeSymbol = null;
        if (Symbol.SYMBOL_O.equals(currentSymbol)) {
            oppositeSymbol = Symbol.SYMBOL_X;
        } else {
            oppositeSymbol = Symbol.SYMBOL_O;
        }
        return oppositeSymbol;
    }

    /**
     * Method finds maximum element.
     *
     * @param numbers numbers for search maximum.
     * @return maximum number.
     */
    private int getMax(int... numbers) {
        final int index = 0;
        int max = numbers[index];
        for (int number : numbers) {
            max = Math.max(max, number);
        }
        return max;
    }

    /**
     * Method estimates the need cells of set, that computer-gamers can to make a decision about moving.
     *
     * @param symbol   symbol of computer.
     * @param gameArea array of area game.
     * @return map of estmating coordinates for moving computer.
     */
    public Map<String, Integer> getCoordinatesForMovingComputer(Symbol symbol, Symbol[][] gameArea) {
        final Set<Map<String, Integer>> estmatingCells = new TreeSet<>(new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                int resultCompare = o2.get("weight").compareTo(o1.get("weight"));
                if (resultCompare == 0) {
                    resultCompare = o2.get("self").compareTo(o1.get("self"));
                }
                return resultCompare;
            }
        });
        final int coefficientForSelf = 2;
        final int coefficientForBlocking = 1;
        for (Map<String, Integer> coordinates : this.getNeedCells(gameArea)) {
            final int weightForSelf = this.getMax(this.getCountInRowByHorizontal(coordinates.get("X"), coordinates.get("Y"), symbol, gameArea),
                    this.getCountInRowByVertical(coordinates.get("X"), coordinates.get("Y"), symbol, gameArea),
                    this.getCountInRowByDiagonalFromLeftToRight(coordinates.get("X"), coordinates.get("Y"), symbol, gameArea),
                    this.getCountInRowByDiagonalFromRightToLeft(coordinates.get("X"), coordinates.get("Y"), symbol, gameArea));

            final int weightForBlocking = this.getMax(this.getCountInRowByHorizontal(coordinates.get("X"), coordinates.get("Y"), this.getOppositeSymbol(symbol), gameArea),
                    this.getCountInRowByVertical(coordinates.get("X"), coordinates.get("Y"), this.getOppositeSymbol(symbol), gameArea),
                    this.getCountInRowByDiagonalFromLeftToRight(coordinates.get("X"), coordinates.get("Y"), this.getOppositeSymbol(symbol), gameArea),
                    this.getCountInRowByDiagonalFromRightToLeft(coordinates.get("X"), coordinates.get("Y"), this.getOppositeSymbol(symbol), gameArea));

            if (weightForSelf > weightForBlocking) {
                coordinates.put("weight", weightForSelf);
                coordinates.put("self", coefficientForSelf);
            } else if (weightForSelf == weightForBlocking) {
                coordinates.put("weight", weightForSelf);
                coordinates.put("self", coefficientForSelf + coefficientForBlocking);
            } else {
                coordinates.put("weight", weightForBlocking);
                coordinates.put("self", coefficientForBlocking);
            }
            estmatingCells.add(coordinates);
        }
        Map<String, Integer> coordinatesForMoving = null;
        if (!estmatingCells.isEmpty()) {
            coordinatesForMoving = estmatingCells.iterator().next();
        } else {
            coordinatesForMoving = Collections.emptyMap();
        }
        return coordinatesForMoving;
    }
}
