import java.util.Iterator;

/**
 *Created by Saego on 23.06.2017.
 */
public class PrimeIterator implements Iterator{

    private final int[] array;
    private int iterator = 0;

    PrimeIterator(int[] array) {
        this.array = array;
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

    private boolean ifHasNextPrime(){
        boolean result = false;
        for (int i = iterator; i < array.length; i++){
            if ((this.checkDivNumbers(array[i])) && array[i] != 1){
                result = true;
                iterator = i;
                break;
            }
        }
        return result;
    }

    public boolean hasNext() {
        return (array.length > iterator) && (ifHasNextPrime());
    }

    public Object next() {
        if (this.ifHasNextPrime()) {
            return array[iterator++];
        }
        else throw  new IndexOutOfBoundsException();
    }

    public void remove() {

    }
}
