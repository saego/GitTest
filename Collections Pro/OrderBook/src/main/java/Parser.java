import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Saego on 15.09.2017.
 */
class Parser {
    void stAXParser(String fileXML) throws FileNotFoundException {
        File xml = new File(fileXML);
        XMLInputFactory factory =XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(xml));
            int event = reader.getEventType();
            boolean n = true;
            while(n){
                System.out.println("Event : " + event);
                switch (event){
                    case XMLStreamConstants.START_DOCUMENT: // = 7
                        System.out.println("---------Encoding: " + reader.getEncoding());
                        break;
                    case XMLStreamConstants.START_ELEMENT: // = 1
                        System.out.println("---------Name : " + reader.getName() + " // " + "Local name : " + reader.getLocalName());
                        if (!reader.getLocalName().equals("Orders")){
                            System.out.println("____________________________________");
                            System.out.println("Attribute name : " + reader.getAttributeLocalName(0));
                            System.out.println("Attribute value : " + reader.getAttributeValue(0));
                            System.out.println("Attribute name : " + reader.getAttributeLocalName(1));
                            System.out.println("Attribute value : " + reader.getAttributeValue(1));
                            System.out.println("Attribute name : " + reader.getAttributeLocalName(2));
                            System.out.println("Attribute value : " + reader.getAttributeValue(2));
                            System.out.println("Attribute name : " + reader.getAttributeLocalName(3));
                            System.out.println("Attribute value : " + reader.getAttributeValue(3));
                            System.out.println("Attribute name : " + reader.getAttributeLocalName(4));
                            System.out.println("Attribute value : " + reader.getAttributeValue(4));
                            System.out.println("____________________________________");
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS: // = 4
                        //System.out.println("Text : " + reader.getText());
                        System.out.println("*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$*#$");
                        break;
                    case XMLStreamConstants.END_ELEMENT: // = 2
                        System.out.println("---------Name : " + reader.getName() + " // " + "Local name : " + reader.getLocalName());
                        break;
                    case XMLStreamConstants.END_DOCUMENT: // = 8
                        System.out.println("---------Encoding: " + reader.getEncoding());
                        n = false;
                        break;
                }
                if (n) {
                    event = reader.next();
                }
                else reader.close();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
