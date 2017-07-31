package Set;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 31.07.2017.
 */
public class SimpleArraySet<E> implements MyIterable<E>{
    private static final int ARRAY_CAPACITY = 10;
    private Object[]elements;
    private int index = 0;

    SimpleArraySet() {
        this.elements = new Object[ARRAY_CAPACITY];
    }

    public boolean add(E element) {
        boolean result = false;
        if (!checkDuplicate(element)){
            addElement(element);
            result = true;
        }
        return result;
    }

    public int size() {
        return this.elements.length;
    }

    private void addElement(E element){
            checkCapacity();
            this.elements[index++] = element;
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

    private Object[] getAllElements(){
        Object[] tmpElements = new Object[size()];
        System.arraycopy(this.elements, 0, tmpElements, 0, size());
        return tmpElements;
    }

    @NotNull
    public Iterator iterator() {
        return new SetArrayIterator(getAllElements());
    }


    public class SetArrayIterator implements Iterator<E> {
        Object[] elements;
        int cursor = 0;

        SetArrayIterator(Object[] elements) {
            this.elements = elements;
        }

        public boolean hasNext() {
            boolean operationResult = true;
            if (this.cursor == this.elements.length){
                operationResult = false;
            }
            return operationResult;
        }

        public E next() {
            return (E)elements[this.cursor++];
        }

        public void remove() {

        }
    }
}
