package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Class  ласс дл¤ тестировани¤ класса Triangle
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
public class TriangleMaxSideTest{
	
	@Test
	public void whenComputeMaxSideTriangle(){
		
		final Triangle triangle = new Triangle(new Point(-2.3, 2), new Point(7, 2), new Point(1, 0));
		final TriangleMaxSide triangleMaxSide = new TriangleMaxSide();
    	final double checked = 9.3d; 
        
        assertThat(triangleMaxSide.maxSide(triangle), is(checked));
	}
	
}