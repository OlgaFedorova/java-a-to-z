package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Class for testing class ArrayBubleSort
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
public class ArrayBubleSortTest {
	
	@Test
	public void whenSort(){
		final int[] values = {9,10,4,7,3,14,5};
        	final ArrayBubleSort arrayBuble = new ArrayBubleSort(values);
        	int[] checked = {3,4,5,7,9,10,14};

        	arrayBuble.sort();
        	final int[] result = arrayBuble.getValues();
        	assertThat(result, is(checked));
	}

}