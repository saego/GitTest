/**
 * Created by ${Ruslan} on 23.07.2016.
 */
package factorial;


public class Factorial {
    int value;
    int resFactorial = 1;

    public Factorial(int value) {
        this.value = value;
    }

    public int calculateFactorial(){
        for (int i = 1; i <= this.value; i++){
            resFactorial = resFactorial * i;
        }
        return resFactorial;
    }

    public boolean validatoinFactorial(){
        boolean validFlag = false;
        if(value > 0){
            validFlag = true;
        }
        return validFlag;
    }

}
