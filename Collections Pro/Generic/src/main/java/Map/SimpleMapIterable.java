package Map;

/**
 * Created by Saego on 09.08.2017.
 */
public interface SimpleMapIterable<T, V> extends Iterable<T>{
    boolean put(T key, V value);
    V getValue(T key);
    boolean removeNode(T key);
}
