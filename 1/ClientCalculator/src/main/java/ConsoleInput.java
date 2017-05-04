import java.util.Scanner;

/**
 *Created by Saego on 04.05.2017.
 */
public class ConsoleInput implements Input{
    /**
     * Console reader.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Chat with client.
     * @param question - question.
     * @return - answer.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
