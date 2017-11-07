import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {
    public static void main(String[] args) throws Exception {
        MyRouteBuilder myRouteBuilder = new MyRouteBuilder();
        CamelContext ctx = new DefaultCamelContext();

        try {
            //System.setProperty("javax.xml.bind.JAXBContentFactory"
            //        ,"");
            ctx.addRoutes(myRouteBuilder);
            ctx.start();
            Thread.sleep(3 * 60 * 1000);
            ctx.stop();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
