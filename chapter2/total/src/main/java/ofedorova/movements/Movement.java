package ofedorova.movements;

import ofedorova.Position;
import ofedorova.chessmen.Chessman;

/**
 * The interface implements model of movement. 
 * For example: by diagonal, by line and etc.
 * @author Olga Fedorova
 * @since 11.09.2016
 * @version 1
 */
public interface Movement {
    
    /*
    * The method implements a specific movement.
    * @param chessman, new position
    * @return array of position on path moving.
    */
    public Position[] excute(Chessman chessman, Position newPosition);    
    
}
