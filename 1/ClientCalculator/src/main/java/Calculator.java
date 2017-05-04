/**
 *Created by Saego on 04.05.2017.
 */
public class Calculator {
    /**
     * Result of calculation value.
     */
    private double result;

    /**
     * Addition values.
     * @param first - first param.
     * @param second - second param.
     */
    public void add(double first, double second){
        this.result = first + second;
    }

    /**
     * Multiply values.
     * @param first - first param.
     * @param second - second param.
     */
    public void multiply(double first, double second){
        this.result = first * second;
    }

    /**
     * Divide values.
     * @param first - first param.
     * @param second - second param.
     */
    public void div(double first, double second){
        this.result = first / second;
    }

    /**
     * Subscription values.
     * @param first - first param.
     * @param second - second param.
     */
    public void sub(double first, double second){
        this.result = first - second;
    }

    /**
     * Get result of calculating.
     * @return - result of calculating.
     */
    public double getResult() {
        return result;
    }


}
