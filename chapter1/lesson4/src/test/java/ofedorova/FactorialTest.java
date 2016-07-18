package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Class for testing class Factorial
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
public class FactorialTest {
	
	@Test
	public void whenCompute(){
		final Factorial factorial = new Factorial(7);
        int checked = 5040;

        final int result = factorial.compute();
        assertThat(result, is(checked));
	}

}