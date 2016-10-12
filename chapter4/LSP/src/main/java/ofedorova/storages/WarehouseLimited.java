package ofedorova.storages;

import java.util.Date;
import ofedorova.foods.Food;

/**
 * The class implements storage of food "Warehouse with size".
 *
 * @author Olga Fedorova
 * @since 12.10.2016
 * @version 1
 */
public class WarehouseLimited extends Warehouse {

    /**
     * Size for storage
     */
    private int size;

    /**
     * Allocates a new {@code Warehouse}
     *
     * @param size
     */
    public WarehouseLimited(int size) {
        this.size = size;
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
        return this.foods != null && this.foods.size() < this.size
                && super.isAppropriate(food, currentDate);
    }

}
