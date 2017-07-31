package Cycle;

/**
 * Created by Saego on 26.07.2017.
 */
class Cycle<E> {
    boolean loop(SimpleNode<E> first){
        boolean result = false;
        SimpleNode<E> next = first.next;
        while (next.next != null){
            if (first.hashCode() == next.next.hashCode()){
                result = true;
                break;
            }

            next = next.next;
        }
        return result;
    }
}
