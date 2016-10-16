package ofedorova;

import java.util.Calendar;
import java.util.Date;
import ofedorova.foods.Chicken;
import ofedorova.foods.Food;
import ofedorova.foods.FoodReproduct;
import ofedorova.foods.Milk;
import ofedorova.foods.Tomato;
import ofedorova.storages.AbstractReproStorage;
import ofedorova.storages.AbstractStorageOfFoods;
import ofedorova.storages.Shop;
import ofedorova.storages.Trash;
import ofedorova.storages.Warehouse;
import ofedorova.storages.WarehouseLimited;
import ofedorova.storages.WarehouseWithLowTemperature;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * The class is for testing class "ControllQuality".
 *
 * @author Olga Fedorova
 * @since 02.10.2016
 * @version 1
 */
public class ControllQualityExtendsTest {

    private final ControllQualityExtends controllQuality = new ControllQualityExtends();
    private final Calendar calendar = Calendar.getInstance();
    private final Shop shop = new Shop();
    private final Trash trash = new Trash();
    private final Warehouse warehouse = new WarehouseLimited(1);
    private final Warehouse warehouseSecond = new WarehouseLimited(1);
    private final WarehouseWithLowTemperature warehouseWithLowTemperature = new WarehouseWithLowTemperature();
    private Date currentDate;

    @Before
    public void init() {
        calendar.set(2016, 8, 15, 0, 0, 0);
        currentDate = calendar.getTime();
        controllQuality.addStorage(shop);
        controllQuality.addStorage(trash);
        controllQuality.addStorage(trash);
        controllQuality.addStorage(warehouse);
        controllQuality.addStorage(warehouseSecond);
        controllQuality.addReproStorage(warehouseWithLowTemperature);
    }

    @Test
    public void testWarehouseReallocate() {
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.DAY_OF_MONTH, 7);
        Date expaireDate = calendar.getTime();
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Milk("milk", createDate, expaireDate, price, discount);
        final AbstractStorageOfFoods storage = controllQuality.control(food, currentDate);
        assertTrue(storage != null && storage.equals(warehouse) && food.getPrice() == price);
    }
    
    @Test
    public void testWarehouseSecondReallocate() {
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.DAY_OF_MONTH, 7);
        Date expaireDate = calendar.getTime();
        double price = 50.0;
        double discount = 10.0;
        final Food food1 = new Milk("milk", createDate, expaireDate, price, discount);
        final Food food2 = new Milk("milk", createDate, expaireDate, price, discount);
        final AbstractStorageOfFoods storage1 = controllQuality.control(food1, currentDate);
        final AbstractStorageOfFoods storage2 = controllQuality.control(food2, currentDate);
        assertTrue(storage1 != null && storage1.equals(warehouse) && food1.getPrice() == price
                && storage2 != null && storage2.equals(warehouseSecond) && food2.getPrice() == price);
    }

    @Test
    public void testShopReallocate() {
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 30);
        Date expaireDate = calendar.getTime();
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Chicken("chicken", createDate, expaireDate, price, discount);
        final AbstractStorageOfFoods storage = controllQuality.control(food, currentDate);
        assertTrue(storage != null && storage.equals(shop) && food.getPrice() == price);
    }

    @Test
    public void testShopReallocateAndLow() {
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        Date expaireDate = calendar.getTime();
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Chicken("chicken", createDate, expaireDate, price, discount);
        final AbstractStorageOfFoods storage = controllQuality.control(food, currentDate);
        assertTrue(storage != null && storage.equals(shop) && food.getPrice() == price - discount);
    }

    @Test
    public void testTrashReallocate() {
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 13);
        Date expaireDate = calendar.getTime();
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Chicken("chicken", createDate, expaireDate, price, discount);
        final AbstractStorageOfFoods storage = controllQuality.control(food, currentDate);
        assertTrue(storage != null && storage.equals(trash) && food.getPrice() == price);
    }
    
    @Test
    public void testWarehouseWithLowTemperatureReallocate() {
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 13);
        Date expaireDate = calendar.getTime();
        double price = 50.0;
        double discount = 10.0;
        final FoodReproduct food = new Tomato("tomato red", createDate, expaireDate, price, discount, true);
        final AbstractReproStorage storage = controllQuality.control(food, currentDate);
        assertTrue(storage != null && storage.equals(warehouseWithLowTemperature) && food.getPrice() == price);
    }

}
