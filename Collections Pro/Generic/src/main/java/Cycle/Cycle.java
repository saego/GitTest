package Cycle;

/**
 * Created by Saego on 26.07.2017.
 */
public class Cycle<E> {
    public boolean loop(SimpleNode<E> first){
        while (first != null){
            SimpleNode<E> next = first.next;
            if (first.)
            first = next;
        }
        return false;
    }
}
