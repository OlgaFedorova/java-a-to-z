package ofedorova;

import ofedorova.chessmen.Bishop;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * The class is for testing behavior Bishop.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class BishopTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    /*
    * The method tests behavior chessman of Bishop, if there isn't other chessmen on the path of left-up moving.
    */
    @Test
    public void testBishopLeftUpMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(2, 3), true);
        board.addChessman(bishop);
        
        //двигаем слона влево и вверх
        final Position newPosition = new Position(0,1);
        board.move(bishop, newPosition);
        
        //данные для проверки
        assertEquals(bishop.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Bishop, if there isn't other chessmen on the path of right-up moving.
    */
    @Test
    public void testBishopRightUpMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(2,3), true);
        board.addChessman(bishop);
        
        //двигаем слона вправо и вверх
        final Position newPosition = new Position(4,1);
        board.move(bishop, new Position(4,1));
        
        //данные для проверки
        assertEquals(bishop.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Bishop, if there isn't other chessmen on the path of left-down moving.
    */
    @Test
    public void testBishopLeftDownMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(2, 3), true);
        board.addChessman(bishop);
        
        //двигаем слона влево и вниз
        final Position newPosition = new Position(0,5);
        board.move(bishop, new Position(0,5));
        
        //данные для проверки
        assertEquals(bishop.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Bishop, if there isn't other chessmen on the path of right-down moving.
    */
    @Test
    public void testBishopRightDownMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(2,3), true);
        board.addChessman(bishop);
        
        //двигаем слона вправо и вверх
        final Position newPosition = new Position(4,5);
        board.move(bishop, new Position(4, 5));
        
        //данные для проверки
        assertEquals(bishop.getPosition(), newPosition);
    }

    /*
    * The method tests behavior chessman of Bishop, if there is enemy chessmen on the path of moving.
    */
    @Test
    public void testBishopEnemyChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(2,3), true);
        board.addChessman(bishop);
        final Bishop bishopEnemy = new Bishop(new Position(4, 5), false);
        board.addChessman(bishopEnemy);
        
        final Position newPosition = new Position(4,5);
        board.move(bishop, new Position(4, 5));
        
        //данные для проверки
       assertEquals(bishop.getPosition(), newPosition);
        
    }
    
    /*
    * The method tests behavior chessman of Bishop, if position is null.
    */
    @Test
    public void testBishopErrorNullPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(3, 2), true);
        board.addChessman(bishop);
        
        exception.expect(IllegalPositionError.class);
        board.move(bishop, null);
    }
    
    /*
    * The method tests behavior chessman of Bishop, if position is out of upper boder.
    */
    @Test
    public void testBishopErrorPositionOutOfUpperBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(3, 2), true);
        board.addChessman(bishop);
        
        exception.expect(IllegalPositionError.class);
        board.move(bishop, new Position(7, -1));
    }
    
    /*
    * The method tests behavior chessman of Bishop, if position is out of lower boder.
    */
    @Test
    public void testBishopErrorPositionOutOfLowerBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(2, 3), true);
        board.addChessman(bishop);
        
        exception.expect(IllegalPositionError.class);
        board.move(bishop, new Position(7, 8));
    }
    
    /*
    * The method tests behavior chessman of Bishop, if position is out of left boder.
    */
    @Test
    public void testBishopErrorPositionOutOfLeftBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(2, 3), true);
        board.addChessman(bishop);
        
        exception.expect(IllegalPositionError.class);
        board.move(bishop, new Position(-1, 0));
    }
    
    /*
    * The method tests behavior chessman of Bishop, if position is out of right boder.
    */
    @Test
    public void testBishopErrorPositionOutOfRightBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(3, 2), true);
        board.addChessman(bishop);
        
        exception.expect(IllegalPositionError.class);
        board.move(bishop, new Position(8,7));
    }
    
    /*
    * The method tests behavior chessman of Bishop, if position is for incorrect moving.
    */
    @Test
    public void testBishopErrorIncorrectPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(3, 2), true);
        board.addChessman(bishop);
        
        exception.expect(IllegalPositionError.class);
        board.move(bishop, new Position(3,6));
    }
    
    /*
    * The method tests behavior chessman of Bishop, if there is other chessmen on the path of moving.
    */
    @Test
    public void testBishopErrorOtherChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Bishop bishop = new Bishop(new Position(3, 2), true);
        board.addChessman(bishop);
        final Bishop bishopOther = new Bishop(new Position(5,4), true);
        board.addChessman(bishopOther);
        
        exception.expect(IllegalPositionError.class);
        board.move(bishop, new Position(6,5));
    }
    
}
