package ofedorova;

/**
 *Class класс для вычисления функции y = a*x2 + b * x + c
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
public class Square {
	/**
	 *Параметры a, b, c
	 */
	private double a;
	private double b;
	private double c;
	
	public Square (double a, double b, double c){
		this.a = a;
		this.b = b;
		this.c = c;		
	}

	/**
	 *Вычисляет функцию y = a*x2 + b * x + c
	 */
	public float calculate(int x){
		return (float)(this.a * Math.pow(x, 2) + this.b * x + this.c);
		
	}
	
	public static void main(String[] args){
		double a = Double.valueOf(args[0]);
		double b = Double.valueOf(args[1]);
		double c = Double.valueOf(args[2]);
		int x1 = Integer.valueOf(args[3]);
		int x2 = Integer.valueOf(args[4]);
		int step = Integer.valueOf(args[5]);
		
		Square square = new Square(a, b, c);
		for(int i = x1; i <= x2; i = i + step){
			System.out.println(square.calculate(i));
		}
	}
}