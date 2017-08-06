package ofedorova;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 *Class for testing class ArrayRotate
 *@author Olga Fedorova
 *@since 18.07.2016
 *@version 1
 */
public class ArrayRotateTest {

    @Test
    public void whenRotateClockwiseSizeTwo(){
        final int[][] values = {{1,1,},
                                {2,2}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {{2,1},
                           {2,1}};

        array.rotateClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateClockwiseSizeThree(){
        final int[][] values = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {7,4,1},
                {8,5,2},
                {9,6,3}};

        array.rotateClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateClockwiseSizeFour(){
        final int[][] values = {
                {1,2,3,4},
                {4,5,6,7},
                {7,8,9,8},
                {8,9,0,1}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {8,7,4,1},
                {9,8,5,2},
                {0,9,6,3},
                {1,8,7,4}};

        array.rotateClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateClockwiseSizeFive(){
        final int[][] values = {
                {1,2,3,4,3},
                {4,5,6,7,0},
                {7,8,9,8,6},
                {8,9,0,1,5},
                {3,1,3,0,1}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {3,8,7,4,1},
                {1,9,8,5,2},
                {3,0,9,6,3},
                {0,1,8,7,4},
                {1,5,6,0,3}};

        array.rotateClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateClockwiseSizeSix(){
        final int[][] values = {
                {1,2,3,4,3,8},
                {4,5,6,7,0,3},
                {7,8,9,8,6,2},
                {8,9,0,1,5,1},
                {3,1,3,0,1,7},
                {4,5,6,7,0,3}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {4,3,8,7,4,1},
                {5,1,9,8,5,2},
                {6,3,0,9,6,3},
                {7,0,1,8,7,4},
                {0,1,5,6,0,3},
                {3,7,1,2,3,8}};

        array.rotateClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateAntiClockwiseSizeTwo(){
        final int[][] values = {
                {1,1,},
                {2,2}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {1,2},
                {1,2}};

        array.rotateAntiClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateAntiClockwiseSizeThree(){
        final int[][] values = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {3,6,9},
                {2,5,8},
                {1,4,7}};

        array.rotateAntiClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateAntiClockwiseSizeFour(){
        final int[][] values = {
                {1,2,3,4},
                {4,5,6,7},
                {7,8,9,8},
                {8,9,0,1}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {4,7,8,1},
                {3,6,9,0},
                {2,5,8,9},
                {1,4,7,8}};

        array.rotateAntiClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateAntiClockwiseSizeFive(){
        final int[][] values = {
                {1,2,3,4,3},
                {4,5,6,7,0},
                {7,8,9,8,6},
                {8,9,0,1,5},
                {3,1,3,0,1}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {3,0,6,5,1},
                {4,7,8,1,0},
                {3,6,9,0,3},
                {2,5,8,9,1},
                {1,4,7,8,3}};

        array.rotateAntiClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }

    @Test
    public void whenRotateAntiClockwiseSizeSix(){
        final int[][] values = {
                {1,2,3,4,3,8},
                {4,5,6,7,0,3},
                {7,8,9,8,6,2},
                {8,9,0,1,5,1},
                {3,1,3,0,1,7},
                {4,5,6,7,0,3}};
        final ArrayRotate array = new ArrayRotate(values);
        int[][] checked = {
                {8,3,2,1,7,3},
                {3,0,6,5,1,0},
                {4,7,8,1,0,7},
                {3,6,9,0,3,6},
                {2,5,8,9,1,5},
                {1,4,7,8,3,4}};

        array.rotateAntiClockwise();
        final int[][] result = array.getValues();
        assertThat(result, is(checked));
    }


}