package ofedorova;

/**
 *Class класс для определения максимальной стороны треугольника
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
 public class TriangleMaxSide {
	 
	 /**
	  *Вычисляет максимальную сторону треугольника
	  *@param triangle геометрическая фигура
	  *@return максимальная сторона
	  */
	 public double maxSide(Triangle triangle){
		double sideAB = triangle.getA().distanceTo(triangle.getB());
		double sideAC = triangle.getA().distanceTo(triangle.getC());
		double sideBC = triangle.getB().distanceTo(triangle.getC());
		
		return max(sideAB, sideAC, sideBC);
	 }
	 
	 /**
	  *Вычисляет максимальное число
	  *@param numbers массив double
	  *@return максимальное число
	  */
	 public double max(double ... numbers){
		 double max = numbers[0];
		 for(int i = 1; i < numbers.length;i++)
			 max = Math.max(max, numbers[i]); 
		 return max;
	 }
 
 }