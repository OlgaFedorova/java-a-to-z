package ofedorova;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

/**
 * Class for testing "CashMachine".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 12.12.2016
 */
public class CashMachineTest {
    /**
     * Coin with nominal 10.
     */
    private static final int NOMINAL10 = 10;
    /**
     * Coin with nominal 5.
     */
    private static final int NOMINAL5 = 5;
    /**
     * Coin with nominal 1.
     */
    private static final int NOMINAL1 = 1;
    /**
     * Count for coin with nominal 10.
     */
    private static final int COUNT10 = 5;
    /**
     * Count for coin with nominal 5.
     */
    private static final int COUNT5 = 7;
    /**
     * Count for coin with nominal 1.
     */
    private static final int COUNT1 = 10;
    /**
     * Object of cash machine.
     */
    private final CashMachine cashMachine = new CashMachine();

    /**
     * Expected exception.
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    /**
     * Test adding coin in cash machine and not enough money in cash machine.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenAddCoinNotEnoughMoneyException() throws NotEnoughMoneyException {
        final int count = -7;
        exception.expect(NotEnoughMoneyException.class);
        this.cashMachine.addCoin(NOMINAL10, count);
    }

    /**
     * Test adding coin in cash machine and enough money in cash machine.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenAddCoinEnoughMoney() throws NotEnoughMoneyException {
        final int nominal = 10;
        final int count = 7;
        final Map<Integer, Integer> expectCoins = new HashMap<>();
        expectCoins.put(nominal, count);
        this.cashMachine.addCoin(nominal, count);

        Assert.assertThat(this.cashMachine.getCoins(), is(expectCoins));
    }

    /**
     * Test getting has coins in cash machine.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetCoins() throws NotEnoughMoneyException {
        final int count = 7;
        this.cashMachine.addCoin(NOMINAL10, count);
        exception.expect(UnsupportedOperationException.class);
        this.cashMachine.getCoins().put(NOMINAL10, count);
    }

    /**
     * Add coin in cash machine for testing.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    private void addCoinsInBancomat() throws NotEnoughMoneyException {
        this.cashMachine.addCoin(NOMINAL1, COUNT1);
        this.cashMachine.addCoin(NOMINAL5, COUNT5);
        this.cashMachine.addCoin(NOMINAL10, COUNT10);
    }

    /**
     * Test when getting part of coins with nominal 10.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript1() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange10 = 4;
        expectChangeCoins.put(NOMINAL10, countChange10);

        final int amount = 40;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting all coins with nominal 10.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript2() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        expectChangeCoins.put(NOMINAL10, COUNT10);

        final int amount = 50;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting part of coins with nominal 5.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript3() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange5 = 1;
        expectChangeCoins.put(NOMINAL5, countChange5);

        final int amount = 5;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting part of coins with nominal 5 and all coins with nominal 10.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript4() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange5 = 1;
        expectChangeCoins.put(NOMINAL10, COUNT10);
        expectChangeCoins.put(NOMINAL5, countChange5);

        final int amount = 55;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting part of coins with nominal 1.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript5() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange = 3;
        expectChangeCoins.put(NOMINAL1, countChange);

        final int amount = 3;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting all coins with nominal 10 and all coins with nominal 5 and part of coins with nominal 1.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript6() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange = 3;
        expectChangeCoins.put(NOMINAL10, COUNT10);
        expectChangeCoins.put(NOMINAL5, COUNT5);
        expectChangeCoins.put(NOMINAL1, countChange);

        final int amount = 88;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting part of coins with nominal 10 and part of coins with nominal 5 and part of coins with nominal 1.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript7() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange = 1;
        expectChangeCoins.put(NOMINAL10, countChange);
        expectChangeCoins.put(NOMINAL5, countChange);
        expectChangeCoins.put(NOMINAL1, countChange);

        final int amount = 16;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting part of coins with nominal 5 and part of coins with nominal 1.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript8() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange = 1;
        expectChangeCoins.put(NOMINAL5, countChange);
        expectChangeCoins.put(NOMINAL1, countChange);

        final int amount = 6;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting part of coins with nominal 10 and part of coins with nominal 1.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript9() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        final int countChange = 1;
        expectChangeCoins.put(NOMINAL10, countChange);
        expectChangeCoins.put(NOMINAL1, countChange);

        final int amount = 11;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when getting all coins with nominal 10 and all coins with nominal 5 and all coins with nominal 1.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScript10() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        final Map<Integer, Integer> expectChangeCoins = new HashMap<>();
        expectChangeCoins.put(NOMINAL10, COUNT10);
        expectChangeCoins.put(NOMINAL5, COUNT5);
        expectChangeCoins.put(NOMINAL1, COUNT1);

        final int amount = COUNT1 * NOMINAL1 + COUNT5 * NOMINAL5 + COUNT10 * NOMINAL10;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);

        Assert.assertThat(actualChangeCoins, is(expectChangeCoins));
    }

    /**
     * Test when not enough money in cash machine.
     *
     * @throws NotEnoughMoneyException when not enough money in cash machine.
     */
    @Test
    public void whenGetChangeCoinsScriptNotEnoughMoney() throws NotEnoughMoneyException {
        this.addCoinsInBancomat();

        exception.expect(NotEnoughMoneyException.class);

        final int amount = COUNT1 * NOMINAL1 + COUNT5 * NOMINAL5 + COUNT10 * NOMINAL10 + 1;
        final Map<Integer, Integer> actualChangeCoins = this.cashMachine.getChangeCoins(amount);
    }


}