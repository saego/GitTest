import java.util.Iterator;
/**
 *Created by Saego on 21.06.2017.
 */
public class IteratorEvenNumber implements Iterator{
    private final int[] array;
    private int iter = 0;

    IteratorEvenNumber(int[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        boolean result = false;
        if ((array.length > iter) && ()){
            result = true;
        }
        return result;
    }

    public Object next() {
        while (array[iter] %2 != 0){
            iter++;
        }
        Object object = array[iter];
        iter = iter + 1;
        return object;
    }

    public void remove() {

    }


}
