package ofedorova;

import ofedorova.foods.Food;
import ofedorova.storages.AbstractStorageOfFoods;

/**
 * The class implements handler for reallocating foods into the storage.
 * @author Olga Fedorova
 * @since 27.09.2016
 * @version 1
 */
public class ControllQuality {
    /**
     * Array of storages in a company.
     */
    private AbstractStorageOfFoods[] storages;
    
    /**
     * The method returns a value the shelf life of product in percent.
     * @param food
     * @return 
     */
    private int getShelfLifeOfProductInPercent(Food food){
        return 0;
    }
    
    /**
     * The method adds a new storage into array "storages".
     * @param storage 
     */
    public void addStorage(AbstractStorageOfFoods storage){}
    
    /**
     * The methods reallocate food into the storage depending the shelf life of product.
     * @param food 
     */
    public void reallocateFood(Food food){}
    
}
