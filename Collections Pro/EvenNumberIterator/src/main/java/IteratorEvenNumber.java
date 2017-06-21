import java.util.Iterator;
/**
 *Created by Saego on 21.06.2017.
 */
public class IteratorEvenNumber implements Iterator{
    private final int[] array;
    int iter = 0;

    public IteratorEvenNumber(int[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        if (array[iter] )
        return null;
    }

    public void remove() {

    }


}
