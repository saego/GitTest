import java.util.Iterator;

/**
 *Created by Saego on 20.06.2017.
 */
public class IteratorSingleArray implements Iterator{
    private final int[] array;
    private int index = 0;

    public IteratorSingleArray(int[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return array.length > index;
    }

    public Object next() {
        return array[index++];
    }
}
