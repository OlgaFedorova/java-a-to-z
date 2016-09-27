package ofedorova.storages;

import ofedorova.foods.Food;

/**
 * The class implements storage of food "Warehouse".
 * @author Olga Fedorova
 * @since 27.09.2016
 * @version 1
 */
public class Warehouse extends AbstractStorageOfFoods{

    /**
     * The method adds new food into array "foods".
     * @param food
     * @return 
     *      true - if food is adds success, 
     *      false - else food is adds unsuccess
     */
    @Override
    public boolean add(Food food) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * The method checks a validate the shelf life of product for this storage
     * @param shelfLifeOfProduct
     * @return 
     *      true - if he shelf life of product is validate
     *      false - else
     */     
    @Override
    public boolean checkShelfLifeOfProduct(int shelfLifeOfProduct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
