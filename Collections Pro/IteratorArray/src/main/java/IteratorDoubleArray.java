import java.util.Iterator;

/**
 Created by Saego on 19.06.2017.
 */
public class IteratorDoubleArray implements Iterator{
    private final int [][] array;
    private int iteratorI = 0;
    private int iteratorJ = 0;

    IteratorDoubleArray(int[][] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return array.length > iteratorI;
    }

    public Object next() {
        Object obj = null;
        if ((iteratorJ != array[iteratorI].length)){
            obj = array[iteratorI][iteratorJ];
            iteratorJ++;
        }
        if ((iteratorI != array.length) && (iteratorJ == array[iteratorI].length)){
        //else{
            iteratorJ = 0;
            iteratorI++;
            //obj = null;
            //next();
        }
        return obj;
    }
}
