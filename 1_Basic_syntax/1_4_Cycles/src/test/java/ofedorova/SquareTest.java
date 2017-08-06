package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Class Класс для тестирования класса Square
 *@author Olga Fedorova
 *@since 16.07.2016
 *@version 1
 */
public class SquareTest {
	
	@Test
	public void whenCalculate(){
		final Square square = new Square(3,1,4);
        	float checked = 18f;

        	final float result = square.calculate(2);;
        	assertThat(result, is(checked));
	}
	
	
}