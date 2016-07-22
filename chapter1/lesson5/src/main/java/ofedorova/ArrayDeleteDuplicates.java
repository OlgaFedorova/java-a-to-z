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
        for(int index = 0; index < this.arrayStrings.length; index++){
            int indexIn = index + 1;
            while (indexIn < this.arrayStrings.length){
                if (this.arrayStrings[index].equals(this.arrayStrings[indexIn])){
                    String[] partFirst = new String[indexIn];
                    System.arraycopy(this.arrayStrings, 0, partFirst, 0, partFirst.length);

                    String[] partSecond = new String[this.arrayStrings.length - indexIn - 1];
                    System.arraycopy(this.arrayStrings, indexIn+1, partSecond, 0, partSecond.length);

                    copyTwoArraysIntoOne(partFirst, partSecond);
                }
                else {
                    indexIn++;
                }
            }
        }
    }

    /**
     * Coping two arrays into the one.
     * @param partFirst - the first array for coping
     * @param partSecond - the second array for coping
     */
    private void copyTwoArraysIntoOne(String[] partFirst, String[] partSecond){
        this.arrayStrings = new String[partFirst.length + partSecond.length];
        System.arraycopy(partFirst, 0, this.arrayStrings, 0, partFirst.length);
        System.arraycopy(partSecond,0, this.arrayStrings, partFirst.length, partSecond.length);
    }
}