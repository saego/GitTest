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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
