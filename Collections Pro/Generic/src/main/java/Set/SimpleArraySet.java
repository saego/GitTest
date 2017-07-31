package Set;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 31.07.2017.
 */
public class SimpleArraySet<E> implements MyIterable{
    private static final int ARRAY_CAPACITY = 10;
    private Object[]elements;
    private int index = 0;

    public boolean add(Object element) {
        return false;
    }

    public int size() {
        return this.elements.length;
    }

    private void addElement(E element){
        if (!checkDuplicate(element)) {
            checkCapacity();
            this.elements[index++] = element;
        }
    }

    private boolean checkDuplicate(E element) {
        boolean result = false;
        for (Object val:
             this.elements) {
            if (element.equals(val)){
                result = true;
                break;
            }
        }
        return  result;
    }

    private void checkCapacity() {
        if (index == this.elements.length){
            Object[] tempElements = new Object[(this.elements.length * 3) / 2 + 1];
            System.arraycopy(this.elements, 0, tempElements, 0, this.elements.length);
            this.elements = tempElements;
        }
    }

    @NotNull
    public Iterator iterator() {
        return null;
    }
}
