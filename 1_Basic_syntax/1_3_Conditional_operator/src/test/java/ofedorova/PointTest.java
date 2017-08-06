package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Class Класс для тестирования класса Point
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
public class PointTest {
	
	@Test
	public void whenComputeDistanceTo(){
		
		final Point point1 = new Point(-2.3, 2);
		final Point point2 = new Point(7, 2);
        double checked = 9.3;
		
		double result = point1.distanceTo(point2);

        assertThat(result, is(checked));
	}
	
}