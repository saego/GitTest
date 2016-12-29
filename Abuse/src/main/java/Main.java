import java.io.FileOutputStream;
import java.io.IOException;

/**
 Created by ${Ruslan} on 29.12.16.
 */
public class Main {
    public static void main(String []args) throws IOException {
        Abuse abuse = new Abuse();
        String []wordToDel = new String[]{"abuse"};
        abuse.dropAbuses(System.in, FileOutputStream(), wordToDel);
    }
}
