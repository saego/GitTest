package MyArrayList;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

/**
 *Created by Saego on 30.06.2017.
 */
public class MyArrayList<T> implements MyIterable<T>{
    private static final int ARRAY_CAPACITY = 10;
    private Object[]elements;
    private int index = 0;

    /**
     * Default constructor.
     */
    MyArrayList() {
        this.elements = new Object[ARRAY_CAPACITY];
    }

    /**
     * Custom constructor.
     * @param initialCapacity - initial size of arrayList.
     */
    MyArrayList(int initialCapacity){
    this.elements = new Object[initialCapacity];
    }

    /**
     * Add new element in the end of list.
     * @param element - new element.
     * @return - true.
     */
    public boolean add(T element){
        checkCapacity();
        this.elements[index++] = element;
        return true;
    }

    /**
     * Add new element on position.
     * @param position - where to add.
     * @param element - value of element.
     * @return - true - if there is such position.
     */
    public boolean add(int position, T element){
        boolean resultOperation = true;
        if (!ifPositionExist(position)){
            resultOperation = false;
        }
        else {
            checkCapacity();
            System.arraycopy(this.elements, position, this.elements, position + 1, index - position);
            this.elements[position] = element;
            index = index + 1;
        }
        return resultOperation;
    }

    /**
     * Get element from collection by position.
     * @param position - position for get.
     * @return - element.
     */
    public T get(int position) throws Exception {
        if(!ifPositionExist(position)){
            throw new Exception("There is no element in current position");
        }
        else {
            return (T) this.elements[position];
        }
    }

    /**
     * Remove element from list by position.
     * @param position - position in list to remove.
     * @return - true - if there is current position;
     */
    public boolean remove(int position) throws Exception {
        boolean resultOfOperation = true;
        if (!ifPositionExist(position)){
            resultOfOperation = false;
        }
        else {
            System.arraycopy(this.elements, position + 1, this.elements, position, index - position);
            Object[] tmpElements = new Object[this.elements.length - 1];
            System.arraycopy(this.elements, 0, tmpElements, 0, tmpElements.length);
            this.elements = tmpElements;
            index = index - 1;
        }
            return resultOfOperation;
    }

    /**
     * Check if array is not full. Increase array + ~50%.
     */
    private void checkCapacity(){
        if (index == this.elements.length){
            Object[] tempElements = new Object[(this.elements.length * 3) / 2 + 1];
            System.arraycopy(this.elements, 0, tempElements, 0, this.elements.length);
            this.elements = tempElements;
        }
    }

    /**
     * Check if there is current position in list.
     * @param position - position for check.
     * @return - is position.
     */
    @org.jetbrains.annotations.Contract(pure = true)
    private boolean ifPositionExist(int position){
        return position < index;
    }

    Object[] getAllElements(){
        Object[] tmpElements = new Object[size()];
        System.arraycopy(this.elements, 0, tmpElements, 0, size());
        return tmpElements;
    }

    int size(){
        return this.index;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new MyIterator(getAllElements());
    }

    private class MyIterator implements Iterator<T> {
        Object[] elements;
        int cursor = 0;

        MyIterator(Object[] elements) {
            this.elements = elements;
        }

        public boolean hasNext() {
            boolean operationResult = true;
            if (this.cursor == this.elements.length){
                operationResult = false;
            }
            return operationResult;
        }

        public T next() {
            return (T)elements[this.cursor++];
        }

        public void remove() {

        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<?> that = (MyArrayList<?>) o;

        if (index != that.index) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(elements);
        result = 31 * result + index;
        return result;
    }

    @Override
    public String toString() {
        return "Objects" +
                "elements=" + Arrays.toString(elements) +
                ", index=" + index;
    }
}
