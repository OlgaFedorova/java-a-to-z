package ofedorova.movements;

import ofedorova.ChessBoard;
import ofedorova.IllegalPositionError;
import ofedorova.Position;
import ofedorova.chessmen.Chessman;

/**
 * The class implements model of movement by line on n-step. 
 * @author Olga Fedorova
 * @since 11.09.2016
 * @version 1
 */
public class MovementByLineOnNStep implements Movement{

    /*
    * The method implements a specific movement.
    * @param chessman, new position
    * @return array of position on path moving.
    */
    @Override
    public Position[] excute(Chessman chessman, Position newPosition){
        Position[] result = null;
        int index = 0;
        if(chessman.getPosition().getX() == newPosition.getX()){
            if(chessman.getPosition().getY() > newPosition.getY()){
                result = new Position[chessman.getPosition().getY() - newPosition.getY()];
                for(int y = chessman.getPosition().getY() - 1; y >= newPosition.getY(); y--){
                    result[index++] = new Position(chessman.getPosition().getX(), y);
                }
            }
            else{
                result = new Position[newPosition.getY() - chessman.getPosition().getY()];
                for(int y = chessman.getPosition().getY() + 1; y <= newPosition.getY(); y++){
                    result[index++] = new Position(chessman.getPosition().getX(), y);
                }
            }
        }
        else if (chessman.getPosition().getY() == newPosition.getY()){
            if(chessman.getPosition().getX() > newPosition.getX()){
                result = new Position[chessman.getPosition().getX() - newPosition.getX()];
                for(int x = chessman.getPosition().getX() - 1; x >= newPosition.getX(); x--){
                    result[index++] = new Position(x, chessman.getPosition().getY());
                }
            }
            else{
                result = new Position[newPosition.getX() - chessman.getPosition().getX()];
                for(int x = chessman.getPosition().getX() + 1; x <= newPosition.getX(); x++){
                    result[index++] = new Position(x, chessman.getPosition().getY());
                }
            }
        }
        return result;
    }
    
}
