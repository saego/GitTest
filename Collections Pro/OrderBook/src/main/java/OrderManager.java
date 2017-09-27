import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Saego on 25.09.2017.
 */
class OrderManager {
    //Order order;
    private Map<Integer, Order> orders = new HashMap<Integer, Order>();

    /**
     * @param fileName
     * @throws FileNotFoundException
     */
    void xMLReader(String fileName) throws FileNotFoundException {
        File xmlFile = new File(fileName);
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(new FileInputStream(xmlFile));
            int event = streamReader.getEventType();
            boolean n = true;
            while (n){
                switch (event){
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Process started....   " + "Encoding: " + streamReader.getEncoding());
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        if (!streamReader.getLocalName().equals("Orders")) {
                            if (streamReader.getLocalName().equals("AddOrder")) {
                                addOrder(new Book(streamReader.getAttributeValue(0)), streamReader.getAttributeValue(1).equals("BUY") ? "bid" : "ask",
                                        Float.valueOf(streamReader.getAttributeValue(2)), Integer.valueOf(streamReader.getAttributeValue(3)),
                                        Integer.valueOf(streamReader.getAttributeValue(4)));

                            }
                            else {
                                removeOrder(new Book(streamReader.getAttributeValue(0)), Integer.valueOf(streamReader.getAttributeValue(1)));
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        n = false;
                        break;
                }
                if (n){
                    event = streamReader.next();
                }
                else streamReader.close();
            }
            streamReader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param book
     * @param ask
     * @param price
     * @param volume
     * @param orderId
     * @return
     */
    private Map<Integer, Order> addOrder(Book book, String ask, float price, int volume, int orderId){
        this.orders.put(orderId, new Order(book, ask.equals("bid"),price, volume));
        return this.orders;
    }

    /**
     * @param book
     * @param orderId
     * @return
     */
    private Map<Integer, Order> removeOrder(Book book, int orderId){
        if (this.orders.containsKey(orderId)){
            if (this.orders.get(orderId).getBook().equals(book)) {
                this.orders.remove(orderId);
            }
        }
        return this.orders;
    }

    /**
     *
     */
    void output(){
        System.out.println("_______________________________");
        for (Order order:
             this.orders.values()) {
            System.out.println("_______________________________");
            System.out.println(order);
        }
    }
    void calculatingProcess(Map<Integer, Order> orders){
        List<TreeSet<Order>> trees = new ArrayList<TreeSet<Order>>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.addAll(this.orders.values());
        for (int i = 0; i < orderList.size() - 1; i++){
            for (int n = i + 1; n < orderList.size(); n++){
                if (orderList.get(i).getBook().equals(orderList.get(n).getBook())){

                }
            }
        }
    }
}
