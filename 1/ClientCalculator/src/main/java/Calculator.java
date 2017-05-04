/**
 * Created by Saego on 04.05.2017.
 */
public class Calculator {
    /**
     * Result of calculation value.
     */
    private double result;

    /**
     * Addition values.
     * @param first
     * @param second
     */
    public void add(double first, double second){
        this.result = first + second;
    }

    /**
     * Multiply values.
      * @param first
     * @param second
     */
    public void multiply(double first, double second){
        this.result = first * second;
    }

    /**
     * Divide values.
      * @param first
     * @param second
     */
    public void div(double first, double second){
        this.result = first / second;
    }

    /**
     * Subscription values.
     * @param first
     * @param second
     */
    public void sub(double first, double second){
        this.result = first - second;
    }
}
