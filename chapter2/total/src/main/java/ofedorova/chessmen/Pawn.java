package ofedorova.chessmen;

import ofedorova.ChessBoard;
import ofedorova.IllegalPositionError;
import ofedorova.Position;

/**
 * The class implements chessman of Pawn.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class Pawn extends Chessman{
    
    private boolean moveUp;

    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
        this.moveUp = position.getY() != 1;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
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
        
        if(newPosition.getX() == this.getPosition().getX()
            &&((this.moveUp && this.getPosition().getY() == 6 
                    && this.getPosition().getY() - newPosition.getY()> 0
                    && this.getPosition().getY() - newPosition.getY()<= 2)
            ||(!this.moveUp && this.getPosition().getY() == 1 
                    && newPosition.getY() - this.getPosition().getY()> 0
                    && newPosition.getY() - this.getPosition().getY()<= 2)
            ||(this.moveUp && this.getPosition().getY() != 6 
                    && this.getPosition().getY() - newPosition.getY()== 1)
            ||(!this.moveUp && this.getPosition().getY() != 1 
                    && newPosition.getY() - this.getPosition().getY()== 1))){

            result = board.checkStep(this, newPosition, newPosition.getX(), newPosition.getY());
        }
        else {
            throw new IllegalPositionError("The pawn can't moves on this path.");
        }

        return result;
    }
}
