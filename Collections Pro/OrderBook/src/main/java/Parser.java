import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    void dOMParser(String fileXML) throws IOException, SAXException {
        File xml = new File(fileXML);
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(xml);
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            System.out.println(root.getNodeName());
            //System.out.println(books.getLength());
            for (int i = 0; i < books.getLength(); i++){
                if (books.item(i).hasAttributes()) {
                System.out.println("############ " + books.item(i).getNodeName());
                    NamedNodeMap nodeMap = books.item(i).getAttributes();
                    for (int n = 0; n < nodeMap.getLength(); n++) {
                        System.out.println("Attribute " + (n + 1) + ") " + " : " + nodeMap.item(n).getNodeName() + " = " + nodeMap.item(n).getNodeValue());
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
