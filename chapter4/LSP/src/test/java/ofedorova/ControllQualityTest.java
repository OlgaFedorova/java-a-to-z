package ofedorova;

import java.util.Calendar;
import java.util.Date;
import ofedorova.foods.Chicken;
import ofedorova.foods.Food;
import ofedorova.foods.Milk;
import ofedorova.storages.Shop;
import ofedorova.storages.Trash;
import ofedorova.storages.Warehouse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * The class is for testing class "ControllQuality".
 * @author Olga Fedorova
 * @since 02.10.2016
 * @version 1
 */
public class ControllQualityTest {
    
    private final ControllQuality controllQuality = new ControllQuality();
    private final Calendar calendar = Calendar.getInstance();
    private final Shop shop = new Shop();
    private final Trash trash = new Trash();
    private final Warehouse warehouse = new Warehouse();
    
    @Before
    public void init(){
        calendar.set(2016, 8, 15, 0, 0, 0);
        controllQuality.setCurrentDate(calendar.getTime());
        controllQuality.addStorage(shop);
        controllQuality.addStorage(trash);
        controllQuality.addStorage(warehouse);
    }
    
    @Test
    public void testWarehouseReallocate(){
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.MONTH, 9);
        calendar.set(Calendar.DAY_OF_MONTH, 7);
        Date expaireDate = calendar.getTime(); 
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Milk("milk", createDate, expaireDate, price, discount);
        controllQuality.control(food);
        assertTrue(warehouse.getFoods().length == 1 && food.getPrice() == price);
    }
    
    @Test
    public void testShopReallocate(){
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 30);
        Date expaireDate = calendar.getTime();   
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Chicken("chicken", createDate, expaireDate, price, discount);
        controllQuality.control(food);
        assertTrue(shop.getFoods().length == 1 && food.getPrice() == price);
    }
    
    @Test
    public void testShopReallocateAndLow(){
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        Date expaireDate = calendar.getTime();   
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Chicken("chicken", createDate, expaireDate, price, discount);
        controllQuality.control(food);
        assertTrue(shop.getFoods().length == 1 && food.getPrice() == price - discount);
    }
    
    @Test
    public void testTrashReallocate(){
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        Date createDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 13);
        Date expaireDate = calendar.getTime();   
        double price = 50.0;
        double discount = 10.0;
        final Food food = new Chicken("chicken", createDate, expaireDate, price, discount);
        controllQuality.control(food);
        assertTrue(trash.getFoods().length == 1 && food.getPrice() == price);
    }
    
}
