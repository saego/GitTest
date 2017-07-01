package MyLinkedList;

import MyArrayList.MyIterable;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;

/**
 Created by Saego on 02.07.2017.
 */
public class MyLinkedList<T> implements MyIterable<T>{

    public Node<T> first;
    private Node<T> second;
    private int size;

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
}
