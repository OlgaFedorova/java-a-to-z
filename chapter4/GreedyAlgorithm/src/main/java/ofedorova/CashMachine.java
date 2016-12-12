package ofedorova;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implements model "Cash machine".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 12.12.2016
 */
public class CashMachine {
    /**
     * Coins in cash machine.
     */
    private Map<Integer, Integer> coins = new HashMap<>();

    /**
     * Method adds coin in cash machine.
     *
     * @param nominal nominal of coin.
     * @param count   count of coin.
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    public void addCoin(int nominal, int count) throws NotEnoughMoneyException {
        int total = 0;
        if (this.coins.containsKey(nominal)) {
            total = coins.get(nominal) + count;
        } else {
            total = count;
        }
        if (total < 0) {
            throw new NotEnoughMoneyException();
        }
        this.coins.put(nominal, total);
    }

    /**
     * Getter for coins in cash machine.
     *
     * @return coins in cash machine.
     */
    public Map<Integer, Integer> getCoins() {
        return Collections.unmodifiableMap(this.coins);
    }

    /**
     * Method implements change amount on coins.
     *
     * @param amount amount for change.
     * @return map of coins.
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    public Map<Integer, Integer> getChangeCoins(int amount) throws NotEnoughMoneyException {
        Map<Integer, Integer> result = new HashMap<>();
        Integer[] nominals = this.getNominals();

        boolean isChange = false;
        for (int index = nominals.length - 1; index >= 0; index--) {
            isChange = this.changeCoins(nominals, index, amount, result);
            if (isChange) {
                break;
            } else {
                result = new HashMap<>();
            }
        }

        this.subtractCoins(result);

        if (result.isEmpty()) {
            throw new NotEnoughMoneyException();
        }
        return result;
    }

    /**
     * Method implements private logic foe changing coins.
     *
     * @param nominals     array of nominals.
     * @param index        current index.
     * @param amount       amount for change.
     * @param resultChange map of change coins.
     * @return if finding coins for change return true, else false.
     */
    private boolean changeCoins(Integer[] nominals, int index, int amount, Map<Integer, Integer> resultChange) {
        boolean isChange = false;
        if (index >= 0) {
            if (nominals[index] <= amount) {
                int needCount = amount / nominals[index];
                if (needCount > this.coins.get(nominals[index])) {
                    needCount = this.coins.get(nominals[index]);
                }
                if (needCount != 0) {
                    resultChange.put(nominals[index], needCount);
                    amount = amount - nominals[index] * needCount;
                    if (amount != 0) {
                        isChange = this.changeCoins(nominals, index - 1, amount, resultChange);
                    } else {
                        isChange = true;
                    }
                }
            } else {
                isChange = this.changeCoins(nominals, index - 1, amount, resultChange);
            }
        }
        return isChange;
    }

    /**
     * Method subtract from coins in cash machine.
     *
     * @param subtrahend value for subtract from coins in cash machine.
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    private void subtractCoins(Map<Integer, Integer> subtrahend) throws NotEnoughMoneyException {
        for (Map.Entry<Integer, Integer> entry : subtrahend.entrySet()) {
            this.addCoin(entry.getKey(), -entry.getValue());
        }
    }

    /**
     * Method returns array nominals of coins in cash machine.
     *
     * @return array nominals of coins.
     */
    private Integer[] getNominals() {
        Integer[] nominals = new Integer[this.coins.size()];
        this.coins.keySet().toArray(nominals);
        Arrays.sort(nominals);
        return nominals;
    }
}
