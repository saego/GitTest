package MyQueue;

import MyStack.MyStackIterable;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 *Created by Saego on 12.07.2017.
 */
public class MyQueue<E> implements MyStackIterable<E> {
    private Node<E> head;
    private int size = 0;

    /**
     * Put new element to queue.
     * @param element - value of new element.
     */
    public void push(E element) {
        Node<E> current = this.head;
        this.head = new Node<E>(current, element);
        size++;
    }

    public E pop() {
        return null;
    }

    public E peek() {
        return null;
    }

    public int count() {
        return 0;
    }

    @NotNull
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Created by Saego on 12.07.2017.
     */
    private static class Node<E> {
        Node<E> next;
        E valueOfObject;

        public Node(Node<E> next, E valueOfObject) {
            this.next = next;
            this.valueOfObject = valueOfObject;
        }
    }
}
