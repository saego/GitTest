/**
 *Created by Saego on 05.05.2017.
 */
public class CalculatorMain {

    public static void main(String []args){
        Calculator calculator = new Calculator();
        Input input = new ConsoleInput();
        CalculatorMenu calculatorMenu = new CalculatorMenu(input, calculator);
        calculatorMenu.fillCalcActions();
        calculatorMenu.getFirst();
        String operator = calculatorMenu.getOperator();
        calculatorMenu.getSecond();
        calculatorMenu.chooseOperation(operator);
        System.out.println(" = " + calculatorMenu.getResult());
    }
}
