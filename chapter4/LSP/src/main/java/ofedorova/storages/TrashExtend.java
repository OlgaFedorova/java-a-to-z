package ofedorova.storages;

import java.util.Date;
import ofedorova.foods.Food;

/**
 * The class implements storage of food "Trash".
 *
 * @author Olga Fedorova
 * @since 12.10.2016
 * @version 1
 */
public class TrashExtend extends Trash {

    /**
     * The method checks food on appropriate for adding in storage.
     *
     * @param food
     * @param currentDate for checks food
     * @return true - if food is appropriate false - else
     */
    @Override
    public boolean isAppropriate(Food food, Date currentDate) {
        return super.isAppropriate(food, currentDate)
                && !food.isCanReproduct();
    }

}
