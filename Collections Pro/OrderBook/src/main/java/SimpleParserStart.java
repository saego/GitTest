import java.io.FileNotFoundException;

/**
 * Created by Saego on 14.09.2017.
 */
public class SimpleParserStart {
    public static void main(String[] args) throws FileNotFoundException {
        Parser parser = new Parser();
        parser.stAXParser("d:\\HDD\\Hard_HDD\\orders.xml");
    }
}
