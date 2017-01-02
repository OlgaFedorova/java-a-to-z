package ofedorova;

import java.util.Arrays;

/**
 *Class for test task
 *@author Olga Fedorova
 *@since 28.07.2016
 *@version 1
 */
public class TestTask {
    
    /**
     * Method checks, that string "sub" is substring "origin"
     * @param origin
     * @param sub
     * @return true or false 
     */
    public boolean contains(String origin, String sub){
        final char[] originArray = origin.toLowerCase().trim().toCharArray();
        final char[] subArray = sub.toLowerCase().trim().toCharArray();
        boolean result = false;
        
        for (int index = 0; index < originArray.length; index++){
            if (originArray.length - index < subArray.length){
                break;
            }
            if (originArray[index] == subArray[0]){
                final char[] subOriginArray = new char[subArray.length];
                System.arraycopy(originArray, index, subOriginArray, 0, subOriginArray.length);
                result = Arrays.equals(subOriginArray, subArray);
                if (result){
                    break;
                }
            }
        }
        return result;
    }
}
