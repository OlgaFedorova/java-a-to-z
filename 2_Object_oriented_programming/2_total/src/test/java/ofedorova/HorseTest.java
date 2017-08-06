package ofedorova;

import ofedorova.chessmen.Horse;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 * The class is for testing behavior Horse.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class HorseTest {
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
     
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x-1, y-2
    */
    @Test
    public void testHorseMovePosition1() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(2,0);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x+1, y-2
    */
    @Test
    public void testHorseMovePosition2() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(4,0);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x+2, y-1
    */
    @Test
    public void testHorseMovePosition3() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(5,1);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x+2, y+1
    */
    @Test
    public void testHorseMovePosition4() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(5,3);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x+1, y+2
    */
    @Test
    public void testHorseMovePosition5() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(4,4);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x-1, y+2
    */
    @Test
    public void testHorseMovePosition6() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(2,4);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x-2, y+1
    */
    @Test
    public void testHorseMovePosition7() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(1,3);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse in positin with coordinate x-2, y-1
    */
    @Test
    public void testHorseMovePosition8() throws IllegalPositionError{
        //исходные данные
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        final Position newPosition = new Position(1,1);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
    }
    
    /*
    * The method tests behavior chessman of Horse, if there is enemy chessmen on the path of moving.
    */
    @Test
    public void testHorseEnemyChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        final Horse horseEnemy = new Horse(new Position(1,1), false);
        board.addChessman(horseEnemy);
        
        final Position newPosition = new Position(1,1);
        board.move(horse, newPosition);
        
        //данные для проверки
        assertEquals(horse.getPosition(), newPosition);
        
    }
    
    /*
    * The method tests behavior chessman of Horse, if position is null.
    */
    @Test
    public void testHorseErrorNullPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        exception.expect(IllegalPositionError.class);
        board.move(horse, null);
    }
    
    /*
    * The method tests behavior chessman of Horse, if position is out of upper boder.
    */
    @Test
    public void testHorseErrorPositionOutOfUpperBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        exception.expect(IllegalPositionError.class);
        board.move(horse, new Position(7, -1));
    }
    
    /*
    * The method tests behavior chessman of Horse, if position is out of lower boder.
    */
    @Test
    public void testHorseErrorPositionOutOfLowerBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(2, 3), true);
        board.addChessman(horse);
        
        exception.expect(IllegalPositionError.class);
        board.move(horse, new Position(7, 8));
    }
    
    /*
    * The method tests behavior chessman of Horse, if position is out of left boder.
    */
    @Test
    public void testHorseErrorPositionOutOfLeftBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3,2), true);
        board.addChessman(horse);
        
        exception.expect(IllegalPositionError.class);
        board.move(horse, new Position(-1, 0));
    }
    
    /*
    * The method tests behavior chessman of Horse, if position is out of right boder.
    */
    @Test
    public void testHorseErrorPositionOutOfRightBorder() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        exception.expect(IllegalPositionError.class);
        board.move(horse, new Position(8,7));
    }
    
    /*
    * The method tests behavior chessman of Horse, if position is for incorrect moving.
    */
    @Test
    public void testHorseErrorIncorrectPosition() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        
        exception.expect(IllegalPositionError.class);
        board.move(horse, new Position(3,3));
    }
    
    /*
    * The method tests behavior chessman of Horse, if there is other chessmen on the path of moving.
    */
    @Test
    public void testHorseErrorOtherChessmen() throws IllegalPositionError{
        //Исходные данные   
        final ChessBoard board = new ChessBoard();
        final Horse horse = new Horse(new Position(3, 2), true);
        board.addChessman(horse);
        final Horse horseOther = new Horse(new Position(1,1), true);
        board.addChessman(horseOther);
        
        exception.expect(IllegalPositionError.class);
        board.move(horse, new Position(1,1));
    }
    
    
}
