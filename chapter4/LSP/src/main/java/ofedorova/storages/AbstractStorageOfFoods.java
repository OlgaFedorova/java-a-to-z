package ofedorova.storages;

import ofedorova.foods.Food;

/**
 * The class implements abstract storage of food.
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public abstract class AbstractStorageOfFoods {
    /**
     * Array for storage foods
     */
    protected Food[] foods;
    
    /**
     * The method adds new food into array "foods".
     * @param food
     * @return 
     *      true - if food is adds success, 
     *      false - else food is adds unsuccess
     */
    public abstract boolean add(Food food);
    
    /**
     * The method checks a validate the shelf life of product for this storage
     * @param shelfLifeOfProduct
     * @return 
     *      true - if he shelf life of product is validate
     *      false - else
     */     
    public abstract boolean checkShelfLifeOfProduct(int shelfLifeOfProduct);
    
}
