package ofedorova;

import java.util.Arrays;
import ofedorova.chessmen.Bishop;
import ofedorova.chessmen.Chessman;
import ofedorova.chessmen.Horse;
import ofedorova.chessmen.King;
import ofedorova.chessmen.Pawn;
import ofedorova.chessmen.Queen;
import ofedorova.chessmen.Rook;

/**
 * The class implements board for chess.
 * @author Olga Fedorova
 * @since 10.09.2016
 * @version 1
 */
public class ChessBoard {
    
    private final Cell[][] board = new Cell[8][8];
    {
        for(int y = 0; y < this.board.length; y++){
            for(int x = 0; x < this.board[y].length; x++){
                this.board[y][x] = new Cell(new Position(x, y));
            }
        }
    }

    /*
    * Initialize start values.
    */
    public void init(){
        this.placeChessmen(true);
        this.placeChessmen(false);
    }
    
    /*
    * The method puts chessmen on the chessboard.
    */
    public void placeChessmen(boolean  isWhite){
        int firstLine = 0;
        int secondLine = 1;
        
        if(!isWhite){
            firstLine = 7;
            secondLine = 6;
        }
        
        this.addChessman(new Rook(new Position(firstLine, 0), isWhite));
        this.addChessman(new Horse(new Position(firstLine, 1), isWhite));
        this.addChessman(new Bishop(new Position(firstLine, 2), isWhite));
        this.addChessman(new Queen(new Position(firstLine, 3), isWhite));
        this.addChessman(new King(new Position(firstLine, 4), isWhite));
        this.addChessman(new Bishop(new Position(firstLine, 5), isWhite));
        this.addChessman(new Horse(new Position(firstLine, 6), isWhite));
        this.addChessman(new Rook(new Position(firstLine, 7), isWhite));
       
        for(int index = 0; index < board[secondLine].length; index++){
            this.addChessman(new Pawn(new Position(secondLine, index), isWhite));
        }
    }

    /*
    * The method add new chessman on the chessboard.
    * @param chessman
    */
    public void addChessman(Chessman chessman){
        this.board[chessman.getPosition().getY()][chessman.getPosition().getX()].setChessman(chessman);
    }
    
    /*
    * The method removes chessman from chessboard.
    * @param chessman
    */
    private void removeChessmen(Chessman chessman){
        if(chessman != null){
            this.board[chessman.getPosition().getY()][chessman.getPosition().getX()].setChessman(null);
        }
    }
    
    /*
    * The method checks one step of moving
    * @return true or false
    * @throws IllegalPositionError, if there are other chessmen on this path.
    */
    public boolean checkStep(Chessman chessman, Position newPosition, Position currentPosition) throws IllegalPositionError{
        if(this.board[currentPosition.getY()][currentPosition.getX()].getChessman() != null 
                && !(currentPosition.getY() == newPosition.getY() 
                     && currentPosition.getX() == newPosition.getX()
                     && chessman.isWhite() != this.board[currentPosition.getY()][currentPosition.getX()].getChessman().isWhite())){
            throw new IllegalPositionError("There are other chessmen on this path.");                    
        }
        return true;
    }
    
    /*
    * The method checks new position on correct: 
    * in borders of board, new position isn't equals current position, not null.
    * @param board, new position
    * @return true or false
    * @throws IllegalPositionError, if new position is incorrect.
    */
    public boolean checkPositionOnCorrect(Chessman chessman, Position newPosition) throws IllegalPositionError {
        
        if(newPosition == null){
            throw new IllegalPositionError("The new position is null");
        }

        if(newPosition.getY() > this.board.length - 1
                || newPosition.getY() < 0){
            throw new IllegalPositionError("The new position is out the boundaries of the Y.");
        }
        
        if(newPosition.getX() > this.board[newPosition.getY()].length - 1
                || newPosition.getX() < 0){
            throw new IllegalPositionError("The new position is out the boundaries of the X.");
        }
             
        
        if(chessman.getPosition() != null && chessman.getPosition().equals(newPosition)){
            throw new IllegalPositionError("The new position is equals current position.");
        }
        
        return true;
    }
    
    /*
    * The method moves chessman on new position.
    * @param chessman, new position.
    * @throws IllegalPositionError, if new position is incorrect.
    */
    public void move (Chessman chessman, Position newPposition) throws IllegalPositionError{
        this.checkPositionOnCorrect(chessman, newPposition);
        for(Position nextPosition : chessman.changePosition(newPposition)){
            this.checkStep(chessman, newPposition, nextPosition);
        }
        this.removeChessmen(chessman);
        chessman.setPosition(newPposition);
        this.addChessman(chessman);            
    }
}
