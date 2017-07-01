package MyLinkedList;

/**
 Created by Saego on 02.07.2017.
 */
public class Node<T> {
    private Node<T> prev;
    private T valueOfObject;
    private Node<T> next;

    public Node(Node<T> prev, T valueOfObject, Node<T> next) {
        this.prev = prev;
        this.valueOfObject = valueOfObject;
        this.next = next;
    }
}
