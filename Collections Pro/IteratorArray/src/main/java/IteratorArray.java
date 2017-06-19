import java.util.Iterator;

/**
 Created by Saego on 19.06.2017.
 */
public class IteratorArray implements Iterator{
    private int [][] array;
    private int iterator = 0;

    public IteratorArray(int[][] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return (array[0].length > iterator) && (array[1].length > iterator);
    }

    public Object next() {
        if (iterator < array[0].length){
            return array[0][iterator++];
        }
        else  ;
    }
}
