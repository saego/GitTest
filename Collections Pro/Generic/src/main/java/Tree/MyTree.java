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
            while (this.leaf != null) {
                if (this.leaf.getValueOfLeaf().compareTo((T) element) <= 0) {
                    if (this.leaf.getRightBrunch() == null){
                        this.leaf.rightBrunch = new Node<>((T)element,null, null, this.leaf);
                        break;
                    }
                    else {
                        this.leaf = this.leaf.getRightBrunch();
                    }
                } else if (this.leaf.getValueOfLeaf().compareTo((T) element) > 0) {
                    if (this.leaf.getLeftBrunch() == null){
                        this.leaf.leftBrunch = new Node<>((T)element,null, null, this.leaf);
                        break;
                    }
                    else {
                        this.leaf = this.leaf.getLeftBrunch();
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Comparable getLeaf(Comparable element) throws Exception {
        if (this.root == null){
            throw new NullPointerException("Root is null!");
        }
        else {
            this.leaf = this.root;
            while ((this.leaf != null) & (this.leaf.getValueOfLeaf().compareTo((T)element) != 0)){
                if (this.leaf.getValueOfLeaf().compareTo((T)element) > 0){
                    this.leaf = this.leaf.getLeftBrunch();
                }
                else {
                    this.leaf = this.leaf.getRightBrunch();
                }
            }
            if (this.leaf == null){
                throw new NullPointerException("Element not found!");
            }
            else {
                return this.leaf.getValueOfLeaf();
            }
        }
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
        Node<TT> parent;

        Node(TT value, Node<TT> leftBrunch, Node<TT> rightBrunch, Node<TT> parent) {
            this.value = value;
            this.leftBrunch = leftBrunch;
            this.rightBrunch = rightBrunch;
            this.parent = parent;
        }

        TT getValueOfLeaf() {
            return value;
        }

        Node<TT> getLeftBrunch() {
            return leftBrunch;
        }

        Node<TT> getRightBrunch() {
            return rightBrunch;
        }

        public Node<TT> getParent() {
            return parent;
        }
    }

}
