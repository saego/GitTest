package MyStack;

/**
 *Created by Saego on 04.07.2017.
 */
public interface MyStackIterable<K> extends Iterable<K>{
    public void push(K element);
    public K pop();
    public K peek();
    public int count();
}
