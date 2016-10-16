package ofedorova.storages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ofedorova.foods.Food;
import ofedorova.foods.FoodReproduct;

/**
 * The class implements storage of food "Warehouse with low temperature".
 *
 * @author Olga Fedorova
 * @since 11.10.2016
 * @version 1
 */
public class WarehouseWithLowTemperature extends AbstractReproStorage {

    /**
     * List for storage foods
     */
    protected List<FoodReproduct> foods = new ArrayList<>();

    /**
     * Constant for allowable shelf life of product in percent
     */
    private static final int ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT = 100;

    /**
     * The method checks reproduct food on appropriate for adding in storage.
     *
     * @param food
     * @param currentDate for checks food
     * @return true - if food is appropriate false - else
     */
    @Override
    public boolean isAppropriate(FoodReproduct food, Date currentDate) {
        return food.getShelfLifeOfProductInPercent(currentDate) > ALLOWABLE_SHELF_LIFE_OF_PRODUCT_IN_PERSENT
                && food.isCanReproduct();
    }

    /**
     * The method checks food on appropriate for adding in storage.
     *
     * @param food
     * @param currentDate for checks food
     * @return true - if food is appropriate false - else
     */
    @Override
    public boolean isAppropriate(Food food, Date currentDate) {
        return false;
    }

}
