package ofedorova.chessmen;

import ofedorova.ChessBoard;
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
    * @param board, new position
    * @return true or false
    * @throws IllegalPositionError, if new position is incorrect.
    */
    @Override
    public boolean changePosition(ChessBoard board, Position newPosition) throws IllegalPositionError {
        boolean result; 
        
        if(!(result = new MovementByLineOnNStep().excute(board, this, newPosition))
                && !(result = new MovementByDiagonalOnNStep().excute(board, this, newPosition))){
            throw new IllegalPositionError("The queen can't moves on this path.");
        }
        return result;
    }
}
