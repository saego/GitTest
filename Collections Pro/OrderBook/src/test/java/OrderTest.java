import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Saego on 03.10.2017.
 */
public class OrderTest {
    private Order order;

    @Before
    public void setUp(){
        this.order = new Order(new Book("Robinzon"), true, 12, 14);
    }

    @Test
    public void getBook() throws Exception {
        assertThat(this.order.getBook(), is(new Book("Robinzon")));
    }

    @Test
    public void isOperation() throws Exception {
        assertThat(this.order.isOperation(), is(true));
    }


    @Test
    public void getPrice() throws Exception {
        assertThat(this.order.getPrice(), is((float) 12));
    }

    @Test
    public void getVolume() throws Exception {
        assertThat(this.order.getVolume(), is(14));
    }

    @Test
    public void setVolume() throws Exception {
        order.setVolume(23);
        assertThat(this.order.getVolume(), is(23));
    }

}