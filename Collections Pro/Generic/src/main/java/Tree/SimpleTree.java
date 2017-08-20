package Tree;

/**
 * Created by Saego on 19.08.2017.
 */
public interface SimpleTree<T extends Comparable<T>> extends Iterable<T> {
    boolean add(T element);
}
