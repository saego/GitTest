package MyQueue;

import MyStack.MyStackIterable;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 *Created by Saego on 12.07.2017.
 */
public class MyQueue<E> implements MyStackIterable<E> {
    private Node<E> last;
    private Node<E> first;
    private int size = 0;

    /**
     * Put new element to queue.
     * @param element - value of new element.
     */
    public void push(E element) {
        Node<E> current = this.last;
        this.last = new Node<E>(current, element);
        if (this.size == 0){
            this.first = this.last;
        }
        size++;
    }

    /**
     * Get first element of queue and remove it.
     * @return - value of first element.
     */
    public E pop() {
        Node<E> getFirst = this.first;
        this.size = this.size - 1;
        this.first = this.first.next;
        return getFirst.valueOfObject;
    }

    /**
     * Get first element of queue.
     * @return - value of first element.
     */
    public E peek() {
        return this.first.valueOfObject;
    }

    /**
     * Size of queue.
     * @return - size.
     */
    public int count() {
        return size;
    }

    @NotNull
    public Iterator<E> iterator() {
        return new MyQueueIterator(this.first, this.size);
    }

    /**
     * Created by Saego on 12.07.2017.
     */
    private static class Node<E> {
        Node<E> next;
        E valueOfObject;

        Node(Node<E> next, E valueOfObject) {
            this.next = next;
            this.valueOfObject = valueOfObject;
        }
    }

    private class MyQueueIterator implements Iterator<E> {
        Node<E> element;
        int size;
        int iterator = 0;

        MyQueueIterator(Node<E> element, int size) {
            this.element = element;
            this.size = size;
        }

        public boolean hasNext() {
            return iterator < this.size;
        }

        public E next() {
            Node<E> current = this.element;
            this.element = this.element.next;
            iterator++;
            return current.valueOfObject;
        }

        public void remove() {

        }
    }
}
