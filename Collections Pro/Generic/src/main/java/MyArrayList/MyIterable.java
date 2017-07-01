package MyArrayList;

/**
 Created by Saego on 01.07.2017.
 */
public interface MyIterable<T> extends Iterable<T>{
    boolean add(T element);
    boolean add(int position, T element);
    T get(int position) throws Exception;
    boolean remove(int position) throws Exception;
}
