package MyLinkedList;

import MyArrayList.MyIterable;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 Created by Saego on 02.07.2017.
 */
public class MyLinkedList<T> implements MyIterable<T>{

    public Node<T> first;
    private Node<T> last;
    private int size;

    public MyLinkedList() {
    }

    public boolean add(T element) {
        return false;
    }

    public boolean add(int position, T element) {
        return false;
    }

    public T get(int position) throws Exception {
        return null;
    }

    public boolean remove(int position) throws Exception {
        return false;
    }

    @NotNull
    public Iterator<T> iterator() {
        return null;
    }

    /**
     Created by Saego on 02.07.2017.
     */
    private static class Node<T> {
        private Node<T> prev;
        private T valueOfObject;
        private Node<T> next;

        public Node(Node<T> prev, T valueOfObject, Node<T> next) {
            this.prev = prev;
            this.valueOfObject = valueOfObject;
            this.next = next;
        }
    }
}
