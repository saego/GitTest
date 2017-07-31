package Cycle;

import MyLinkedList.MyLinkedList;

/**
 * Created by Saego on 26.07.2017.
 */
class Cycle<E> {
    /**
     * Check if list elements has loop references.
     * @param first - first element of list.
     * @return - true if there is cycle.
     */
    boolean loop(SimpleNode<E> first){
        boolean result = false;
        SimpleNode<E> current = first;
        MyLinkedList<SimpleNode<E>> list = new MyLinkedList<SimpleNode<E>>();
        while (current.next != null){
            for (SimpleNode<E> node:
                 list) {
                if (current.next.equals(node)){
                    result = true;
                    break;
                }
            }
            if (result) break;
            else list.add(current);
            current = current.next;
        }
        return result;
    }
}
