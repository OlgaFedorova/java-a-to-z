package ofedorova.foods;

import java.util.Date;

/**
 * The class implements food "Sugar".
 * @author Olga Fedorova
 * @since 26.09.2016
 * @version 1
 */
public class Sugar extends Food{
    
    /**
     * Allocates a new {@code Sugar}
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount 
     */
    public Sugar(String name, Date createDate, Date expaireDate, double price, double discount) {
        super(name, createDate, expaireDate, price, discount);
    }
    
    
}
