package ofedorova;

import ofedorova.chessmen.King;
import ofedorova.chessmen.Pawn;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * The class is for testing behavior King.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class KingTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
     
    /*
    * The method tests behavior chessman of King in positin with coordinate x-1, y-1
    */
    @Test
    public void testKingMovePosition1() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(2,1);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King in positin with coordinate x, y-1
    */
    @Test
    public void testKingMovePosition2() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(3,1);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King in positin with coordinate x+1, y-1
    */
    @Test
    public void testKingMovePosition3() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(4,1);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King in positin with coordinate x-1, y
    */
    @Test
    public void testKingMovePosition4() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(2,2);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King in positin with coordinate x+1, y
    */
    @Test
    public void testKingMovePosition5() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(4,2);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King in positin with coordinate x-1, y+1
    */
    @Test
    public void testKingMovePosition6() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(2,3);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King in positin with coordinate x, y+1
    */
    @Test
    public void testKingMovePosition7() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(3,3);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King in positin with coordinate x+1, y+1
    */
    @Test
    public void testKingMovePosition8() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        final Position newPosition = new Position(4,3);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of King, if there is enemy chessmen on the path of moving.
    */
    @Test
    public void testKingEnemyChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        final Pawn pawnEnemy = new Pawn(new Position(4,3), false);
        board.addChessman(pawnEnemy);
        
        final Position newPosition = new Position(4,3);
        board.move(king, newPosition);
        
        //данные для проверки
        assertEquals(king.getPosition(), newPosition);
        
    }
    
    /*
    * The method tests behavior chessman of King, if position is null.
    */
    @Test
    public void testKingErrorNullPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        exception.expect(IllegalPositionError.class);
        board.move(king, null);
    }
    
    /*
    * The method tests behavior chessman of King, if position is out of upper boder.
    */
    @Test
    public void testKingErrorPositionOutOfUpperBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        exception.expect(IllegalPositionError.class);
        board.move(king, new Position(7, -1));
    }
    
    /*
    * The method tests behavior chessman of King, if position is out of lower boder.
    */
    @Test
    public void testKingErrorPositionOutOfLowerBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(2, 3), true);
        board.addChessman(king);
        
        exception.expect(IllegalPositionError.class);
        board.move(king, new Position(7, 8));
    }
    
    /*
    * The method tests behavior chessman of King, if position is out of left boder.
    */
    @Test
    public void testKingErrorPositionOutOfLeftBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3,2), true);
        board.addChessman(king);
        
        exception.expect(IllegalPositionError.class);
        board.move(king, new Position(-1, 0));
    }
    
    /*
    * The method tests behavior chessman of King, if position is out of right boder.
    */
    @Test
    public void testKingErrorPositionOutOfRightBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        exception.expect(IllegalPositionError.class);
        board.move(king, new Position(8,7));
    }
    
    /*
    * The method tests behavior chessman of King, if position is for incorrect moving.
    */
    @Test
    public void testKingErrorIncorrectPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        
        exception.expect(IllegalPositionError.class);
        board.move(king, new Position(5,4));
    }
    
    /*
    * The method tests behavior chessman of King, if there is other chessmen on the path of moving.
    */
    @Test
    public void testKingErrorOtherChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final King king = new King(new Position(3, 2), true);
        board.addChessman(king);
        final Pawn pawnOther = new Pawn(new Position(4,3), true);
        board.addChessman(pawnOther);
        
        exception.expect(IllegalPositionError.class);
        board.move(king, new Position(4,3));
    }
    
    
}
