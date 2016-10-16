package ofedorova.storages;

import java.util.Date;
import ofedorova.foods.FoodReproduct;

/**
 * The class expands storage for work with reproduct food.
 *
 * @author Olga Fedorova
 * @since 16.10.2016
 * @version 1
 */
public abstract class AbstractReproStorage extends AbstractStorageOfFoods{
    /**
     * The method checks reproduct food on appropriate for adding in storage.
     *
     * @param food
     * @param currentDate for checks food
     * @return true - if food is appropriate false - else
     */
    public abstract boolean isAppropriate(FoodReproduct food, Date currentDate);
    
}
