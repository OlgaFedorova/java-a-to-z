package ofedorova.storages;

import ofedorova.foods.Food;

/**
 * The class implements abstract storage of food.
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public abstract class AbstractStorageOfFoods {
    /**
     * Array for storage foods
     */
    protected Food[] foods = new Food[10];
    /**
     * Position for adding new food in the array "foods".
     */
    private int position = 0;
    
    /**
     * The method adds new food into array "foods".
     * @param food
     * @return 
     *      true - if food is adds success, 
     *      false - else food is adds unsuccess
     */
    public boolean add(Food food){
        if (this.position == this.foods.length){
            Food[] temp = new Food[position + 10];
            System.arraycopy(this.foods, 0, temp, 0, position);
            this.foods = temp;    
        }
        this.foods[position++] = food;
        return true;
    }
    
    /**
     * The method checks a validate the shelf life of product for this storage
     * @param shelfLifeOfProduct
     * @return 
     *      true - if he shelf life of product is validate
     *      false - else
     */     
    public abstract boolean checkShelfLifeOfProduct(int shelfLifeOfProduct);

    /**
     * Getter for field "foods"
     * @return 
     */
    public Food[] getFoods() {
        Food[] result = new Food[position];
        System.arraycopy(this.foods, 0, result, 0, position);
        return result;
    }
   
}
