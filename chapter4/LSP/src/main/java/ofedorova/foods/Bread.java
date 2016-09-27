package ofedorova.foods;

import java.util.Date;

/**
 * The class implements food "Bread".
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public class Bread extends Food{
    
    /**
     * Allocates a new {@code Bread}
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount 
     */
    public Bread(String name, Date createDate, Date expaireDate, double price, double discount) {
        super(name, createDate, expaireDate, price, discount);
    }
 
}
