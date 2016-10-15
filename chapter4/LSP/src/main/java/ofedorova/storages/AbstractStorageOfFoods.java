package ofedorova.storages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import ofedorova.foods.Food;
import ofedorova.foods.FoodReproduct;

/**
 * The class implements abstract storage of food.
 *
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public abstract class AbstractStorageOfFoods {

    /**
     * List for storage foods
     */
    protected List<Food> foods = new ArrayList<>();

    /**
     * The method adds new food into list "foods".
     *
     * @param food
     * @return true - if food is adds success, false - else food is adds
     * unsuccess
     */
    public boolean add(Food food) {
        return foods.add(food);
    }

    /**
     * The method checks food on appropriate for adding in storage.
     *
     * @param food
     * @param currentDate for checks food
     * @return true - if food is appropriate false - else
     */
    public abstract boolean isAppropriate(Food food, Date currentDate);

}
