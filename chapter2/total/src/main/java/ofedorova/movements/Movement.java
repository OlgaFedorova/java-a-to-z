package ofedorova.movements;

import ofedorova.ChessBoard;
import ofedorova.IllegalPositionError;
import ofedorova.Position;
import ofedorova.chessmen.Chessman;

/**
 * The interface implements model of movement. 
 * For example: by diagonal, by line and etc.
 * @author Olga Fedorova
 * @since 11.09.2016
 * @version 1
 */
public interface Movement {
    
    /*
    * The method implements a specific movement.
    * @param chessboard, chessman, new position
    * @return true or false
    * @throws IllegalPositionError, if new position is incorrect.
    */
    public boolean excute(ChessBoard board, Chessman chessman, Position newPosition) throws IllegalPositionError;    
    
}
