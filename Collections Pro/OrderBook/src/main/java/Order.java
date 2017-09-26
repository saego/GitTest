/**
 * Created by Saego on 04.09.2017.
 */
class Order {
    private Book book;
    private boolean operation;
    private float price;
    private int volume;
    //int orderId;

    Order(Book book, boolean operation, float price, int volume) {
        this.book = book;
        this.operation = operation;
        this.price = price;
        this.volume = volume;
    //    this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "book=" + book +
                ", operation=" + operation +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }
}
