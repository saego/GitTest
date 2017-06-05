import java.util.HashMap;
import java.util.Map;

/**
 *Created by Saego on 04.05.2017.
 */
class CalculatorMenu {
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
    private Map<String, Action> actionMap = new HashMap<String, Action>();
    /**
     * Using result as a first param.
     */
    private boolean useResult = false;
    /**
     * First value of calculation.
     */
    private double firstValue;
    /**
     * Second value of calculation.
     */
    private double secondValue;
    /**
     * Result of calculation.
     */
    private double result;

    /**
     * Initialization keys of actions.
     */
    void fillCalcActions(){
        actionMap.put("+", new Add());
        actionMap.put("-", new Sub());
        actionMap.put("*", new Multipl());
        actionMap.put("/", new Divide());
        actionMap.put("ur", new UseResult());
        actionMap.put("help", new Help());
    }

    /**
     * Menu constructor.
     * @param input - input method.
     * @param calculator - calculator.
     */
    CalculatorMenu(Input input, Calculator calculator) {
        this.input = input;
        this.calculator = calculator;
    }

    /**
     * Choose operation from map.
     * @param answer - type of operation.
     */
    void chooseOperation(String answer){
        if (this.actionMap.containsKey(answer)){
            this.actionMap.get(answer).execute();
        }
        else {
            System.out.println("Invalid operation!");
        }
    }

    /**
     * Get first value of calculation.
     * @return - first value.
     */
    void getFirst(){
        if (useResult){
            this.firstValue = this.result;
            System.out.println("First value: " + this.firstValue );
        }
        else {
            this.firstValue = Double.parseDouble(input.ask("Input first value"));
        }
    }

    /**
     * Question if use result as first data
     */
    void ifUseResAsFirstData(){
        useResult = input.ask("Save result").equals("y");
    }
    /**
     * Get second value of calculation
     * @return - second value.
     */
    void getSecond(){
        this.secondValue = Double.parseDouble(input.ask("Input second value"));
    }

    /**
     * Get operator of calculation.
     * @return - operator.
     */
    String getOperator(){
        /*
      Operator of calculation.
     */
        return input.ask("Input operator");
    }

    double getResult(){
        return this.result;
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
            return "+";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s Adding math operation", this.actionName());
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
            return "-";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s Subtracting math operation", this.actionName());
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
            return "*";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s Multiplying math operation", this.actionName());
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
            return "/";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s Dividing math operation", this.actionName());
        }

        /**
         * Do action.
         */
        public void execute() {
            calculator.div(firstValue, secondValue);
            result = calculator.getResult();
        }
    }

    /**
     * If use previous result as a fist parameter.
     */
    private class UseResult implements Action {
        /**
         * Action.
         * @return - name.
         */
        public String actionName() {
            return "ur";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s If you want to use last result as a first operand", this.actionName());
        }

        /**
         * Do action.
         */
        public void execute() {
            useResult = true;
        }
    }

    /**
     * Help message.
     */
    private class Help implements Action {
        /**
         * Action.
          * @return - name.
         */
        public String actionName() {
            return "help";
        }

        /**
         * Action.
         * @return - info about current action.
         */
        public String actionInfo() {
            return String.format(" %s Help keys", this.actionName());
        }

        /**
         * Do action.
         */
        public void execute() {
            //System.out.println("help");
            for (Map.Entry<String, Action> act:
                 actionMap.entrySet()) {
                System.out.println(act.getValue().actionInfo());
            }
        }
    }
}
