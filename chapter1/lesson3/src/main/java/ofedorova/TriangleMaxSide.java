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
	  */
	 public double max(Triangle triangle){
		double sideAB = triangle.getA().distanceTo(triangle.getB());
		double sideAC = triangle.getA().distanceTo(triangle.getC());
		double sideBC = triangle.getB().distanceTo(triangle.getC());
		
		double max = sideAB;
		if(sideAC > sideAB && sideAC > sideBC)
			max = sideAC;
		else if(sideBC > sideAC && sideBC > sideAB)
			max = sideBC;
		
		return max;
	 }
 
 }