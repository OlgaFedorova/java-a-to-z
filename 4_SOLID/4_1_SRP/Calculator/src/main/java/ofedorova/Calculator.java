package ofedorova;

/**
 * Class for arithmetic operation +,-,*,/
 *
 * @author Olga Fedorova
 * @version 1
 * @since 13.07.2016
 */

public class Calculator {
    /**
     * Field for storage result of operation
     */
    private double result;

    /**
     * Operation of adding.
     *
     * @param first  argument
     * @param second argument
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Operation of subtraction
     *
     * @param first  argument
     * @param second argument
     */
    public void substruct(double first, double second) {
        this.result = first - second;
    }

    /**
     * Operation of division.
     *
     * @param first  argument
     * @param second argument
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Operation of multiplication.
     *
     * @param first  argument
     * @param second argument
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Getter for field "result".
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }


}
