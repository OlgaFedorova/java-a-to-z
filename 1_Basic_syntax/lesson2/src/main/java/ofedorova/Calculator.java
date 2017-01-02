package ofedorova;

/**
 * Class ����� ��� ���������� �������������� �������� +,-,*,/
 * @author Olga Fedorova
 * @since 13.07.2016
 * @version 1
 */

public class Calculator{
    /**
     * ���������� ��� �������� ����������
     */
    private double result;

    /**
     * ��������
     * @param first ������ ��������
     * @param second ������ ��������
     */
    public void add(double first, double second){
        this.result = first + second;
    }

    /**
     * ���������
     * @param first ������ ��������
     * @param second ������ ��������
     */
    public void substruct(double first, double second){
        this.result = first - second;
    }

    /**
     * �������
     * @param first ������ ��������
     * @param second ������ ��������
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * ���������
     * @param first ������ ��������
     * @param second ������ ��������
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public double getResult(){
        return this.result;
    }


}
