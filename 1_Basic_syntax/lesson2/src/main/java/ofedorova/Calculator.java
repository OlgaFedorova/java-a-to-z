package ofedorova;

/**
 * Class Класс для выполнения арифметических операций +,-,*,/
 * @author Olga Fedorova
 * @since 13.07.2016
 * @version 1
 */

public class Calculator{
    /**
     * Переменная для хранения результата
     */
    private double result;

    /**
     * Сложение
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void add(double first, double second){
        this.result = first + second;
    }

    /**
     * Вычитание
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void substruct(double first, double second){
        this.result = first - second;
    }

    /**
     * Деление
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Умножение
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public double getResult(){
        return this.result;
    }


}
