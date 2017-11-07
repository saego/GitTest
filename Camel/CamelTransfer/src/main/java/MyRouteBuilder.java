import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.format.

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/Users/macbook/IdeaProjects/RepositBasic/Camel/CamelTransfer/tmp/input?noop=true")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "transformContent(${body})")
                .process(new MyResultProcessor())
                .to("file:/Users/macbook/IdeaProjects/RepositBasic/Camel/CamelTransfer/tmp/output");


        from("direct:marshal")
                .marshal().xmljson()
    }

}
