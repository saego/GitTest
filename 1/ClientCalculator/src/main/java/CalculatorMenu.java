import java.util.HashMap;
import java.util.Map;

/**
 *Created by Saego on 04.05.2017.
 */
public class CalculatorMenu {
    /**
     * Input method.
     */
    private  Input input;
    /**
     * Calculator obj.
     */
    private Calculator calculator;
    /**
     * Map of calculate actions.
     */
    Map<String, Action> actionMap = new HashMap<String, Action>();
    /**
     * Using result as a first param.
     */
    boolean useResult = false;
    /**
     * First value of calculation.
     */
    double firstValue;
    /**
     * Second value of calculation.
     */
    double secondValue;
    /**
     * Result of calculation.
     */
    double result;

    /**
     * Initialization keys of actions.
     */
    public void fillCalcActions(){
        actionMap.put("+", new Add());
        actionMap.put("-", new Sub());
        actionMap.put("*", new Multipl());
        actionMap.put("/", new Divide());
    }

    /**
     * Menu constructor.
     * @param input - input method.
     * @param calculator - calculator.
     */
    public CalculatorMenu(Input input, Calculator calculator) {
        this.input = input;
        this.calculator = calculator;
    }

    /**
     * Choose operation from map.
     * @param answer - type of operation.
     */
    public void chooseOperation(String answer){
        if (this.actionMap.containsKey(answer)){
            this.actionMap.get(answer).execute();
        }
        else {
            System.out.println("Invalid operation!");
        }
    }

    public double getFirst(){
        if (useResult){
            this.firstValue = this.result;
        }
        else {
            this.firstValue = Double.parseDouble(input.ask("Input first value"));
        }
        return this.firstValue;
    }

    public double getSecond(){
        this.secondValue = Double.parseDouble(input.ask("Input second value"));
        return this.secondValue;
    }

    /**
     * Addition.
     */
    private class Add implements Action {
        /**
         * Action.
         * @return - name.
         */
        public String actionName() {
            return "Adding";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s math operation", actionName());
        }

        /**
         * Do action.
         */
        public void execute() {
            calculator.add(firstValue, secondValue);
            result = calculator.getResult();
        }
    }

    /**
     * Subtraction.
     */
    private class Sub implements Action {
        /**
         * Action.
          * @return - name.
         */
        public String actionName() {
            return "Subtracting";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s math operation", actionName());
        }

        /**
         * Do action.
         */
        public void execute() {
            calculator.sub(firstValue, secondValue);
            result = calculator.getResult();
        }
    }

    /**
     * Multiplication.
     */
    private class Multipl implements Action {
        /**
         * Action.
         * @return - name.
         */
        public String actionName() {
            return "Multiplying";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s math operation", actionName());
        }

        /**
         * Do action.
         */
        public void execute() {
            calculator.multiply(firstValue, secondValue);
            result = calculator.getResult();
        }
    }

    /**
     * Dividing.
     */
    private class Divide implements Action {
        /**
         * Action.
         * @return - name.
         */
        public String actionName() {
            return "Dividing";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s math operation", actionName());
        }

        /**
         * Do action.
         */
        public void execute() {
            calculator.div(firstValue, secondValue);
            result = calculator.getResult();
        }
    }
}
