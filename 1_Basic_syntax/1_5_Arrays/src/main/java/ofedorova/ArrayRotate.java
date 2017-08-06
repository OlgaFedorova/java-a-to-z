package ofedorova;

/**
 *Class for rotate the array on 90 degrees
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
public class ArrayRotate{
    /**
     *The array for rotate
     */
    private final int[][] values;

    public ArrayRotate(int[][] values){
        this.values = values;
    }

    public int[][] getValues(){
        return this.values;
    }

    /**
     *Rotate the array by 90 degrees clockwise
     */
    public void rotateClockwise(){
        for (int indexY = 0; indexY < this.values.length - indexY - 1; indexY++){
            for(int indexX = indexY; indexX < this.values.length - indexY - 1; indexX++){
                swapClockwise(indexX, indexY);
            }
        }
    }

    /**
     *Swap elements of variable values
     *@param x,y - coordinates of element, which rotate by 90 degrees clockwise
     */
    private void swapClockwise(int x, int y){
        int temp = this.values[y][x];
        this.values[y][x] = this.values[this.values.length - x - 1][y];
        this.values[this.values.length - x - 1][y] = this.values[this.values.length - y - 1][this.values.length - x - 1];
        this.values[this.values.length - y - 1][this.values.length - x - 1] = this.values[x][this.values.length - y - 1];
        this.values[x][this.values.length - y - 1] = temp;
    }

    /**
     *Rotate the array by 90 degrees anti-clockwise
     */
    public void rotateAntiClockwise(){
        for (int indexY = 0; indexY < this.values.length - indexY - 1; indexY++){
            for(int indexX = indexY; indexX < this.values.length - indexY - 1; indexX++){
                swapAntiClockwise(indexX, indexY);
            }
        }
    }

    /**
     *Swap elements of variable values
     *@param x,y - coordinates of element, which rotate by 90 degrees anti-clockwise
     */
    private void swapAntiClockwise(int x, int y){
        int temp = this.values[y][x];
        this.values[y][x] = this.values[x][this.values.length - y - 1];
        this.values[x][this.values.length - y - 1] = this.values[this.values.length - y - 1][this.values.length - x - 1];
        this.values[this.values.length - y - 1][this.values.length - x - 1] = this.values[this.values.length - x - 1][y];
        this.values[this.values.length - x - 1][y] = temp;
    }

}