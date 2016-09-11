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
    * @param chessboard, chessman, new position
    * @return true or false
    * @throws IllegalPositionError, if new position is incorrect.
    */
    @Override
    public boolean excute(ChessBoard board, Chessman chessman, Position newPosition) throws IllegalPositionError{
        boolean result = false;
        if(chessman.getPosition().getX() == newPosition.getX()){
            if(chessman.getPosition().getY() > newPosition.getY()){
                for(int y = chessman.getPosition().getY() - 1; y >= newPosition.getY(); y--){
                    result = board.checkStep(chessman, newPosition, chessman.getPosition().getX(), y);
                }
            }
            else{
                for(int y = chessman.getPosition().getY() + 1; y <= newPosition.getY(); y++){
                    result = board.checkStep(chessman, newPosition, chessman.getPosition().getX(), y);
                }
            }
        }
        else if (chessman.getPosition().getY() == newPosition.getY()){
            if(chessman.getPosition().getX() > newPosition.getX()){
                for(int x = chessman.getPosition().getX() - 1; x >= newPosition.getX(); x--){
                    result = board.checkStep(chessman, newPosition, x, chessman.getPosition().getY());
                }
            }
            else{
                for(int x = chessman.getPosition().getX() + 1; x <= newPosition.getX(); x++){
                    result = board.checkStep(chessman, newPosition, x, chessman.getPosition().getY());
                }
            }
        }
        return result;
    }
    
}
