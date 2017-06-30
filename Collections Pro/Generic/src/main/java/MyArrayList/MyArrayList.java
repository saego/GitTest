package MyArrayList;

/**
 *Created by Saego on 30.06.2017.
 */
public class MyArrayList<T> implements MyIterator<T>{
    private static final int ARRAY_CAPACITY = 10;
    private Object[]elements;
    private int index = 0;

    /**
     * Default constructor.
     */
    public MyArrayList() {
        this.elements = new Object[ARRAY_CAPACITY];
    }

    /**
     * Custom constructor.
     * @param initialCapacity - initial size of arrayList.
     */
    public MyArrayList(int initialCapacity){
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
     * @return - true.
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
     * Check if array is not full. Increase array + ~50%.
     */
    private void checkCapacity(){
        if (index == this.elements.length){
            Object[] tempElements = new Object[(this.elements.length * 3) / 2 + 1];
            System.arraycopy(this.elements, 0, tempElements, 0, this.elements.length);
            this.elements = tempElements;
        }
    }
    private boolean ifPositionExist(int position){
        return position < index;
    }

    public boolean set(int position, T element){
        boolean resultOperation = true;
        if (!ifPositionExist(position)){
            resultOperation = false;
        }
        else {
            this.elements[position] = element;
        }
        return resultOperation;
    }

}
