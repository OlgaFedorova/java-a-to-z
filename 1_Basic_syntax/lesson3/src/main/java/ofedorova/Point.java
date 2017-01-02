package ofedorova;

/**
 *Class класс для обозначения точки
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
public class Point {
	/**
	 *Координаты точки x, y.
	 */
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}

	/**
	 * Метод вычисляет расстояние между двумя точками
	 * @param point координаты точки, до которой необходимо вычислить расстояние
	 * @return расстояние между текущей точкой и переданной
	 */
	public double distanceTo(Point point) {
		return Math.sqrt(Math.pow(point.getX() - this.getX(), 2) + Math.pow(point.getY() - this.getY(), 2));
	}
}