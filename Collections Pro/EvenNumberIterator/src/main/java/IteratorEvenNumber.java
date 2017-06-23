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

    private boolean checkNextEven(){
        boolean res = false;
        for (int i = this.ice; i < this.array.length; i++){
            if (this.array[i] % 2 == 0){
                res = true;
                break;
            }
        }
        return res;
    }

    public boolean hasNext() {
        boolean result = false;
        if ((this.array.length > this.ice) & (this.checkNextEven())){
            result = true;
        }
        return result;
    }

    public Object next() {
        while (this.array[this.ice] % 2 != 0){
            this.ice++;
        }
        Object object = array[this.ice];
        this.ice = this.ice + 1;
        return object;
    }

    public void remove() {

    }


}
