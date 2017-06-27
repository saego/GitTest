import java.util.Iterator;

/**
 *Created by Saego on 23.06.2017.
 */
public interface IteratorOfIterator {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> iteratorIterator);
}
