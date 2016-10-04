package ofedorova;

import java.util.Calendar;
import java.util.Date;
import ofedorova.foods.Food;
import ofedorova.storages.AbstractStorageOfFoods;

/**
 * The class implements handler for reallocating foods into the storage.
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
     * Array of storages in a company.
     */
    private AbstractStorageOfFoods[] storages = new AbstractStorageOfFoods[3];
    /**
     * Position for adding new AbstractStorageOfFoods in the array "storages".
     */
    private int position = 0;
    /**
     * Current date
     */
    private Date currentDate = new Date();

    /**
     * Setter for field "current date"
     * @param currentDate 
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    /**
     * The method adds a new storage into array "storages".
     * @param storage 
     */
    public void addStorage(AbstractStorageOfFoods storage){
        if (this.position == this.storages.length){
            AbstractStorageOfFoods[] temp = new AbstractStorageOfFoods[position + 3];
            System.arraycopy(this.storages, 0, temp, 0, position);
            this.storages = temp;    
        }
        this.storages[position++] = storage;
    }
    
    /**
     * The main method controls quality of food 
     * @param food 
     */
    public void control(Food food){
        this.reallocateFood(food);
        this.lowPrice(food);
        //TEST
    }
    
    /**
     * The methods reallocate food into the storage depending the shelf life of product.
     * @param food 
     */
    private void reallocateFood(Food food){
        for(AbstractStorageOfFoods storage : storages){
            if(storage != null && storage.checkShelfLifeOfProduct(this.getShelfLifeOfProductInPercent(food))){
                storage.add(food);
                break;
            }
        }
    }
    
    /**
     * The methods low price of food.
     * @param food 
     */
    private void lowPrice(Food food){
        if(this.getShelfLifeOfProductInPercent(food) > START_SHELF_LIFE_OF_PRODUCT_IN_PERSENT_FOR_LOW_PRICE &&
                this.getShelfLifeOfProductInPercent(food) <= END_SHELF_LIFE_OF_PRODUCT_IN_PERSENT_FOR_LOW_PRICE){
            food.setPriceByDiccount();
        }
    }
    
    /**
     * The method returns a value the shelf life of product in percent.
     * @param food
     * @return life of product in percent
     */
    public int getShelfLifeOfProductInPercent(Food food){
        return Math.round((float) (currentDate.getTime() - food.getCreateDate().getTime())/
                           (food.getExpaireDate().getTime() - food.getCreateDate().getTime()) *100);
    }
}
