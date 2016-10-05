package ofedorova;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ofedorova.foods.Food;
import ofedorova.storages.AbstractStorageOfFoods;

/**
 * The class implements handler for reallocating foods into the storage.
 *
 * @author Olga Fedorova
 * @since 27.09.2016
 * @version 1
 */
public class ControllQuality {

    /**
     * Start constant for low price
     */
    private static final int START_SHELF_LIFE_OF_PRODUCT_IN_PERSENT_FOR_LOW_PRICE = 75;
    /**
     * End constant for low price
     */
    private static final int END_SHELF_LIFE_OF_PRODUCT_IN_PERSENT_FOR_LOW_PRICE = 100;
    /**
     * List of storages in a company.
     */
    private final List<AbstractStorageOfFoods> storages = new ArrayList<>();

    /**
     * The method adds a new storage into list "storages".
     *
     * @param storage
     */
    public void addStorage(AbstractStorageOfFoods storage) {
        storages.add(storage);
    }

    /**
     * The main method controls quality of food
     *
     * @param food
     * @param currentDate
     */
    public void control(Food food, Date currentDate) {
        this.reallocateFood(food, currentDate);
        this.lowPrice(food, currentDate);
    }

    /**
     * The methods reallocate food into the storage depending the shelf life of
     * product.
     *
     * @param food
     * @param currentDate
     */
    private void reallocateFood(Food food, Date currentDate) {
        for (AbstractStorageOfFoods storage : storages) {
            if (storage != null && storage.isAppropriate(food, currentDate)) {
                storage.add(food);
                break;
            }
        }
    }

    /**
     * The methods low price of food.
     *
     * @param food
     * @param currentDate
     */
    private void lowPrice(Food food, Date currentDate) {
        if (food.getShelfLifeOfProductInPercent(currentDate) > START_SHELF_LIFE_OF_PRODUCT_IN_PERSENT_FOR_LOW_PRICE
                && food.getShelfLifeOfProductInPercent(currentDate) <= END_SHELF_LIFE_OF_PRODUCT_IN_PERSENT_FOR_LOW_PRICE) {
            food.setPriceByDiccount();
        }
    }
}
