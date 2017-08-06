package ofedorova;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
     * @return list of possible combinations for change of coins.
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    public List<List<Integer>> getChangeCoins(int amount) throws NotEnoughMoneyException {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] nominals = this.getNominals();

        for (int index = nominals.length - 1; index >= 0; index--) {
            for (int count = this.coins.get(nominals[index]); count > 0; count--) {
                List<Integer> change = new ArrayList<>();
                if (count * nominals[index] <= amount) {
                    this.addCountCoinInChange(count, nominals[index], change);
                    int balance = this.changeCoins(nominals, index - 1, amount - count * nominals[index], change);
                    if (balance == 0 && !change.isEmpty()) {
                        result.add(change);
                    }
                }
            }
        }

        if (result.isEmpty()) {
            throw new NotEnoughMoneyException();
        }
        return result;
    }

    /**
     * Method adds count of coins in list.
     *
     * @param count   count of coins.
     * @param nominal nominal of coin.
     * @param change  list for change.
     */
    private void addCountCoinInChange(int count, int nominal, List<Integer> change) {
        for (int i = 0; i < count; i++) {
            change.add(nominal);
        }
    }

    /**
     * Method implements private logic foe changing coins.
     *
     * @param nominals     array of nominals.
     * @param index        current index.
     * @param amount       amount for change.
     * @param resultChange list of change coins.
     * @return balance for change.
     */
    private int changeCoins(Integer[] nominals, int index, int amount, List<Integer> resultChange) {
        if (index >= 0) {
            if (nominals[index] <= amount) {
                int needCount = amount / nominals[index];
                if (needCount > this.coins.get(nominals[index])) {
                    needCount = this.coins.get(nominals[index]);
                }
                if (needCount != 0) {
                    this.addCountCoinInChange(needCount, nominals[index], resultChange);
                    amount = amount - nominals[index] * needCount;
                    if (amount != 0) {
                        amount = this.changeCoins(nominals, index - 1, amount, resultChange);
                    }
                }
            } else {
                amount = this.changeCoins(nominals, index - 1, amount, resultChange);
            }
        }
        return amount;
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
