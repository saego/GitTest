import java.io.FileNotFoundException;

/**
 * Created by Saego on 26.09.2017.
 */
public class Start {

    public static void main(String[] args) throws FileNotFoundException {
    OrderManager manager = new OrderManager();
    //String fileName = "d:\\HDD\\Hard_HDD\\orders.xml";
    String fileName = "C:\\Users\\user\\IdeaProjects\\RepositBasic\\Collections Pro\\OrderBook\\src\\main\\java\\Examples\\books.xml";
    //    String fileName = "/Users/macbook/IdeaProjects/RepositBasic/Collections Pro/OrderBook/src/main/java/Examples/books.xml";
    manager.xMLReader(fileName);
    }
}
