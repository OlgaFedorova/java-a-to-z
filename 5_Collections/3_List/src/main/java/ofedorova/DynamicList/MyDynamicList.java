package ofedorova.DynamicList;

import ofedorova.SimpleContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Olga on 02.01.2017.
 */
public class MyDynamicList<T> implements SimpleContainer<T> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit.
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * The array buffer into which the elements of the MyDynamicList are stored.
     * The capacity of the MyDynamicList is the length of this array buffer. Any
     * empty MyDynamicList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    private Object[] elementData;

    /**
     * The size of the MyDynamicList (the number of elements it contains).
     */
    private int size;

    /**
     * Constructs an empty list with the specified initial capacity.
     * @param initialCapacity the initial capacity of the list.
     * @throws IllegalArgumentException if the specified initial capacity  is negative.
     */
    public MyDynamicList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = MyDynamicList.EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    /**
     * Constructs an empty list with an initial capacity of value "DEFAULT_CAPACITY".
     */
    public MyDynamicList() {
        this(MyDynamicList.DEFAULT_CAPACITY);
    }


    @Override
    public void add(T element) {

    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T get(int index) {
        this.rangeCheck(index);
        return this.elementData(index);
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public T set(int index, T element) {
        this.rangeCheck(index);

        T oldValue = this.elementData(index);
        this.elementData[index] = element;
        return oldValue;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean contains(T element) {
        return this.indexOf(element) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    private int indexOf(T element) {
        int index = -1;
            for (int i = 0; i < this.size; i++) {
                if ((element == null && this.elementData[i] == null)||
                        (element != null && element.equals(this.elementData[i]))) {
                    index = i;
                    break;
                }
            }
        return index;
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * @return an array containing all of the elements in this list in
     *         proper sequence
     */
    public Object[] toArray() {
        return Arrays.copyOf(this.elementData, this.size);
    }

    /**
     * Method returns element in the position of the index.
     * @param index index for access data.
     * @return element in the position of the index.
     */
    private T elementData(int index) {
        return (T) this.elementData[index];
    }

    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void rangeCheck(int index) {
        if (index >= this.size)
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     */
    private String outOfBoundsMsg(int index) {
        return String.format("Index: %s, Size: %s", index, this.size);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        String[] arrays = new String[7];
        arrays[3] = "4";
        arrays[4] = "5";
        arrays[5] = "6";
        arrays[6] = "7";

        System.out.println(Arrays.toString(list.toArray(arrays)));
    }
}
