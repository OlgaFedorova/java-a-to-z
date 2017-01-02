package ofedorova;

import ofedorova.chessmen.Rook;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * The class is for testing behavior Rook.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class RookTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    /*
    * The method tests behavior chessman of Rook, if there isn't other chessmen on the path of left moving.
    */
    @Test
    public void testRookLeftMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        
        //двигаем ладью влево
        final Position newPosition = new Position(0,2);
        board.move(rook, newPosition);
        
        //данные для проверки
        assertEquals(rook.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Rook, if there isn't other chessmen on the path of right moving.
    */
    @Test
    public void testRookRightMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(0, 2), true);
        board.addChessman(rook);
        
        //двигаем ладью вправо
        final Position newPosition = new Position(6,2);
        board.move(rook, newPosition);
        
        //данные для проверки
        assertEquals(rook.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Rook, if there isn't other chessmen on the path of up moving.
    */
    @Test
    public void testRookUpMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(6, 2), true);
        board.addChessman(rook);
        
        //двигаем ладью вверх
        final Position newPosition = new Position(6,0);
        board.move(rook, newPosition);
        
        //данные для проверки
        assertEquals(rook.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Rook, if there isn't other chessmen on the path of down moving.
    */
    @Test
    public void testRookDownMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(6, 0), true);
        board.addChessman(rook);
        
        //двигаем ладью ввниз
        final Position newPosition = new Position(6,6);
        board.move(rook, newPosition);
        
        //данные для проверки
        assertEquals(rook.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Rook, if there is enemy chessmen on the path of moving.
    */
    @Test
    public void testRookEnemyChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        final Rook rookEnemy = new Rook(new Position(6, 2), false);
        board.addChessman(rookEnemy);
        
        final Position newPosition = new Position(6,2);
        board.move(rook, newPosition);
        
        //данные для проверки
        assertEquals(rook.getPosition(), newPosition);
        
    }
    
    /*
    * The method tests behavior chessman of Rook, if position is null.
    */
    @Test
    public void testRookErrorNullPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        
        exception.expect(IllegalPositionError.class);
        board.move(rook, null);
    }
    
    /*
    * The method tests behavior chessman of Rook, if position is out of upper boder.
    */
    @Test
    public void testRookErrorPositionOutOfUpperBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        
        exception.expect(IllegalPositionError.class);
        board.move(rook, new Position(3, -2));
    }
    
    /*
    * The method tests behavior chessman of Rook, if position is out of lower boder.
    */
    @Test
    public void testRookErrorPositionOutOfLowerBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        
        exception.expect(IllegalPositionError.class);
        board.move(rook, new Position(3, 9));
    }
    
    /*
    * The method tests behavior chessman of Rook, if position is out of left boder.
    */
    @Test
    public void testRookErrorPositionOutOfLeftBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        
        exception.expect(IllegalPositionError.class);
        board.move(rook, new Position(-2, 2));
    }
    
    /*
    * The method tests behavior chessman of Rook, if position is out of right boder.
    */
    @Test
    public void testRookErrorPositionOutOfRightBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        
        exception.expect(IllegalPositionError.class);
        board.move(rook, new Position(9, 2));
    }
    
    /*
    * The method tests behavior chessman of Rook, if position is for incorrect moving.
    */
    @Test
    public void testRookErrorIncorrectPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        
        exception.expect(IllegalPositionError.class);
        board.move(rook, new Position(5, 4));
    }
    
    /*
    * The method tests behavior chessman of Rook, if there is other chessmen on the path of moving.
    */
    @Test
    public void testRookErrorOtherChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Rook rook = new Rook(new Position(3, 2), true);
        board.addChessman(rook);
        final Rook rookOther = new Rook(new Position(6, 2), true);
        board.addChessman(rookOther);
        
        exception.expect(IllegalPositionError.class);
        board.move(rook, new Position(6, 2));
    }
    

    
}
