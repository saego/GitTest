package start;

/**
 Created by ${Ruslan} on 12.10.16.

 */
public class StubInput implements Input{
    private String []answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String inputData(String question) {
        return answers[position++];
    }
}
