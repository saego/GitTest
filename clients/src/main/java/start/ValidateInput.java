package start;

/**
    Created by Ruslan on 11.12.2016.
 */
public class ValidateInput extends ConsoleInput{
//validating key
    public int inputData(String select, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.inputData(select, range);
                invalid = false;
            }
            catch (MenuOutException moe){
                System.out.println("Select in range");
            }
            catch (NumberFormatException nfe){
                System.out.println("Incorrect format of number");
            }
        }while (invalid);
        return value;
    }
}
