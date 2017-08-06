package ofedorova;

/**
 * Class для демонстрации работы класса Calculate.
 *
 * @author Olga Fedorova.
 * @version 1
 * @since 15.07.2016
 */

public class CalcInit {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(3, 4);
        System.out.println(String.format("3 + 4 = %.2f", calculator.getResult()));

        calculator.substruct(5, 2);
        System.out.println(String.format("5 - 2 = %.2f", calculator.getResult()));

        calculator.div(8, 2);
        System.out.println(String.format("8/2 = %.2f", calculator.getResult()));

        calculator.multiple(3, 4);
        System.out.println(String.format("3 * 4 = %.2f", calculator.getResult()));

    }

}