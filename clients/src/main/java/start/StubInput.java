package start;

/**
 Created by ${Ruslan} on 12.10.16.

 */
public class StubInput implements Input{
    private String []answers;
    private int position = 0;

    StubInput(String[] answers) {
        this.answers = answers;
    }

    public String inputData(String question) {
        return answers[position++];
    }

    public int inputData(String question, int[] range) {
        return 0;
    }
}
