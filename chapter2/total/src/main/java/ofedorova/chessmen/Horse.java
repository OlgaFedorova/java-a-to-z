package ofedorova.chessmen;

import ofedorova.ChessBoard;
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
    * @param board, new position
    * @return true or false
    * @throws IllegalPositionError, if new position is incorrect.
    */
    @Override
    public boolean changePosition(ChessBoard board, Position newPosition) throws IllegalPositionError {
        boolean result = false;
        
        if(((newPosition.getX() == this.getPosition().getX() + 1 || newPosition.getX() == this.getPosition().getX() - 1) 
            && (newPosition.getY() == this.getPosition().getY() - 2 || newPosition.getY() == this.getPosition().getY() + 2))
            ||((newPosition.getX() == this.getPosition().getX() + 2 || newPosition.getX() == this.getPosition().getX() - 2) 
            && (newPosition.getY() == this.getPosition().getY() - 1 || newPosition.getY() == this.getPosition().getY() + 1))){
            result = board.checkStep(this, newPosition, newPosition.getX(), newPosition.getY());
        }
        else {
            throw new IllegalPositionError("The horse can't moves on this path.");
        }
       
        return result;
    }

}
