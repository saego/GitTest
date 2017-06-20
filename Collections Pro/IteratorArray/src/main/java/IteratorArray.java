import java.util.Iterator;

/**
 Created by Saego on 19.06.2017.
 */
public class IteratorArray implements Iterator{
    private int [][] array;
    private int iteratorI = 0;
    private int getIteratorJ = 0;

    public IteratorArray(int[][] array) {
        this.array = array;
    }


    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }
}
