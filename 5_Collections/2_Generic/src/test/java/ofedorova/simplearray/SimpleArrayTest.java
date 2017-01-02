package ofedorova.simplearray;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing class "SimpleArray".
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 21.12.2016
 */
public class SimpleArrayTest {

    /**
     * Test adding new element in container.
     */
    @Test
    public void whenAddNewElement() {
        final SimpleArray<Integer> list = new SimpleArray<>(2);
        final boolean expect = true;
        final Object[] expectArrays = new Integer[]{5, null};
        final boolean actual = list.add(5);
        final Object[] actualArrays = list.toArray();

        assertTrue(actual == expect && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test adding new element in container and enlarges capacity of container.
     */
    @Test
    public void whenAddNewElementAndEnlargeCapacityOfContainer() {
        final SimpleArray<Integer> list = new SimpleArray<>(2);
        final boolean expect = true;
        final Object[] expectArrays = new Integer[]{5, 6, 7, null};
        list.add(5);
        list.add(6);
        final boolean actual = list.add(7);
        final Object[] actualArrays = list.toArray();

        assertTrue(actual == expect && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when update is true.
     */
    @Test
    public void whenUpdateTrue() {
        final SimpleArray<Integer> list = new SimpleArray<>(2);
        final boolean expect = true;
        final Object[] expectArrays = new Integer[]{5, 7};
        list.add(5);
        list.add(6);
        final boolean actual = list.update(1, 7);
        final Object[] actualArrays = list.toArray();

        assertTrue(actual == expect && Arrays.equals(expectArrays, actualArrays));

    }

    /**
     * Test when update is false.
     */
    @Test
    public void whenUpdateFalse() {
        final SimpleArray<Integer> list = new SimpleArray<>(2);
        final boolean expect = false;
        final Object[] expectArrays = new Integer[]{5, 6};
        list.add(5);
        list.add(6);
        final boolean actual = list.update(2, 7);
        final Object[] actualArrays = list.toArray();

        assertTrue(actual == expect && Arrays.equals(expectArrays, actualArrays));

    }

    /**
     * Test when delete by element in start of container is true.
     */
    @Test
    public void whenDeleteByElementInStartContainer() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final boolean expect = true;
        final Object[] expectArrays = new Integer[]{6, 7, null};
        list.add(5);
        list.add(6);
        list.add(7);
        final boolean actual = list.delete(Integer.valueOf(5));
        final Object[] actualArrays = list.toArray();

        assertTrue(actual == expect && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when delete by element in middle of container is true.
     */
    @Test
    public void whenDeleteByElementInMiddleContainer() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final boolean expect = true;
        final Object[] expectArrays = new Integer[]{5, 7, null};
        list.add(5);
        list.add(6);
        list.add(7);
        final boolean actual = list.delete(Integer.valueOf(6));
        final Object[] actualArrays = list.toArray();

        assertTrue(actual == expect && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when delete by element in end of container is true.
     */
    @Test
    public void whenDeleteByElementInEndContainer() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final boolean expect = true;
        final Object[] expectArrays = new Integer[]{5, 6, null};
        list.add(5);
        list.add(6);
        list.add(7);
        final boolean actual = list.delete(Integer.valueOf(7));
        final Object[] actualArrays = list.toArray();

        assertTrue(actual == expect && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when delete by element is true and add new element.
     */
    @Test
    public void whenDeleteByElementAndAddNewElement() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final boolean expectDelete = true;
        final boolean expectAdd = true;
        final Object[] expectArrays = new Integer[]{5, 7, 8};
        list.add(5);
        list.add(6);
        list.add(7);
        final boolean actualDelete = list.delete(Integer.valueOf(6));
        final boolean actualAdd = list.add(8);
        final Object[] actualArrays = list.toArray();

        assertTrue(actualDelete == expectDelete && actualAdd == expectAdd && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when delete by element is false.
     */
    @Test
    public void whenDeleteByElementFalse() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final boolean expectDelete = false;
        final Object[] expectArrays = new Integer[]{5, 6, 7};
        list.add(5);
        list.add(6);
        list.add(7);
        final boolean actualDelete = list.delete(Integer.valueOf(8));
        final Object[] actualArrays = list.toArray();

        assertTrue(actualDelete == expectDelete && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when delete by value element from start container.
     */
    @Test
    public void whenDeleteByElementFromStartContainer() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final Integer expectDelete = 5;
        final Object[] expectArrays = new Integer[]{6, 7, null};
        list.add(5);
        list.add(6);
        list.add(7);
        final Integer actualDelete = list.delete(0);
        final Object[] actualArrays = list.toArray();

        assertTrue(expectDelete.equals(actualDelete) && Arrays.equals(expectArrays, actualArrays));

    }

    /**
     * Test when delete by value element from middle container.
     */
    @Test
    public void whenDeleteByElementFromMiddleContainer() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final Integer expectDelete = 6;
        final Object[] expectArrays = new Integer[]{5, 7, null};
        list.add(5);
        list.add(6);
        list.add(7);
        final Integer actualDelete = list.delete(1);
        final Object[] actualArrays = list.toArray();

        assertTrue(expectDelete.equals(actualDelete) && Arrays.equals(expectArrays, actualArrays));

    }

    /**
     * Test when delete by value element from end container.
     */
    @Test
    public void whenDeleteByElementFromEndContainer() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final Integer expectDelete = 7;
        final Object[] expectArrays = new Integer[]{5, 6, null};
        list.add(5);
        list.add(6);
        list.add(7);
        final Integer actualDelete = list.delete(2);
        final Object[] actualArrays = list.toArray();

        assertTrue(expectDelete.equals(actualDelete) && Arrays.equals(expectArrays, actualArrays));

    }

    /**
     * Test when delete by value element from middle container and add new element.
     */
    @Test
    public void whenDeleteByElementFromContainerAndAddNewElement() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final Integer expectDelete = 6;
        final boolean expectAdd = true;
        final Object[] expectArrays = new Integer[]{5, 7, 8};
        list.add(5);
        list.add(6);
        list.add(7);
        final Integer actualDelete = list.delete(1);
        final boolean actualAdd = list.add(8);
        final Object[] actualArrays = list.toArray();

        assertTrue(expectDelete.equals(actualDelete) && expectAdd == actualAdd && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when delete by value element from middle container and add new element.
     */
    @Test
    public void whenDeleteByElementFromContainerAndReturnNull() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final Integer expectDelete = null;
        final Object[] expectArrays = new Integer[]{5, 6, 7};
        list.add(5);
        list.add(6);
        list.add(7);
        final Integer actualDelete = list.delete(4);
        final Object[] actualArrays = list.toArray();

        assertTrue(expectDelete == null && actualDelete == null && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when element getting by index is not null.
     */
    @Test
    public void whenGetNotNull() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final Integer expectGet = 6;
        final Object[] expectArrays = new Integer[]{5, 6, 7};
        list.add(5);
        list.add(6);
        list.add(7);
        final Integer actualGet = list.get(1);
        final Object[] actualArrays = list.toArray();

        assertTrue(expectGet.equals(actualGet) && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test when element getting by index is null.
     */
    @Test
    public void whenGetNull() {
        final SimpleArray<Integer> list = new SimpleArray<>(3);
        final Integer expectGet = null;
        final Object[] expectArrays = new Integer[]{5, 6, 7};
        list.add(5);
        list.add(6);
        list.add(7);
        final Integer actualGet = list.get(3);
        final Object[] actualArrays = list.toArray();

        assertTrue(expectGet == null && actualGet == null && Arrays.equals(expectArrays, actualArrays));
    }

    /**
     * Test create new instance with reflection.
     */
    @Test
    public void whenGetNewInstance() {
        final SimpleArray<String> list = new Stack(5);
        final String expected = "";
        final String instance = list.getNewInstance();

        assertThat(instance, is(expected));
    }

}