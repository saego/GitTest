import java.io.FileNotFoundException;

/**
 * Created by Saego on 26.09.2017.
 */
public class Start {

    public static void main(String[] args) throws FileNotFoundException {
    OrderManager manager = new OrderManager();
    manager.xMLReader("d:\\HDD\\Hard_HDD\\orders.xml");
    manager.output();
    }
}
