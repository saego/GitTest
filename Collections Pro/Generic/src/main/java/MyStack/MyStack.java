package MyStack;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 *Created by Saego on 04.07.2017.
 */
public class MyStack<K> implements MyStackIterable<K>{
    private Node<K> tail;
    private int size = 0;

    /**
     * Put element on the top of stack.
     * @param element - value of new element.
     */
    public void push(K element) {
        Node<K> last = this.tail;
        this.tail = new Node<K>(last, element);
        this.size++;
    }

    /**
     * Take element from the top.
     * @return - value of element.
     */
    public K pop() {
        return this.tail.valueOfObject;
    }

    /**
     * Take element from the top and remove it.
     * @return - value of element.
     */
    public K peek() {
        Node<K> currentTopElement = this.tail;
        this.tail = this.tail.prev;
        this.size = this.size - 1;
        return currentTopElement.valueOfObject;
    }

    /**
     * Size of stack.
     * @return - count ofelements.
     */
    public int count() {
        return this.size;
    }

    @NotNull
    public Iterator<K> iterator() {
        return new  MyStackIterator(this.tail, this.size);
    }

    /**
     *Created by Saego on 04.07.2017.
     */
    static class Node<K> {
        private Node<K> prev;
        private K valueOfObject;

        Node(Node<K> prev, K valueOfObject) {
            this.prev = prev;
            this.valueOfObject = valueOfObject;
        }
    }

    private class MyStackIterator implements Iterator<K> {
        Node<K> tail;
        int size;
        int position = size;

        MyStackIterator(Node<K> tail, int size) {
            this.tail = tail;
            this.size = size;
        }

        public boolean hasNext() {
            return (this.position < this.size) && (this.position >= 0);
        }

        public K next() {
            Node<K> currentTopElement = this.tail;
            this.tail = this.tail.prev;
            this.position = this.position - 1;
            return currentTopElement.valueOfObject;
        }

        public void remove() {

        }
    }
}
