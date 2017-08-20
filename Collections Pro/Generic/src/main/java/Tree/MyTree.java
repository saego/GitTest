package Tree;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Created by Saego on 19.08.2017.
 */
public class MyTree<T extends Comparable<T>> implements SimpleTree {
    private Node<T> root = null;
    private Node<T> leaf;



    @Override
    public boolean add(Comparable element) {
        boolean result = false;
        if (this.root ==null){
            this.root = new Node<>((T) element, null, null, null);
            result = true;
        }
        else {
            this.leaf = this.root;
            boolean flagR = false;
            while (this.leaf != null){
                if (this.leaf.value.compareTo((T) element) > 0){
                    this.leaf = this.leaf.getLeftBrunch();
                    flagR = false;
                }
                else  if (this.leaf.value.compareTo((T) element) < 0){
                    this.leaf = this.leaf.getRightBrunch();
                    flagR = true;
                }
            }
            if (flagR) {
                this.leaf.prev.rightBrunch = new Node<>((T) element, null, null, this.leaf.prev);
            }
            else {
                this.leaf.prev.leftBrunch = new Node<>((T) element, null, null, this.leaf.prev);
            }
        }
        return result;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return null;
    }

    private class Node<TT> {
        TT value;
        Node<TT> leftBrunch;
        Node<TT> rightBrunch;
        Node<TT> prev;

        Node(TT value, Node<TT> leftBrunch, Node<TT> rightBrunch, Node<TT> prev) {
            this.value = value;
            this.leftBrunch = leftBrunch;
            this.rightBrunch = rightBrunch;
            this.prev = prev;
        }

        public TT getValue() {
            return value;
        }

        public Node<TT> getLeftBrunch() {
            return leftBrunch;
        }

        public Node<TT> getRightBrunch() {
            return rightBrunch;
        }
    }
}
