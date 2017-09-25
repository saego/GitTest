/**
 * Created by Saego on 04.09.2017.
 */
public class Order {
    private Book book;
    boolean operation;
    float price;
    int volume;
    int orderId;

    public Order(Book book, boolean operation, float price, int volume, int orderId) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }
}
