import java.io.IOException;

/**
 Created by ${Ruslan} on 28.12.16.
 */
public class Main {
    public static void main(String []args) throws IOException {
        Stream stream = new Stream();
        System.out.println("Input data: ");
        stream.isNumber(System.in);
    }
}
