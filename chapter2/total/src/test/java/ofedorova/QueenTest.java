package ofedorova;

import ofedorova.chessmen.Queen;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * The class is for testing behavior Queen.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class QueenTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of left moving.
    */
    @Test
    public void testQueenLeftMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(3, 2), true);
        board.addChessman(queen);
        
        //двигаем ферзя влево
        board.move(queen, new Position(0, 2));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(0, 2), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of right moving.
    */
    @Test
    public void testQueenRightMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(0, 2), true);
        board.addChessman(queen);
        
        //двигаем ферзя вправо
        board.move(queen, new Position(6, 2));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(6, 2), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of up moving.
    */
    @Test
    public void testQueenUpMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(6, 2), true);
        board.addChessman(queen);
        
        //двигаем ферзя вверх
        board.move(queen, new Position(6, 0));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(6, 0), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of down moving.
    */
    @Test
    public void testQueenDownMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(6, 0), true);
        board.addChessman(queen);
        
        //двигаем ферзя ввниз
        board.move(queen, new Position(6, 6));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(6, 6), true));
        assertEquals(board, check);
    }
    
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of left-up moving.
    */
    @Test
    public void testQueenLeftUpMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(2, 3), true);
        board.addChessman(queen);
        
        //двигаем ферзя влево и вверх
        board.move(queen, new Position(0,1));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(0,1), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of right-up moving.
    */
    @Test
    public void testQueenRightUpMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(2,3), true);
        board.addChessman(queen);
        
        //двигаем ферзя вправо и вверх
        board.move(queen, new Position(4,1));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(4,1), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of left-down moving.
    */
    @Test
    public void testQueenLeftDownMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(2, 3), true);
        board.addChessman(queen);
        
        //двигаем ферзя влево и вниз
        board.move(queen, new Position(0,5));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(0,5), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Queen, if there isn't other chessmen on the path of right-down moving.
    */
    @Test
    public void testQueenRightDownMove() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(2,3), true);
        board.addChessman(queen);
        
        //двигаем ферзя вправо и вверх
        board.move(queen, new Position(4, 5));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(4, 5), true));
        assertEquals(board, check);
    }

    /*
    * The method tests behavior chessman of Queen, if there is enemy chessmen on the path of moving.
    */
    @Test
    public void testQueenEnemyChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(2,3), true);
        board.addChessman(queen);
        final Queen queenEnemy = new Queen(new Position(4, 5), false);
        board.addChessman(queenEnemy);
        
        board.move(queen, new Position(4, 5));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Queen(new Position(4, 5), true));
        assertEquals(board, check);
        
    }
    
    /*
    * The method tests behavior chessman of Queen, if position is null.
    */
    @Test
    public void testQueenErrorNullPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(3, 2), true);
        board.addChessman(queen);
        
        exception.expect(IllegalPositionError.class);
        board.move(queen, null);
    }
    
    /*
    * The method tests behavior chessman of Queen, if position is out of upper boder.
    */
    @Test
    public void testQueenErrorPositionOutOfUpperBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(3, 2), true);
        board.addChessman(queen);
        
        exception.expect(IllegalPositionError.class);
        board.move(queen, new Position(7, -1));
    }
    
    /*
    * The method tests behavior chessman of Queen, if position is out of lower boder.
    */
    @Test
    public void testQueenErrorPositionOutOfLowerBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(2, 3), true);
        board.addChessman(queen);
        
        exception.expect(IllegalPositionError.class);
        board.move(queen, new Position(7, 8));
    }
    
    /*
    * The method tests behavior chessman of Queen, if position is out of left boder.
    */
    @Test
    public void testQueenErrorPositionOutOfLeftBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(2, 3), true);
        board.addChessman(queen);
        
        exception.expect(IllegalPositionError.class);
        board.move(queen, new Position(-1, 0));
    }
    
    /*
    * The method tests behavior chessman of Queen, if position is out of right boder.
    */
    @Test
    public void testQueenErrorPositionOutOfRightBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(3, 2), true);
        board.addChessman(queen);
        
        exception.expect(IllegalPositionError.class);
        board.move(queen, new Position(8,7));
    }
    
    /*
    * The method tests behavior chessman of Queen, if position is for incorrect moving.
    */
    @Test
    public void testQueenErrorIncorrectPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(3, 2), true);
        board.addChessman(queen);
        
        exception.expect(IllegalPositionError.class);
        board.move(queen, new Position(5,6));
    }
    
    /*
    * The method tests behavior chessman of Queen, if there is other chessmen on the path of moving.
    */
    @Test
    public void testQueenErrorOtherChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Queen queen = new Queen(new Position(3, 2), true);
        board.addChessman(queen);
        final Queen queenOther = new Queen(new Position(5,4), true);
        board.addChessman(queenOther);
        
        exception.expect(IllegalPositionError.class);
        board.move(queen, new Position(6,5));
    }
    
}
