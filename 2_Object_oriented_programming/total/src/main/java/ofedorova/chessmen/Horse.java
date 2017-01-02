package ofedorova.chessmen;

import ofedorova.IllegalPositionError;
import ofedorova.Position;

/**
 * The class implements chessman of Horse.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class Horse extends Chessman{

    public Horse(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    /*
    * The method moves chessman to change position.
    * @param new position
    * @return array of position on path moving.
    * @throws IllegalPositionError, if new position is incorrect.
    */
    @Override
    public Position[] changePosition(Position newPosition) throws IllegalPositionError {
        Position[] result = null;
        
        if(((newPosition.getX() == this.getPosition().getX() + 1 || newPosition.getX() == this.getPosition().getX() - 1) 
            && (newPosition.getY() == this.getPosition().getY() - 2 || newPosition.getY() == this.getPosition().getY() + 2))
            ||((newPosition.getX() == this.getPosition().getX() + 2 || newPosition.getX() == this.getPosition().getX() - 2) 
            && (newPosition.getY() == this.getPosition().getY() - 1 || newPosition.getY() == this.getPosition().getY() + 1))){
            result = new Position[1];
            result[0] = newPosition;
        }
        else {
            throw new IllegalPositionError("The horse can't moves on this path.");
        }
       
        return result;
    }

}
