package Set;

/**
 * Created by Saego on 28.07.2017.
 */
public interface MyIterable<E> extends Iterable<E>{
    boolean add(E element);
    int size();
}
