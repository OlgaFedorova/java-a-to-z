package ofedorova.foods;

import java.util.Date;

/**
 * The class implements food "Milk".
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public class Milk extends Food{
    
    /**
     * Allocates a new {@code Milk}
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount 
     */
    public Milk(String name, Date createDate, Date expaireDate, double price, double discount) {
        super(name, createDate, expaireDate, price, discount);
    }
    
    
}
