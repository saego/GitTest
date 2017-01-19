import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 Created by ${Ruslan} on 17.01.17.
 */
public class MainChat {
    public static void main(String[] args) throws FileNotFoundException {
    WorkChat chat = new WorkChat();
    File answers = new File("answers.txt");
    File logs = new File("logs.txt");
    try {
        System.out.println("Start chatting :");
        chat.chatting(answers, logs, System.in);
    }
    catch (IOException ex){
        System.out.println(ex.getMessage());
    }
    }
}
