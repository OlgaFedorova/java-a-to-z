
package ofedorova.movements;

import ofedorova.ChessBoard;
import ofedorova.IllegalPositionError;
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
    * @param chessboard, chessman, new position
    * @return true or false
    * @throws IllegalPositionError, if new position is incorrect.
    */
    @Override
    public boolean excute(ChessBoard board, Chessman chessman, Position newPosition) throws IllegalPositionError{
        boolean result = false;
        if(chessman.getPosition().getY() > newPosition.getY()){
            if(newPosition.getX() == chessman.getPosition().getX() + chessman.getPosition().getY() - newPosition.getY()){
                for(int y = chessman.getPosition().getY()-1; y >= newPosition.getY(); y--){
                    for(int x = chessman.getPosition().getX()+1; x <= newPosition.getX(); x++){
                        result = board.checkStep(chessman, newPosition, x, y);
                    }
                }
            }
            else if(newPosition.getX() == chessman.getPosition().getX() - chessman.getPosition().getY() + newPosition.getY()){
                for(int y = chessman.getPosition().getY()-1; y >= newPosition.getY(); y--){
                    for(int x = chessman.getPosition().getX()-1; x >= newPosition.getX(); x--){
                        result = board.checkStep(chessman, newPosition, x, y);
                    }
                }
            }
        }
        else { 
            if(newPosition.getX() == chessman.getPosition().getX() + newPosition.getY() - chessman.getPosition().getY()){
                for(int y = chessman.getPosition().getY()+1; y <= newPosition.getY(); y++){
                    for(int x = chessman.getPosition().getX()+1; x <= newPosition.getX(); x++){
                        result = board.checkStep(chessman, newPosition, x, y);
                    }
                }
            }
            else if(newPosition.getX() == chessman.getPosition().getX() - newPosition.getY() + chessman.getPosition().getY()){
                for(int y = chessman.getPosition().getY()+1; y <= newPosition.getY(); y++){
                    for(int x = chessman.getPosition().getX()-1; x >= newPosition.getX(); x--){
                        result = board.checkStep(chessman, newPosition, x, y);
                    }
                }
            }
        }
         return result;
    }
    
}
