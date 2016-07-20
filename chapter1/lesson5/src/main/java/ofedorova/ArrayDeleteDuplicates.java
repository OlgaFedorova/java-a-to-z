package ofedorova;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *Class for deleting dublicates from the array
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
public class ArrayDeleteDuplicates{
    /**
     *The array
     */
    private String[] arrayStrings;

    public ArrayDeleteDuplicates(String[] arrayStrings){
        this.arrayStrings = arrayStrings;
    }

    public String[] getArrayStrings(){
        return this.arrayStrings;
    }

    /**
     *Delete dublicates from the array
     */
    public void deleteDublicate(){
        Set<String> set = new LinkedHashSet<String>(Arrays.asList(arrayStrings));
        arrayStrings = new String[set.size()];
        set.toArray(arrayStrings);
    }
}