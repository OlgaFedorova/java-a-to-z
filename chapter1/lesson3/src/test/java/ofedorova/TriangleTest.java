package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *Class  класс для тестирования класса Triangle
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
public class TriangleTest{
	
	@Test
	public void whenComputeArea(){
        final Triangle triangleTrue = new Triangle(new Point(-2, 1), new Point(3, 3), new Point(1, 0));
        assertThat(triangleTrue.area(), is(5.5d));
	}

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void whenComputeAreaExpectedIllegalArgumentException(){
        final Triangle triangleFalse = new Triangle(new Point(-2, 5), new Point(4, 3), new Point(16, -1));
        exception.expect(IllegalArgumentException.class);
        triangleFalse.area();
    }
	
}