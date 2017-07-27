package Cycle;

/**
 * Created by Saego on 26.07.2017.
 */
public class Cycle<E> {
    public boolean loop(SimpleNode<E> first){
        boolean result = false;
        while (first != null){
            SimpleNode<E> next = first.next;
            if (first.value.hashCode() == next.value.hashCode()){
                result = true;
                break;
            }
            first = next;
        }
        return result;
    }
}
