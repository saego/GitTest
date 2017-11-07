package CamelDSL;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class Customer extends RouteBuilder implements InitializingBean, CamelContextAware {
    public CamelContext getCamelContext() {
        return camelContext;
    }

    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;

    }

    public void afterPropertiesSet() throws Exception {
        if (camelContext != null) {
            // setup a timer to send the cafe order
            camelContext.addRoutes(this);
        }
    }

    @Override
    public void configure() throws Exception {
        from("timer://myTimer?fixedRate=true&period=60000")
                .process(new Processor() {

                    public void process(Exchange exchange) throws Exception {
                        Order order = new Order(2);
                        order.addItem(DrinkType.ESPRESSO, 2, true);
                        order.addItem(DrinkType.LATTE, 4, false);
                        exchange.getIn().setBody(order);
                    }
                })
                .to("direct:cafe");

    }
