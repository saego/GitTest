package start;

/**
    Created by Ruslan on 11.12.2016.
 */
public class ValidateInput extends ConsoleInput{
    public int inputData(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.inputData(question, []range);
                invalid = false;
            }
        }
        return value;
    }
}
