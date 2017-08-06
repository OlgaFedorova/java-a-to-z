
package ofedorova.movements;

import ofedorova.Position;
import ofedorova.chessmen.Chessman;

/**
 * The class implements model of movement by diagonal on n-step. 
 * @author Olga Fedorova
 * @since 11.09.2016
 * @version 1
 */
public class MovementByDiagonalOnNStep implements Movement{
    
    /*
    * The method implements a specific movement.
    * @param chessman, new position
    * @return array of position on path moving.
    */
    @Override
    public Position[] excute(Chessman chessman, Position newPosition){
        Position[] result = null;
        int index = 0;
        if(chessman.getPosition().getY() > newPosition.getY()){
            if(newPosition.getX() == chessman.getPosition().getX() + chessman.getPosition().getY() - newPosition.getY()){
                result = new Position[chessman.getPosition().getY() - newPosition.getY()];
                int x = chessman.getPosition().getX()+1;
                for(int y = chessman.getPosition().getY()-1; y >= newPosition.getY(); y--){
                    result[index++] = new Position(x++, y);
                }
            }
            else if(newPosition.getX() == chessman.getPosition().getX() - chessman.getPosition().getY() + newPosition.getY()){
                result = new Position[chessman.getPosition().getY() - newPosition.getY()];
                int x = chessman.getPosition().getX()-1;
                for(int y = chessman.getPosition().getY()-1; y >= newPosition.getY(); y--){
                    result[index++] = new Position(x--, y);
                }
            }
        }
        else { 
            if(newPosition.getX() == chessman.getPosition().getX() + newPosition.getY() - chessman.getPosition().getY()){
                result = new Position[newPosition.getY() - chessman.getPosition().getY()];
                int x = chessman.getPosition().getX()+1;
                for(int y = chessman.getPosition().getY()+1; y <= newPosition.getY(); y++){
                    result[index++] = new Position(x++, y);
                }
            }
            else if(newPosition.getX() == chessman.getPosition().getX() - newPosition.getY() + chessman.getPosition().getY()){
                result = new Position[newPosition.getY() - chessman.getPosition().getY()];
                int x = chessman.getPosition().getX()-1;
                for(int y = chessman.getPosition().getY()+1; y <= newPosition.getY(); y++){
                    result[index++] = new Position(x--, y);
                 }
            }
        }
         return result;
    }
    
}
