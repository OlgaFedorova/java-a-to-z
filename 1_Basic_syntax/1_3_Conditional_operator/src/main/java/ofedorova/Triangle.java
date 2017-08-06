package ofedorova;

/**
 *Class класс для обозначения треугольника
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
public class Triangle {
	/**
	 *Вершины треугольника
	 */
	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Point getA(){
		return this.a;
	}
	
	public Point getB(){
		return this.b;
	}
	
	public Point getC(){
		return this.c;
	}

	/**
	 *Метод, вычисляющий площадь треугольника
	 *return площадь треугольника - если треугольник можно построить, IllegalArgumentException - если треугольник нельзя построить.
	 */
	public double area() {
		double sideAB = this.getA().distanceTo(this.getB());
		double sideAC = this.getA().distanceTo(this.getC());
		double sideBC = this.getB().distanceTo(this.getC());
		double semiperimeter = (sideAB + sideAC + sideBC)/2;
		
		double area = Math.sqrt(semiperimeter * (semiperimeter - sideAB) * (semiperimeter - sideAC) * (semiperimeter - sideBC));
		if (area == 0) throw new IllegalArgumentException();  
		return area;
	}
}