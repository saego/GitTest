package Cycle;

/**
 * Created by Saego on 26.07.2017.
 */
public class SimpleNode<E> {
    public SimpleNode<E> next;
    private E value;

    SimpleNode(SimpleNode<E> next, E value) {
        this.next = next;
        this.value = value;
    }
}
