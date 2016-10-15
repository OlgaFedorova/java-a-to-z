package ofedorova.foods;

import java.util.Date;

/**
 * The class implements food "Tomato".
 *
 * @author Olga Fedorova
 * @since 11.10.2016
 * @version 1
 */
public class Tomato extends FoodReproduct {

    /**
     * Allocates a new {@code Tomato}
     *
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount
     * @param canReproduct
     */
    public Tomato(String name, Date createDate, Date expaireDate, double price, double discount, boolean canReproduct) {
        super(name, createDate, expaireDate, price, discount, canReproduct);
    }
}
