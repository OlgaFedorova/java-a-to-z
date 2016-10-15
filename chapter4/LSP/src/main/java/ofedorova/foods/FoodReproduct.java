package ofedorova.foods;

import java.util.Date;

/**
 * The class implements abstract model of reproduct food.
 *
 * @author Olga Fedorova
 * @since 15.09.2016
 * @version 1
 */
public class FoodReproduct extends Food {

    /**
     * Sign that food can reproduct
     */
    protected boolean canReproduct;

    /**
     * Allocates a new {@code FoodReproduct}
     *
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount
     */
    public FoodReproduct(String name, Date createDate, Date expaireDate, double price, double discount) {
        super(name, createDate, expaireDate, price, discount);
    }

    /**
     * Allocates a new {@code FoodReproduct}
     *
     * @param canReproduct
     * @param name
     * @param createDate
     * @param expaireDate
     * @param price
     * @param discount
     */
    public FoodReproduct(String name, Date createDate, Date expaireDate, double price, double discount, boolean canReproduct) {
        this(name, createDate, expaireDate, price, discount);
        this.canReproduct = canReproduct;
    }

    /**
     * Getter for field "canReproduct"
     *
     * @return
     */
    public boolean isCanReproduct() {
        return this.canReproduct;
    }

}
