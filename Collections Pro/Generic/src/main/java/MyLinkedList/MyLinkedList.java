package MyLinkedList;

import MyArrayList.MyIterable;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 Created by Saego on 02.07.2017.
 */
public class MyLinkedList<T> implements MyIterable<T>{

    private Node<T> first;
    private Node<T> last;
    private int size;

    MyLinkedList() {
    }

    public boolean add(T element) {
        Node<T> lastElement = this.last;
        Node<T> currentElement = new Node<T>(lastElement, element,null);
        this.last = currentElement;
        if (lastElement == null){
            this.first = currentElement;
        }
        else {
            lastElement.next = currentElement;
        }
        size++;
        return true;
    }

    public boolean add(int position, T element) {
        Node<T> elementPosition = getNodeByPosition(position);
        Node<T> elementPrevPosition = elementPosition.prev;
        Node<T> currentElement = new Node<T>(elementPrevPosition, element, elementPosition);
        elementPosition.prev = currentElement;
        elementPrevPosition.next = currentElement;
        size++;
        return true;
    }

    public T get(int position) throws Exception {
        if (!checkPositionValid(position)){
            throw new NullPointerException("No such position");
        }
        else {
            return getNodeByPosition(position).valueOfObject;
        }
    }

    private Node<T> getNodeByPosition(int position){
        Node<T> element = this.first;
        for (int i = 0; i < position; i++){
            element = element.next;
        }
        return element;
    }

    private boolean checkPositionValid(int position){
        return position < size();
    }

    public boolean remove(int position) throws Exception {
        return false;
    }

    int size(){
        return this.size;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new MyLinkIterator(this.first, this.size);
    }

    /**
     Created by Saego on 02.07.2017.
     */
    private static class Node<T> {
        private Node<T> prev;
        private T valueOfObject;
        private Node<T> next;

        Node(Node<T> prev, T valueOfObject, Node<T> next) {
            this.prev = prev;
            this.valueOfObject = valueOfObject;
            this.next = next;
        }
    }

    private class MyLinkIterator implements Iterator<T> {
        Node<T> element;
        Node<T> elementToGet;
        int size;
        int index = 0;
        MyLinkIterator(Node<T> first, int size) {
            this.size = size;
            this.element = first;
        }

        public boolean hasNext() {
            return this.index < this.size;
        }

        public T next() {
            this.elementToGet = this.element;
            this.element = this.element.next;
            this.index++;
            return this.elementToGet.valueOfObject;
        }

        public void remove() {

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyLinkedList<?> that = (MyLinkedList<?>) o;

        return size == that.size && (first != null ? first.equals(that.first) : that.first == null) && (last != null ? last.equals(that.last) : that.last == null);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "First&Last of list{" +
                "first=" + first.valueOfObject +
                ", last=" + last.valueOfObject +
                ", size=" + size +
                '}';
    }
}
