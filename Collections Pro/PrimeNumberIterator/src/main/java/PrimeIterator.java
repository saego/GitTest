import java.util.Iterator;

/**
 *Created by Saego on 23.06.2017.
 */
public class PrimeIterator implements Iterator{

    private final int[] array;
    private int iterator = 0;

    public PrimeIterator(int[] array) {
        this.array = array;
    }

    private boolean ifHasNextPrime(){
        boolean result = false;
        for (int i = iterator; i < array.length; i++){
            if (checkDivNumbers(array[i])){
                result = true;
                iterator = i;
                break;
            }
        }
        return result;
    }

    private boolean checkDivNumbers(int n){
        boolean tmpRes = true;
        for (int i = 2; i <= n / 2; i++){
            if (n % i == 0){
                tmpRes = false;
                break;
            }
        }
        return tmpRes;
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }

    public void remove() {

    }
}
