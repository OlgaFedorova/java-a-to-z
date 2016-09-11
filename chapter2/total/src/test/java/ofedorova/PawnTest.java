package ofedorova;

import ofedorova.chessmen.Pawn;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * The class is for testing behavior Pawn.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class PawnTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
     
    /*
    * The method tests behavior chessman of Pawn upper with start position by 2 step
    */
    @Test
    public void testPawnMoveUpStartPosition1() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        board.move(pawn, new Position(3,4));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Pawn(new Position(3,4), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Pawn upper with start position by 1 step
    */
    @Test
    public void testPawnMoveUpStartPosition2() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        board.move(pawn, new Position(3,5));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Pawn(new Position(3,5), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Pawn upper
    */
    @Test
    public void testPawnMoveUp() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 4), true);
        board.addChessman(pawn);
        
        board.move(pawn, new Position(3,3));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Pawn(new Position(3,3), true));
        assertEquals(board, check);
    }
    
    
    /*
    * The method tests behavior chessman of Pawn lower with start position by 2 step
    */
    @Test
    public void testPawnMoveLowerStartPosition1() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        board.move(pawn, new Position(3,3));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Pawn(new Position(3,3), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Pawn lower with start position by 1 step
    */
    @Test
    public void testPawnMoveLowerStartPosition2() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        board.move(pawn, new Position(3,2));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Pawn(new Position(3,2), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Pawn lower
    */
    @Test
    public void testPawnMoveLower() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 4), true);
        pawn.setMoveUp(false);
        board.addChessman(pawn);
        
        board.move(pawn, new Position(3,5));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Pawn(new Position(3,5), true));
        assertEquals(board, check);
    }
    
    /*
    * The method tests behavior chessman of Pawn, if there is enemy chessmen on the path of moving.
    */
    @Test
    public void testPawnEnemyChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        final Pawn pawnEnemy = new Pawn(new Position(3,3), false);
        board.addChessman(pawnEnemy);
        
        board.move(pawn, new Position(3,3));
        
        //данные для проверки
        ChessBoard check = new ChessBoard();
        check.addChessman(new Pawn(new Position(3,3), true));
        assertEquals(board, check);
        
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is null.
    */
    @Test
    public void testPawnErrorNullPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 2), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, null);
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is out of upper boder.
    */
    @Test
    public void testPawnErrorPositionOutOfUpperBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 2), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(7, -1));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is out of lower boder.
    */
    @Test
    public void testPawnErrorPositionOutOfLowerBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(2, 3), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(7, 8));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is out of left boder.
    */
    @Test
    public void testPawnErrorPositionOutOfLeftBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3,2), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(-1, 0));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is out of right boder.
    */
    @Test
    public void testPawnErrorPositionOutOfRightBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 2), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(8,7));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown1() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(3,1));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown2() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(3,6));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown4() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(2,2));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown5() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(4,2));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown6() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(2,3));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown7() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(4,3));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown8() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(2,0));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown9() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(4,0));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown10() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(3,7));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown11() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(3,3));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown12() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(2,6));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown13() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(4,6));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown14() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(2,5));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown15() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(4,5));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown16() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(2,7));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if position is for incorrect moving.
    */
    @Test
    public void testPawnErrorIncorrectPositionDown17() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 6), true);
        board.addChessman(pawn);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(4,7));
    }
    
    /*
    * The method tests behavior chessman of Pawn, if there is other chessmen on the path of moving.
    */
    @Test
    public void testPawnErrorOtherChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Pawn pawn = new Pawn(new Position(3, 1), true);
        board.addChessman(pawn);
        final Pawn pawnOther = new Pawn(new Position(3,3), true);
        board.addChessman(pawnOther);
        
        exception.expect(IllegalPositionError.class);
        board.move(pawn, new Position(3,3));
    }
    
    
}
