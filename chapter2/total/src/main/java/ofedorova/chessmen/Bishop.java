package ofedorova.chessmen;

import ofedorova.IllegalPositionError;
import ofedorova.Position;
import ofedorova.movements.MovementByDiagonalOnNStep;

/**
 * The class implements chessman of Bishop.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class Bishop extends Chessman{

    public Bishop(Position position, boolean isWhite) {
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
        
        if((result = new MovementByDiagonalOnNStep().excute(this, newPosition)) == null){
            throw new IllegalPositionError("The bishop can't moves on this path.");
        }
        return result;
    }
}
