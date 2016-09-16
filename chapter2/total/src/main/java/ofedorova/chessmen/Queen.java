package ofedorova.chessmen;

import ofedorova.IllegalPositionError;
import ofedorova.Position;
import ofedorova.movements.MovementByDiagonalOnNStep;
import ofedorova.movements.MovementByLineOnNStep;

/**
 * The class implements chessman of Queen.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class Queen extends Chessman{

    public Queen(Position position, boolean isWhite) {
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
        
        if((result = new MovementByLineOnNStep().excute(this, newPosition)) == null
                && (result = new MovementByDiagonalOnNStep().excute(this, newPosition)) == null){
            throw new IllegalPositionError("The queen can't moves on this path.");
        }
        return result;
    }
}
