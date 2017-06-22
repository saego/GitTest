import java.util.Iterator;
/**
 *Created by Saego on 21.06.2017.
 */
public class IteratorEvenNumber implements Iterator{
    private final int[] array;
    private int ice = 0;

    IteratorEvenNumber(int[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        boolean result = false;
        if ((array.length > ice) & (checkNextEven())){
            result = true;
        }
        return result;
    }

    public Object next() {
        while (array[ice] % 2 != 0){
            ice++;
        }
        Object object = array[ice];
        ice = ice + 1;
        return object;
    }

    private boolean checkNextEven(){
        boolean res = false;
        for (int i = ice; i < array.length; i++){
            if (array[i] % 2 == 0){
                res = true;
                break;
            }
        }
        return res;
    }

    public void remove() {

    }


}
