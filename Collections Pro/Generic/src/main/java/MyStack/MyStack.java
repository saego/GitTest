package MyStack;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 *Created by Saego on 04.07.2017.
 */
public class MyStack<K> implements MyStackIterable<K>{
    private Node<K> tail;
    int size = 0;
    public void push(K element) {
        Node<K> last = this.tail;
        this.tail = new Node<K>(last, element);

    }

    public K pop() {
        return null;
    }

    public K peek() {
        return null;
    }

    public int count() {
        return 0;
    }

    @NotNull
    public Iterator<K> iterator() {
        return null;
    }

    /**
     *Created by Saego on 04.07.2017.
     */
    public static class Node<K> {
        private Node<K> prev;
        private K valueOfObgect;

        public Node(Node<K> prev, K valueOfObject) {
            this.prev = prev;
            this.valueOfObgect = valueOfObject;
        }
    }
}
