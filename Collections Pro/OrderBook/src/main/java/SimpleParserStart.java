import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Created by Saego on 14.09.2017.
 */
public class SimpleParserStart {
    public static void main(String[] args) throws IOException, SAXException {
        Parser parser = new Parser();
        String xml = "d:\\HDD\\Hard_HDD\\orders.xml";
        //parser.stAXParser(xml);
        //xml = "C:\\Users\\user\\IdeaProjects\\RepositBasic\\Collections Pro\\OrderBook\\src\\main\\java\\books.xml";
        parser.dOMParser(xml);
    }
}
