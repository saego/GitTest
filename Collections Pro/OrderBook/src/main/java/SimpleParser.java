import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Saego on 14.09.2017.
 */
public class SimpleParser {
    public static void main(String[] args) throws FileNotFoundException {
        File xml = new File
                ("C:\\Users\\user\\IdeaProjects\\RepositBasic\\Collections Pro\\OrderBook\\src\\main\\java\\books");
        XMLInputFactory factory =XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(xml));
            while (reader.hasNext()){
                //int event = reader.getEventType();
                //System.out.println("Event : " + event);
                switch (reader.next()){
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println(reader.getLocalName());
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (!reader.isWhiteSpace()){
                            System.out.println(reader.getText());
                            System.out.println(reader.getAttributeName(0));
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.println(reader.getLocalName());
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
