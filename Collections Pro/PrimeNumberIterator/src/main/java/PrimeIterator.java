import java.util.Iterator;

/**
 *Created by Saego on 23.06.2017.
 */
public class PrimeIterator implements Iterator{

    private final int[] array;
    private int iterator = 0;

    /**
     * Constructor.
     * @param array - input array.
     */
    PrimeIterator(int[] array) {
        this.array = array;
    }

    /**
     * Check current value is prime.
     * @param n - value of array cell.
     * @return - if divide only by 1 and n.
     */
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

    /**
     * Check if is prime number forward.
     * @return - if has prime forward.
     */
    private boolean ifHasNextPrime(){
        boolean result = false;
        for (int i = this.iterator; i < this.array.length; i++){
            if ((this.checkDivNumbers(this.array[i])) && this.array[i] != 1){
                result = true;
                this.iterator = i;
                break;
            }
        }
        return result;
    }

    /**
     *
     * @return - if has next.
     */
    public boolean hasNext() {
        return (this.array.length > this.iterator) && (this.ifHasNextPrime());
    }

    /**
     * Move cursor to next position.
     * @return next prime value.
     */
    public Object next() {
        if (this.ifHasNextPrime()) {
            return this.array[iterator++];
        }
        else throw new IndexOutOfBoundsException();
    }

    public void remove() {

    }
}
