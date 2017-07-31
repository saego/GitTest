package Set;


import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 28.07.2017.
 */
public class SimpleLinkedSet<E> implements MyIterable<E> {
    private Node<E> last;
    private Node<E> first;
    private int size;
    public boolean add(E element) {

        return true;
    }

    private void addElement(E element){
        Node<E> lastElement = this.last;
        Node<E> currentElement = new Node<E>(lastElement, element,null);
        this.last = currentElement;
        if (lastElement == null){
            this.first = currentElement;
        }
        else {
            lastElement.next = currentElement;
        }
        size++;
    }

    private boolean checkIfDuble(E element){
        Node<E> node = this.first;
        boolean result = false;
        for (int i = 0; i != size; i++){
            if (node.value.equals(element)){
                result = true;
                break;
            }
            node = node.next;
        }
        return result;
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
    static class Node<E> {
        private Node<E> prev;
        private E value;
        private Node<E> next;

        Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
