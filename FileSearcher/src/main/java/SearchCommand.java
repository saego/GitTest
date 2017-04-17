import java.util.Scanner;

/**
 Created by Saego on 17.04.2017.
 */
public class SearchCommand {
    private String key;
    private String value;

    public void readCommand(String command){
        Scanner scanner = new Scanner(command);
        while (scanner.hasNext()){
            if (scanner.hasNext()){
                this.key = scanner.next();
            }
            if (scanner.hasNext()){
                this.value = scanner.next();
            }
        }
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
