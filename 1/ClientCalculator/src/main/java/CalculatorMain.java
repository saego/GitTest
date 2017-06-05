/**
 *Created by Saego on 05.05.2017.
 */
public class CalculatorMain {

    public static void main(String []args){
        Calculator calculator = new Calculator();
        Input input = new ConsoleInput();
        CalculatorMenu calculatorMenu = new CalculatorMenu(input, calculator);
        calculatorMenu.fillCalcActions();
        boolean exit = false;
        while (!exit) {
            calculatorMenu.getFirst();
            String operator = calculatorMenu.getOperator();
            calculatorMenu.getSecond();
            calculatorMenu.chooseOperation(operator);
            System.out.println(" = " + calculatorMenu.getResult());
            //System.out.println("Exit? y/n");
            exit = input.ask("Exit? y/n").toLowerCase().equals("y");
            if (!exit) {
                calculatorMenu.ifUseResAsFirstData();
            }
        }
        //calculatorMenu.chooseOperation(calculatorMenu.getOperator());
    }
}
