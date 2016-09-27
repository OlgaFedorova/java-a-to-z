package ofedorova.foods;

import java.util.Date;

/**
 * The class implements abstract model of food.
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public abstract class Food {
    /**
     * Name of food
     */
    protected String name;
    /**
     * Date create of food
     */
    protected Date createDate;
    /**
     * Date expaire of food
     */
    protected Date expaireDate;
    /**
     * Price of food
     */
    protected double price;
    /**
     * Discount of food
     */
    protected double discount;

    /**
     * Allocates a new {@code Food}
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount 
     */
    public Food(String name, Date createDate, Date expaireDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expaireDate = expaireDate;
        this.price = price;
        this.discount = discount;
    }
    
}
