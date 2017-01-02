package ofedorova.foods;

import java.util.Date;

/**
 * The class implements food "Chicken".
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public class Chicken extends Food{
    
    /**
     * Allocates a new {@code Chicken}
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount 
     */
    public Chicken(String name, Date createDate, Date expaireDate, double price, double discount) {
        super(name, createDate, expaireDate, price, discount);
    }
    
}
