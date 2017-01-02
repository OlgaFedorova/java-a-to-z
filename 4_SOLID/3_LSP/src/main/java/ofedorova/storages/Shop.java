package ofedorova.storages;

import java.util.Date;
import ofedorova.foods.Food;

/**
 * The class implements storage of food "Shop".
 *
 * @author Olga Fedorova
 * @since 27.09.2016
 * @version 1
 */
public class Shop extends AbstractStorageOfFoods {

    /**
     * Start constant for allowable shelf life of product in percent
     */
    private static final int START_ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT = 25;
    /**
     * End constant for allowable shelf life of product in percent
     */
    private static final int END_ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT = 100;

    /**
     * The method checks food on appropriate for adding in storage.
     *
     * @param food
     * @param currentDate for checks food
     * @return true - if food is appropriate false - else
     */
    @Override
    public boolean isAppropriate(Food food, Date currentDate) {
        return food.getShelfLifeOfProductInPercent(currentDate) >= START_ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT
                && food.getShelfLifeOfProductInPercent(currentDate) <= END_ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT;
    }

}
