import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Saego on 25.09.2017.
 */
public class OrderManager {
    Order order;

    public void xMLReader(String fileName) throws FileNotFoundException {
        File xmlFile = new File(fileName);
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader streamReader = inputFactory.createXMLStreamReader(new FileInputStream(xmlFile));
            int event = streamReader.getEventType();
            boolean n = true;
            while (n){
                switch (event){
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("Process started....   " + "\n Encoding: " + streamReader.getEncoding());
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        System.out.println("Start element: " + streamReader.getLocalName());
                        if (streamReader.getAttributeLocalName(0).equals("AddOrder")) {
                            addOrder(new Book(streamReader.getAttributeValue(0)), streamReader.getAttributeValue(1).equals("BUY")? "bid": "ask",
                                    Float.valueOf(streamReader.getAttributeValue(2)), Integer.valueOf(streamReader.getAttributeValue(3)),
                                    Integer.valueOf(streamReader.getAttributeValue(4)));
                        }
                        else{
                            removeOrder(new Book(streamReader.getAttributeValue(0)), Integer.valueOf(streamReader.getAttributeValue(1)));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println("End element");
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
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }
    public void addOrder(Book book, String ask, float price, int volume, int orderId){

    }
    public void removeOrder(Book book, int orderId){

    }
}
