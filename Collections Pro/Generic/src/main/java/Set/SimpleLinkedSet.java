package Set;


import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 28.07.2017.
 */
public class SimpleLinkedSet<E> implements MyIterable<E> {
    Node<E> next;
    Node<E> prev;
    int size;
    public boolean add(E element) {
        return false;
    }

    public int size() {
        return 0;
    }

    @NotNull
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Created by Saego on 28.07.2017.
     */
    public static class Node<E> {
        private Node<E> next;
        private Node<E> prev;
        private E value;

        public Node(Node<E> next, Node<E> prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
