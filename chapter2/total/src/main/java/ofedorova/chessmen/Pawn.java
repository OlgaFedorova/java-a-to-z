package ofedorova.chessmen;

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
    * @param new position
    * @return array of position on path moving.
    * @throws IllegalPositionError, if new position is incorrect.
    */
    @Override
    public Position[] changePosition(Position newPosition) throws IllegalPositionError {
        Position[] result = null;
        int index = 0;
        if(newPosition.getX() == this.getPosition().getX()
            &&((this.moveUp && this.getPosition().getY() == 6 
                    && this.getPosition().getY() - newPosition.getY()> 0
                    && this.getPosition().getY() - newPosition.getY()<= 2)
            ||(this.moveUp && this.getPosition().getY() != 6 
                    && this.getPosition().getY() - newPosition.getY()== 1))){
            
            result = new Position[this.getPosition().getY() - newPosition.getY()];
            for(int y = this.getPosition().getY() - 1; y >= newPosition.getY(); y--){
                result[index++] = new Position(this.getPosition().getX(), y);
            }
        }
        else if(newPosition.getX() == this.getPosition().getX()
            &&((!this.moveUp && this.getPosition().getY() == 1 
                    && newPosition.getY() - this.getPosition().getY()> 0
                    && newPosition.getY() - this.getPosition().getY()<= 2)
           
            ||(!this.moveUp && this.getPosition().getY() != 1 
                    && newPosition.getY() - this.getPosition().getY()== 1))){
            
            result = new Position[newPosition.getY() - this.getPosition().getY()];
            for(int y = this.getPosition().getY() + 1; y <= newPosition.getY(); y++){
                result[index++] = new Position(this.getPosition().getX(), y);
            }
        }
        else {
            throw new IllegalPositionError("The pawn can't moves on this path.");
        }

        return result;
    }
}
