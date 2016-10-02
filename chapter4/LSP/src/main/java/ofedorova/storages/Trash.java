package ofedorova.storages;

import ofedorova.foods.Food;

/**
 * The class implements storage of food "Trash".
 * @author Olga Fedorova
 * @since 27.09.2016
 * @version 1
 */
public class Trash extends AbstractStorageOfFoods{
    /**
     * Constant for allowable shelf life of product in percent
     */
    private static final int ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT = 100;
    
    /**
     * The method checks a validate the shelf life of product for this storage
     * @param shelfLifeOfProduct
     * @return 
     *      true - if he shelf life of product is validate
     *      false - else
     */   
    @Override
    public boolean checkShelfLifeOfProduct(int shelfLifeOfProduct){
        return shelfLifeOfProduct > ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT;
    }
    
}
