package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Class for testing class ArrayDeleteDuplicates
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
public class ArrayDeleteDuplicatesTest {

    @Test
    public void whenDeleteDuplicates(){
        final String[] values = {"string1", "string2", "string3", "string1", "string4", "string2"};
        final ArrayDeleteDuplicates arrayDeleteDuplicates = new ArrayDeleteDuplicates(values);
        final String[] checked = {"string1", "string2", "string3", "string4"};

        arrayDeleteDuplicates.deleteDublicate();
        final String[] result = arrayDeleteDuplicates.getArrayStrings();
        assertArrayEquals(result, checked);
    }
}