package ofedorova;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ofedorova.foods.FoodReproduct;
import ofedorova.storages.AbstractReproStorage;

/**
 * The class implements handler for reallocating foods into the storage.
 *
 * @author Olga Fedorova
 * @since 16.10.2016
 * @version 1
 */
public class ControllQualityExtends extends ControllQuality{

    /**
     * List of storages with reproduct in a company.
     */
    private final List<AbstractReproStorage> storages = new ArrayList<>();

    /**
     * The method adds a new storage into list "storages".
     *
     * @param storage
     */
    public void addReproStorage(AbstractReproStorage storage) {
        storages.add(storage);
    }

    /**
     * The main method controls quality of food
     *
     * @param food
     * @param currentDate
     * @return storage, where reallocate food
     */
    public AbstractReproStorage control(FoodReproduct food, Date currentDate) {
        AbstractReproStorage result = null;
        for (AbstractReproStorage storage : storages) {
            if (storage != null && storage.isAppropriate(food, currentDate)) {
                storage.add(food);
                result = storage;
                break;
            }
        }
        return result;
    }
    
}
