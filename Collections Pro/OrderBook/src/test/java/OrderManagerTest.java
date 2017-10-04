import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by Saego on 03.10.2017.
 */
public class OrderManagerTest {
    private Book book1 = new Book("book-1");
    private Book book2 = new Book("book-2");
    private Book book3 = new Book("book-3");
    private Order order1 = new Order(new Book("book-1"), true, (float) 32.14, 12);
    private Order order2 = new Order(new Book("book-2"), true, (float) 6.04, 33);
    private Order order3 = new Order(new Book("book-3"), true, (float) 3.14, 20);
    private Order order4 = new Order(new Book("book-1"), false, (float) 32.14, 8);
    private Order order5 = new Order(new Book("book-3"), true, (float) 2.14, 800);
    private Order order6 = new Order(new Book("book-1"), false, (float) 32.4, 421);
    private Order order7 = new Order(new Book("book-1"), true, (float) 30.24, 937);
    OrderManager manager = new OrderManager();
    @Test
    public void getListOfBookOrders() throws Exception {
        Set<Book> booksTest = new HashSet<Book>();
        List<Order> ordersTest = new ArrayList<Order>();
        booksTest.add(book1);
        booksTest.add(book2);
        booksTest.add(book3);
        ordersTest.add(order1);
        ordersTest.add(order2);
        ordersTest.add(order3);
        ordersTest.add(order4);
        ordersTest.add(order5);
        ordersTest.add(order6);
        ordersTest.add(order7);
        List<Order> testOrd0 = new ArrayList<Order>();
        List<Order> testOrd1 = new ArrayList<Order>();
        List<Order> testOrd2 = new ArrayList<Order>();
        testOrd0.add(order3);
        testOrd0.add(order5);
        testOrd1.add(order2);
        testOrd2.add(order1);
        testOrd2.add(order4);
        testOrd2.add(order6);
        testOrd2.add(order7);
        List<List<Order>> test = new ArrayList<List<Order>>();
        test.add(testOrd0);
        test.add(testOrd1);
        test.add(testOrd2);
        List<List<Order>> orders = manager.getListOfBookOrders(booksTest, ordersTest);
        assertThat(test, is(orders));
    }

    @org.junit.Test
    public void xMLReader() throws Exception {
    }

}