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

    public void chooseOperation(String answer){
        if (this.actionMap.containsKey(answer)){
            this.actionMap.get(answer).execute();
        }
        else {
            System.out.println("Invalid operation!");
        }
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

        }
    }
}
