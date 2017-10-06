import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
    private OrderManager manager = new OrderManager();
    private Set<Book> booksTest = new HashSet<Book>();
    private List<Order> ordersTest = new ArrayList<Order>();
    private List<Order> testOrd0 = new ArrayList<Order>();
    private List<Order> testOrd1 = new ArrayList<Order>();
    private List<Order> testOrd2 = new ArrayList<Order>();

    @Before
    public void setUp() throws Exception {
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
        testOrd0.add(order3);
        testOrd0.add(order5);
        testOrd1.add(order2);
        testOrd2.add(order1);
        testOrd2.add(order4);
        testOrd2.add(order6);
        testOrd2.add(order7);

    }

    @Test
    public void addOrder() throws Exception {
        this.manager.addOrder(new Book("book-1"), "bid", (float) 32.14, 12, 4444);
        this.manager.addOrder(new Book("book-1"), "bid", (float) 32.4, 1, 4445);
        Map<Integer, Order> testOrders = new HashMap<Integer, Order>();
        testOrders.put(4444,new Order(new Book("book-1"), true, (float) 32.14, 12));
        testOrders.put(4445, new Order(new Book("book-1"), true, (float) 32.4, 1));
        assertThat(this.manager.getOrders(), is(testOrders));
    }

    @Test
    public void removeOrder() throws Exception {
        this.manager.addOrder(new Book("book-1"), "bid", (float) 32.14, 12, 4444);
        this.manager.addOrder(new Book("book-1"), "bid", (float) 32.4, 11, 4445);
        this.manager.addOrder(new Book("book-2"), "bid", (float) 2.14, 14, 4446);
        this.manager.addOrder(new Book("book-3"), "ask", (float) 34.4, 14, 4447);
        this.manager.removeOrder(new Book("book-1"), 4445);
        Map<Integer, Order> testOrders = new HashMap<Integer, Order>();
        testOrders.put(4444,new Order(new Book("book-1"), true, (float) 32.14, 12));
        testOrders.put(4446, new Order(new Book("book-2"), true, (float) 2.14, 14));
        testOrders.put(4447, new Order(new Book("book-3"), false, (float) 34.4, 14));
        assertThat(this.manager.getOrders(), is(testOrders));
    }

    @Test
    public void calculatingProcess() throws Exception {
    }

    @Test
    public void getSetOfBooks() throws Exception {
    }
    @Test
    public void getListOfBookOrders() throws Exception {
        List<List<Order>> test = new ArrayList<List<Order>>();
        test.add(this.testOrd0);
        test.add(this.testOrd1);
        test.add(this.testOrd2);
        List<List<Order>> orders = this.manager.getListOfBookOrders(this.booksTest, this.ordersTest);
        assertThat(test, is(orders));
    }

    @Test
    public void getListOfListOfTree() throws Exception {
        List<List<Order>> orders = this.manager.getListOfBookOrders(this.booksTest, this.ordersTest);
        this.manager.getListOfListOfTree(orders);
    }

    @org.junit.Test
    public void xMLReader() throws Exception {
    }

}
