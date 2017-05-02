import java.util.Scanner;

/**
 Created by Saego on 17.04.2017.
 */
class SearchCommand {
    private String key;
    private String value;

    void readCommand(String command){
        Scanner scanner = new Scanner(command);
        while (scanner.hasNext()){
            if (scanner.hasNext()){
                this.key = scanner.next();
            }
            if (scanner.hasNext()){
                this.value = scanner.next();
            }
        }
        //System.out.println(key);
        //System.out.println(value);
    }

    String getKey() {
        return this.key;
    }

    String getValue() {
        return this.value;
    }
}
